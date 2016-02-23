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
package org.java0.logging.slf4j;

import org.java0.logging.Level;
import org.slf4j.Marker;

/**
 * @author Hugh Eaves
 *
 */
public class SLF4JLogger implements Logger {
    private final org.slf4j.Logger logger;

    private static final LevelLogger[] loggers = new LevelLogger[Level.values().length];

    static {
        loggers[Level.TRACE.ordinal()] = new TraceLevelLogger();
        loggers[Level.DEBUG.ordinal()] = new DebugLevelLogger();
        loggers[Level.INFO.ordinal()] = new InfoLevelLogger();
        loggers[Level.WARN.ordinal()] = new WarnLevelLogger();
        loggers[Level.ERROR.ordinal()] = new ErrorLevelLogger();
    }

    SLF4JLogger(final org.slf4j.Logger logger) {
        this.logger = logger;
    }

    /**
     * @return
     * @see org.slf4j.Logger#getName()
     */
    @Override
    public String getName() {
        return logger.getName();
    }

    /**
     * @return
     * @see org.slf4j.Logger#isTraceEnabled()
     */
    @Override
    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }

    /**
     * @param msg
     * @see org.slf4j.Logger#trace(java.lang.String)
     */
    @Override
    public void trace(final String msg) {
        logger.trace(msg);
    }

    /**
     * @param format
     * @param arg
     * @see org.slf4j.Logger#trace(java.lang.String, java.lang.Object)
     */
    @Override
    public void trace(final String format, final Object arg) {
        logger.trace(format, arg);
    }

    /**
     * @param format
     * @param arg1
     * @param arg2
     * @see org.slf4j.Logger#trace(java.lang.String, java.lang.Object,
     *      java.lang.Object)
     */
    @Override
    public void trace(final String format, final Object arg1, final Object arg2) {
        logger.trace(format, arg1, arg2);
    }

    /**
     * @param format
     * @param arguments
     * @see org.slf4j.Logger#trace(java.lang.String, java.lang.Object[])
     */
    @Override
    public void trace(final String format, final Object... arguments) {
        logger.trace(format, arguments);
    }

    /**
     * @param msg
     * @param t
     * @see org.slf4j.Logger#trace(java.lang.String, java.lang.Throwable)
     */
    @Override
    public void trace(final String msg, final Throwable t) {
        logger.trace(msg, t);
    }

    /**
     * @param marker
     * @return
     * @see org.slf4j.Logger#isTraceEnabled(org.slf4j.Marker)
     */
    @Override
    public boolean isTraceEnabled(final Marker marker) {
        return logger.isTraceEnabled(marker);
    }

    /**
     * @param marker
     * @param msg
     * @see org.slf4j.Logger#trace(org.slf4j.Marker, java.lang.String)
     */
    @Override
    public void trace(final Marker marker, final String msg) {
        logger.trace(marker, msg);
    }

    /**
     * @param marker
     * @param format
     * @param arg
     * @see org.slf4j.Logger#trace(org.slf4j.Marker, java.lang.String,
     *      java.lang.Object)
     */
    @Override
    public void trace(final Marker marker, final String format, final Object arg) {
        logger.trace(marker, format, arg);
    }

    /**
     * @param marker
     * @param format
     * @param arg1
     * @param arg2
     * @see org.slf4j.Logger#trace(org.slf4j.Marker, java.lang.String,
     *      java.lang.Object, java.lang.Object)
     */
    @Override
    public void trace(final Marker marker, final String format, final Object arg1, final Object arg2) {
        logger.trace(marker, format, arg1, arg2);
    }

    /**
     * @param marker
     * @param format
     * @param argArray
     * @see org.slf4j.Logger#trace(org.slf4j.Marker, java.lang.String,
     *      java.lang.Object[])
     */
    @Override
    public void trace(final Marker marker, final String format, final Object... argArray) {
        logger.trace(marker, format, argArray);
    }

    /**
     * @param marker
     * @param msg
     * @param t
     * @see org.slf4j.Logger#trace(org.slf4j.Marker, java.lang.String,
     *      java.lang.Throwable)
     */
    @Override
    public void trace(final Marker marker, final String msg, final Throwable t) {
        logger.trace(marker, msg, t);
    }

    /**
     * @return
     * @see org.slf4j.Logger#isDebugEnabled()
     */
    @Override
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    /**
     * @param msg
     * @see org.slf4j.Logger#debug(java.lang.String)
     */
    @Override
    public void debug(final String msg) {
        logger.debug(msg);
    }

    /**
     * @param format
     * @param arg
     * @see org.slf4j.Logger#debug(java.lang.String, java.lang.Object)
     */
    @Override
    public void debug(final String format, final Object arg) {
        logger.debug(format, arg);
    }

    /**
     * @param format
     * @param arg1
     * @param arg2
     * @see org.slf4j.Logger#debug(java.lang.String, java.lang.Object,
     *      java.lang.Object)
     */
    @Override
    public void debug(final String format, final Object arg1, final Object arg2) {
        logger.debug(format, arg1, arg2);
    }

    /**
     * @param format
     * @param arguments
     * @see org.slf4j.Logger#debug(java.lang.String, java.lang.Object[])
     */
    @Override
    public void debug(final String format, final Object... arguments) {
        logger.debug(format, arguments);
    }

    /**
     * @param msg
     * @param t
     * @see org.slf4j.Logger#debug(java.lang.String, java.lang.Throwable)
     */
    @Override
    public void debug(final String msg, final Throwable t) {
        logger.debug(msg, t);
    }

    /**
     * @param marker
     * @return
     * @see org.slf4j.Logger#isDebugEnabled(org.slf4j.Marker)
     */
    @Override
    public boolean isDebugEnabled(final Marker marker) {
        return logger.isDebugEnabled(marker);
    }

    /**
     * @param marker
     * @param msg
     * @see org.slf4j.Logger#debug(org.slf4j.Marker, java.lang.String)
     */
    @Override
    public void debug(final Marker marker, final String msg) {
        logger.debug(marker, msg);
    }

    /**
     * @param marker
     * @param format
     * @param arg
     * @see org.slf4j.Logger#debug(org.slf4j.Marker, java.lang.String,
     *      java.lang.Object)
     */
    @Override
    public void debug(final Marker marker, final String format, final Object arg) {
        logger.debug(marker, format, arg);
    }

    /**
     * @param marker
     * @param format
     * @param arg1
     * @param arg2
     * @see org.slf4j.Logger#debug(org.slf4j.Marker, java.lang.String,
     *      java.lang.Object, java.lang.Object)
     */
    @Override
    public void debug(final Marker marker, final String format, final Object arg1, final Object arg2) {
        logger.debug(marker, format, arg1, arg2);
    }

    /**
     * @param marker
     * @param format
     * @param arguments
     * @see org.slf4j.Logger#debug(org.slf4j.Marker, java.lang.String,
     *      java.lang.Object[])
     */
    @Override
    public void debug(final Marker marker, final String format, final Object... arguments) {
        logger.debug(marker, format, arguments);
    }

    /**
     * @param marker
     * @param msg
     * @param t
     * @see org.slf4j.Logger#debug(org.slf4j.Marker, java.lang.String,
     *      java.lang.Throwable)
     */
    @Override
    public void debug(final Marker marker, final String msg, final Throwable t) {
        logger.debug(marker, msg, t);
    }

    /**
     * @return
     * @see org.slf4j.Logger#isInfoEnabled()
     */
    @Override
    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    /**
     * @param msg
     * @see org.slf4j.Logger#info(java.lang.String)
     */
    @Override
    public void info(final String msg) {
        logger.info(msg);
    }

    /**
     * @param format
     * @param arg
     * @see org.slf4j.Logger#info(java.lang.String, java.lang.Object)
     */
    @Override
    public void info(final String format, final Object arg) {
        logger.info(format, arg);
    }

    /**
     * @param format
     * @param arg1
     * @param arg2
     * @see org.slf4j.Logger#info(java.lang.String, java.lang.Object,
     *      java.lang.Object)
     */
    @Override
    public void info(final String format, final Object arg1, final Object arg2) {
        logger.info(format, arg1, arg2);
    }

    /**
     * @param format
     * @param arguments
     * @see org.slf4j.Logger#info(java.lang.String, java.lang.Object[])
     */
    @Override
    public void info(final String format, final Object... arguments) {
        logger.info(format, arguments);
    }

    /**
     * @param msg
     * @param t
     * @see org.slf4j.Logger#info(java.lang.String, java.lang.Throwable)
     */
    @Override
    public void info(final String msg, final Throwable t) {
        logger.info(msg, t);
    }

    /**
     * @param marker
     * @return
     * @see org.slf4j.Logger#isInfoEnabled(org.slf4j.Marker)
     */
    @Override
    public boolean isInfoEnabled(final Marker marker) {
        return logger.isInfoEnabled(marker);
    }

    /**
     * @param marker
     * @param msg
     * @see org.slf4j.Logger#info(org.slf4j.Marker, java.lang.String)
     */
    @Override
    public void info(final Marker marker, final String msg) {
        logger.info(marker, msg);
    }

    /**
     * @param marker
     * @param format
     * @param arg
     * @see org.slf4j.Logger#info(org.slf4j.Marker, java.lang.String,
     *      java.lang.Object)
     */
    @Override
    public void info(final Marker marker, final String format, final Object arg) {
        logger.info(marker, format, arg);
    }

    /**
     * @param marker
     * @param format
     * @param arg1
     * @param arg2
     * @see org.slf4j.Logger#info(org.slf4j.Marker, java.lang.String,
     *      java.lang.Object, java.lang.Object)
     */
    @Override
    public void info(final Marker marker, final String format, final Object arg1, final Object arg2) {
        logger.info(marker, format, arg1, arg2);
    }

    /**
     * @param marker
     * @param format
     * @param arguments
     * @see org.slf4j.Logger#info(org.slf4j.Marker, java.lang.String,
     *      java.lang.Object[])
     */
    @Override
    public void info(final Marker marker, final String format, final Object... arguments) {
        logger.info(marker, format, arguments);
    }

    /**
     * @param marker
     * @param msg
     * @param t
     * @see org.slf4j.Logger#info(org.slf4j.Marker, java.lang.String,
     *      java.lang.Throwable)
     */
    @Override
    public void info(final Marker marker, final String msg, final Throwable t) {
        logger.info(marker, msg, t);
    }

    /**
     * @return
     * @see org.slf4j.Logger#isWarnEnabled()
     */
    @Override
    public boolean isWarnEnabled() {
        return logger.isWarnEnabled();
    }

    /**
     * @param msg
     * @see org.slf4j.Logger#warn(java.lang.String)
     */
    @Override
    public void warn(final String msg) {
        logger.warn(msg);
    }

    /**
     * @param format
     * @param arg
     * @see org.slf4j.Logger#warn(java.lang.String, java.lang.Object)
     */
    @Override
    public void warn(final String format, final Object arg) {
        logger.warn(format, arg);
    }

    /**
     * @param format
     * @param arguments
     * @see org.slf4j.Logger#warn(java.lang.String, java.lang.Object[])
     */
    @Override
    public void warn(final String format, final Object... arguments) {
        logger.warn(format, arguments);
    }

    /**
     * @param format
     * @param arg1
     * @param arg2
     * @see org.slf4j.Logger#warn(java.lang.String, java.lang.Object,
     *      java.lang.Object)
     */
    @Override
    public void warn(final String format, final Object arg1, final Object arg2) {
        logger.warn(format, arg1, arg2);
    }

    /**
     * @param msg
     * @param t
     * @see org.slf4j.Logger#warn(java.lang.String, java.lang.Throwable)
     */
    @Override
    public void warn(final String msg, final Throwable t) {
        logger.warn(msg, t);
    }

    /**
     * @param marker
     * @return
     * @see org.slf4j.Logger#isWarnEnabled(org.slf4j.Marker)
     */
    @Override
    public boolean isWarnEnabled(final Marker marker) {
        return logger.isWarnEnabled(marker);
    }

    /**
     * @param marker
     * @param msg
     * @see org.slf4j.Logger#warn(org.slf4j.Marker, java.lang.String)
     */
    @Override
    public void warn(final Marker marker, final String msg) {
        logger.warn(marker, msg);
    }

    /**
     * @param marker
     * @param format
     * @param arg
     * @see org.slf4j.Logger#warn(org.slf4j.Marker, java.lang.String,
     *      java.lang.Object)
     */
    @Override
    public void warn(final Marker marker, final String format, final Object arg) {
        logger.warn(marker, format, arg);
    }

    /**
     * @param marker
     * @param format
     * @param arg1
     * @param arg2
     * @see org.slf4j.Logger#warn(org.slf4j.Marker, java.lang.String,
     *      java.lang.Object, java.lang.Object)
     */
    @Override
    public void warn(final Marker marker, final String format, final Object arg1, final Object arg2) {
        logger.warn(marker, format, arg1, arg2);
    }

    /**
     * @param marker
     * @param format
     * @param arguments
     * @see org.slf4j.Logger#warn(org.slf4j.Marker, java.lang.String,
     *      java.lang.Object[])
     */
    @Override
    public void warn(final Marker marker, final String format, final Object... arguments) {
        logger.warn(marker, format, arguments);
    }

    /**
     * @param marker
     * @param msg
     * @param t
     * @see org.slf4j.Logger#warn(org.slf4j.Marker, java.lang.String,
     *      java.lang.Throwable)
     */
    @Override
    public void warn(final Marker marker, final String msg, final Throwable t) {
        logger.warn(marker, msg, t);
    }

    /**
     * @return
     * @see org.slf4j.Logger#isErrorEnabled()
     */
    @Override
    public boolean isErrorEnabled() {
        return logger.isErrorEnabled();
    }

    /**
     * @param msg
     * @see org.slf4j.Logger#error(java.lang.String)
     */
    @Override
    public void error(final String msg) {
        logger.error(msg);
    }

    /**
     * @param format
     * @param arg
     * @see org.slf4j.Logger#error(java.lang.String, java.lang.Object)
     */
    @Override
    public void error(final String format, final Object arg) {
        logger.error(format, arg);
    }

    /**
     * @param format
     * @param arg1
     * @param arg2
     * @see org.slf4j.Logger#error(java.lang.String, java.lang.Object,
     *      java.lang.Object)
     */
    @Override
    public void error(final String format, final Object arg1, final Object arg2) {
        logger.error(format, arg1, arg2);
    }

    /**
     * @param format
     * @param arguments
     * @see org.slf4j.Logger#error(java.lang.String, java.lang.Object[])
     */
    @Override
    public void error(final String format, final Object... arguments) {
        logger.error(format, arguments);
    }

    /**
     * @param msg
     * @param t
     * @see org.slf4j.Logger#error(java.lang.String, java.lang.Throwable)
     */
    @Override
    public void error(final String msg, final Throwable t) {
        logger.error(msg, t);
    }

    /**
     * @param marker
     * @return
     * @see org.slf4j.Logger#isErrorEnabled(org.slf4j.Marker)
     */
    @Override
    public boolean isErrorEnabled(final Marker marker) {
        return logger.isErrorEnabled(marker);
    }

    /**
     * @param marker
     * @param msg
     * @see org.slf4j.Logger#error(org.slf4j.Marker, java.lang.String)
     */
    @Override
    public void error(final Marker marker, final String msg) {
        logger.error(marker, msg);
    }

    /**
     * @param marker
     * @param format
     * @param arg
     * @see org.slf4j.Logger#error(org.slf4j.Marker, java.lang.String,
     *      java.lang.Object)
     */
    @Override
    public void error(final Marker marker, final String format, final Object arg) {
        logger.error(marker, format, arg);
    }

    /**
     * @param marker
     * @param format
     * @param arg1
     * @param arg2
     * @see org.slf4j.Logger#error(org.slf4j.Marker, java.lang.String,
     *      java.lang.Object, java.lang.Object)
     */
    @Override
    public void error(final Marker marker, final String format, final Object arg1, final Object arg2) {
        logger.error(marker, format, arg1, arg2);
    }

    /**
     * @param marker
     * @param format
     * @param arguments
     * @see org.slf4j.Logger#error(org.slf4j.Marker, java.lang.String,
     *      java.lang.Object[])
     */
    @Override
    public void error(final Marker marker, final String format, final Object... arguments) {
        logger.error(marker, format, arguments);
    }

    /**
     * @param marker
     * @param msg
     * @param t
     * @see org.slf4j.Logger#error(org.slf4j.Marker, java.lang.String,
     *      java.lang.Throwable)
     */
    @Override
    public void error(final Marker marker, final String msg, final Throwable t) {
        logger.error(marker, msg, t);
    }

    /**
     * @see org.java0.logging.slf4j.Logger#isEnabled(org.java0.logging.Level)
     */
    @Override
    public boolean isEnabled(final Level level) {
        return loggers[level.ordinal()].isEnabled(logger);
    }

    /**
     * @see org.java0.logging.slf4j.Logger#isEnabled(org.java0.logging.Level,
     *      org.slf4j.Marker)
     */
    @Override
    public boolean isEnabled(final Level level, final Marker marker) {
        return loggers[level.ordinal()].isEnabled(logger, marker);
    }

    /**
     * @see org.java0.logging.slf4j.Logger#log(org.java0.logging.Level,
     *      java.lang.String)
     */
    @Override
    public boolean log(final Level level, final String msg) {
        loggers[level.ordinal()].log(logger, msg);
        return true;
    }

    /**
     * @see org.java0.logging.slf4j.Logger#log(org.java0.logging.Level,
     *      java.lang.String, java.lang.Object)
     */
    @Override
    public boolean log(final Level level, final String format, final Object arg) {
        loggers[level.ordinal()].log(logger, format, arg);
        return true;
    }

    /**
     * @see org.java0.logging.slf4j.Logger#log(org.java0.logging.Level,
     *      java.lang.String, java.lang.Object, java.lang.Object)
     */
    @Override
    public boolean log(final Level level, final String format, final Object arg1, final Object arg2) {
        loggers[level.ordinal()].log(logger, format, arg1, arg2);
        return true;
    }

    /**
     * @see org.java0.logging.slf4j.Logger#log(org.java0.logging.Level,
     *      java.lang.String, java.lang.Object[])
     */
    @Override
    public boolean log(final Level level, final String format, final Object... arguments) {
        loggers[level.ordinal()].log(logger, format, arguments);
        return true;
    }

    /**
     * @see org.java0.logging.slf4j.Logger#log(org.java0.logging.Level,
     *      java.lang.String, java.lang.Throwable)
     */
    @Override
    public boolean log(final Level level, final String msg, final Throwable t) {
        loggers[level.ordinal()].log(logger, msg, t);
        return true;
    }

    /**
     * @see org.java0.logging.slf4j.Logger#log(org.java0.logging.Level,
     *      org.slf4j.Marker, java.lang.String)
     */
    @Override
    public boolean log(final Level level, final Marker marker, final String msg) {
        loggers[level.ordinal()].log(logger, marker, msg);
        return true;
    }

    /**
     * @see org.java0.logging.slf4j.Logger#log(org.java0.logging.Level,
     *      org.slf4j.Marker, java.lang.String, java.lang.Object)
     */
    @Override
    public boolean log(final Level level, final Marker marker, final String format, final Object arg) {
        loggers[level.ordinal()].log(logger, marker, format, arg);
        return true;

    }

    /**
     * @see org.java0.logging.slf4j.Logger#log(org.java0.logging.Level,
     *      org.slf4j.Marker, java.lang.String, java.lang.Object,
     *      java.lang.Object)
     */
    @Override
    public boolean log(final Level level, final Marker marker, final String format, final Object arg1,
            final Object arg2) {
        loggers[level.ordinal()].log(logger, marker, format, arg1, arg2);
        return true;

    }

    /**
     * @see org.java0.logging.slf4j.Logger#log(org.java0.logging.Level,
     *      org.slf4j.Marker, java.lang.String, java.lang.Object[])
     */
    @Override
    public boolean log(final Level level, final Marker marker, final String format, final Object... arguments) {
        loggers[level.ordinal()].log(logger, marker, format, arguments);
        return true;
    }

    /**
     * @see org.java0.logging.slf4j.Logger#log(org.java0.logging.Level,
     *      org.slf4j.Marker, java.lang.String, java.lang.Throwable)
     */
    @Override
    public boolean log(final Level level, final Marker marker, final String msg, final Throwable t) {
        loggers[level.ordinal()].log(logger, marker, msg, t);
        return true;
    }
}
