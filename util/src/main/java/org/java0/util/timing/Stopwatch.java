/*
 * Copyright (C) 2015  Hugh Eaves
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.java0.util.timing;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

import org.java0.collection.tuple.ThreeTuple;
import org.java0.core.type.AbstractNamedObject;
import org.java0.logging.Level;
import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class Stopwatch.
 *
 * @author Hugh Eaves
 */
public final class Stopwatch extends AbstractNamedObject {

    /** The Constant logger. */
    private static final Logger logger = LoggerFactory.getLogger(Stopwatch.class);

    private long elapsedTimeAtStart;
    private long cpuTimeAtStart;
    private long userTimeAtStart;

    private long currentElapsedTime;
    private long currentCpuTime;
    private long currentUserTime;

    private long totalElapsedTime;
    private long totalCpuTime;
    private long totalUserTime;

    private long loggerTime;

    /** The level. */
    private Level level = Level.INFO;

    /**
     * Create a new Stopwatch.
     *
     */
    public Stopwatch() {
        this("Stopwatch");
    }

    /**
     * Instantiates a new stopwatch.
     *
     * @param name
     *            the name
     */
    public Stopwatch(final String name) {
        super(name);
    }

    /**
     * Instantiates a new stopwatch.
     *
     * @param name
     *            the name
     * @param level
     *            the level
     */
    public Stopwatch(final String name, final Level level) {
        super(name);
        this.level = level;
    }

    /**
     * Starts the timer.
     *
     * Start.
     */
    public void start() {
        final ThreeTuple<Long, Long, Long> times = getTimes();

        elapsedTimeAtStart = times.get0();
        cpuTimeAtStart = times.get1();
        userTimeAtStart = times.get2();

        currentElapsedTime = 0;
        currentCpuTime = 0;
        currentUserTime = 0;

        logInternal(level, "START");
    }

    /**
     *
     * Logs the current time information to the log using the default level.
     */
    public void log() {
        log(level, "log");

    }

    /**
     * Logs the current time information to the log using the default level with
     * the given message.
     *
     * @param message
     *            the message
     */
    public void log(final String message) {
        log(level, message);

    }

    /**
     * Logs the current time information to the log using the given level.
     *
     * @param level
     *            the level
     */
    public void log(final Level level) {
        log(level, "log");

    }

    /**
     * Logs the current time information to the log using the given level and
     * message.
     *
     * @param level
     *            the level
     * @param message
     *            the message
     */
    public void log(final Level level, final String message) {
        updateTimes();

        if (elapsedTimeAtStart == 0) {
            logger.warn("Error: Stopwatch log() called wihout start()");
            return;
        }

        logInternal(level, message);
    }

    private void logInternal(final Level level, final String message) {
        logger.log(level, "Stopwatch [{}] - {} - elapsed = {}/{}ms, cpu = {}/{}ms, user = {}/{}ms, system = {}/{}ms",
                name, message, toMS(currentElapsedTime), toMS(totalElapsedTime), toMS(currentCpuTime),
                toMS(totalCpuTime), toMS(currentUserTime), toMS(totalUserTime), toMS(currentCpuTime - currentUserTime),
                toMS(totalCpuTime - totalUserTime));
    }

    /**
     * Stops the timer.
     */
    public void stop() {
        if (elapsedTimeAtStart == 0) {
            logger.warn("Error: Stopwatch stop() called wihout start()");
            return;
        }

        updateTimes();

        totalElapsedTime = totalElapsedTime + currentElapsedTime;
        totalCpuTime += currentCpuTime;
        totalUserTime += currentUserTime;

        logInternal(level, "STOP");

        elapsedTimeAtStart = 0;
    }

    private ThreeTuple<Long, Long, Long> getTimes() {
        final long elapsedTimeNow = System.nanoTime();

        long cpuTimeNow = 0;
        long userTimeNow = 0;
        final ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        if (threadMXBean.isThreadCpuTimeSupported()) {
            final long[] threadIds = threadMXBean.getAllThreadIds();
            for (final long threadId : threadIds) {
                final long threadCpuTime = threadMXBean.getThreadCpuTime(threadId);
                final long threadUserTime = threadMXBean.getThreadUserTime(threadId);
                if (threadCpuTime >= 0) {
                    cpuTimeNow += threadCpuTime;
                }
                if (threadUserTime >= 0) {
                    userTimeNow += threadUserTime;
                }
            }
        }

        return new ThreeTuple<>(elapsedTimeNow, cpuTimeNow, userTimeNow);
    }

    public void updateTimes() {
        final ThreeTuple<Long, Long, Long> times = getTimes();

        currentElapsedTime = times.get0() - elapsedTimeAtStart;
        currentCpuTime = times.get1() - cpuTimeAtStart;
        currentUserTime = times.get2() - userTimeAtStart;
    }

    private long toMS(final long value) {
        return value / 1000000;
    }

    /**
     * Reset.
     */
    public void reset() {
        log(level, "reset");

        elapsedTimeAtStart = 0;
        currentElapsedTime = 0;
        totalElapsedTime = 0;

        cpuTimeAtStart = 0;
        currentCpuTime = 0;
        totalCpuTime = 0;

        userTimeAtStart = 0;
        currentUserTime = 0;
        totalUserTime = 0;

        loggerTime = 0;
    }
}
