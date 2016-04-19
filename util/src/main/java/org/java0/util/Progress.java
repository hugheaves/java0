package org.java0.util;

import org.java0.core.type.AbstractNamedObject;
import org.java0.logging.Level;
import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;
import org.java0.util.stats.TTable;

public class Progress extends AbstractNamedObject {
    private static final Logger DEFAULT_LOGGER = LoggerFactory.getLogger(Progress.class);
    private static final Level DEFAULT_LEVEL = Level.DEBUG;
    private static final String DEFAULT_NAME = "Progress";
    private static final long DEFAULT_INTERVAL = 1000;

    /** The Constant logger. */
    private final Logger logger;
    /** The level. */
    private final Level level;

    private final long logInterval;

    private long previousTime = 0;
    private long totalTime = 0;
    private long totalTimeSquared = 0;
    private long lastLogTime = 0;

    private long currentEvents = 0;
    private long totalEvents = 0;

    private long countThreshold = 0;

    private long expectedEvents = 0;

    private long numSamples = 0;

    public Progress() {
        this(DEFAULT_NAME, DEFAULT_INTERVAL, DEFAULT_LEVEL, DEFAULT_LOGGER);
    }

    public Progress(final Level level) {
        this(DEFAULT_NAME, DEFAULT_INTERVAL, level, DEFAULT_LOGGER);
    }

    public Progress(final Level level, final Logger logger) {
        this(DEFAULT_NAME, DEFAULT_INTERVAL, level, logger);
    }

    public Progress(final long interval, final Level level, final Logger logger) {
        this(DEFAULT_NAME, interval, level, logger);
    }

    public Progress(final long interval, final Level level) {
        this(DEFAULT_NAME, interval, level, DEFAULT_LOGGER);
    }

    public Progress(final String name, final long interval, final Level level, final Logger logger) {
        super(name);
        this.logger = logger;
        this.level = level;
        this.logInterval = interval;
    }

    public void mark() {
        ++currentEvents;

        if (currentEvents > countThreshold) {
            final long currentTime = System.currentTimeMillis();

            totalEvents += currentEvents;

            currentEvents = 0;

            final long elapsedTime = currentTime - previousTime;
            previousTime = currentTime;

            if (currentTime - lastLogTime > logInterval) {
                lastLogTime = currentTime;
                logCount();
            }

            // if we're not skipping events, then use the
            // elapsed time since the last mark() call to update
            // the running totals for mean / sd calculation.
            if (countThreshold == 0 && totalEvents > 1) {
                ++numSamples;
                totalTime += elapsedTime;
                totalTimeSquared += (elapsedTime * elapsedTime);
            }

            if (numSamples > 1) {
                updateCountThreshold(currentTime);
            }

        }
    }

    private void updateCountThreshold(final long currentTime) {

        final double variance = ((double) totalTimeSquared * numSamples - (totalTime * totalTime))
                / (numSamples * (numSamples - 1));

        final double sd = Math.sqrt(variance);
        final double mean = (double) totalTime / numSamples;

        final double critical = TTable.criticalValue(true, (int) numSamples - 1, 0.001);
        final double adjustedMean = mean + critical * (sd / Math.sqrt(numSamples));

        if (adjustedMean < 0) {
            countThreshold = 0;
        } else {
            final long logTimeRemaining = logInterval - (currentTime - lastLogTime);
            countThreshold = (long) (logTimeRemaining / adjustedMean);
        }

        if (countThreshold < 0) {
            countThreshold = 0;
        }

        // logger.info("numSamples = {}, mean = {}, sd = {}, meanLower = {},
        // critical = {}, countThreshold = {}",
        // numSamples, mean, sd, meanLower, critical, countThreshold);
    }

    public void logCount() {
        if (expectedEvents > 0) {
            final double percentProgress = (Math.floor((totalEvents * 1000) / (double) expectedEvents)) / 10;
            logger.log(level, "{}: {}/{} ({}%)", name, totalEvents, expectedEvents, percentProgress);
        } else {
            logger.log(level, "{}: {}", name, totalEvents);
        }

    }

    public void reset(final int expectedEvents) {
        this.expectedEvents = expectedEvents;
        previousTime = 0;
        totalTime = 0;
        totalTimeSquared = 0;
        lastLogTime = 0;
        currentEvents = 0;
        totalEvents = 0;
        countThreshold = 0;
        numSamples = 0;
    }

    public void reset() {
        reset(0);
    }

    @Override
    public void setName(final String name) {
        this.name = name;
    }

}
