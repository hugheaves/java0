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

import org.slf4j.Logger;
import org.slf4j.Marker;

/**
 * @author Hugh Eaves
 *
 */
public class WarnLevelLogger implements LevelLogger {
	/**
	 * @see org.java0.logging.slf4j.LevelLogger#isEnabled(org.slf4j.Logger)
	 */
	@Override
	public boolean isEnabled(Logger logger) {
		return logger.isWarnEnabled();
	}

	/**
	 * @see org.java0.logging.slf4j.LevelLogger#isEnabled(org.slf4j.Logger,
	 *      org.slf4j.Marker)
	 */
	@Override
	public boolean isEnabled(Logger logger, Marker marker) {
		return logger.isWarnEnabled(marker);
	}

	/**
	 * @see org.java0.logging.slf4j.LevelLogger#log(org.slf4j.Logger,
	 *      java.lang.String)
	 */
	@Override
	public void log(Logger logger, String msg) {
		logger.warn(msg);
	}

	/**
	 * @see org.java0.logging.slf4j.LevelLogger#log(org.slf4j.Logger,
	 *      java.lang.String, java.lang.Object)
	 */
	@Override
	public void log(Logger logger, String format, Object arg) {
		logger.warn(format, arg);
	}

	/**
	 * @see org.java0.logging.slf4j.LevelLogger#log(org.slf4j.Logger,
	 *      java.lang.String, java.lang.Object, java.lang.Object)
	 */
	@Override
	public void log(Logger logger, String format, Object arg1, Object arg2) {
		logger.warn(format, arg1, arg2);
	}

	/**
	 * @see org.java0.logging.slf4j.LevelLogger#log(org.slf4j.Logger,
	 *      java.lang.String, java.lang.Object[])
	 */
	@Override
	public void log(Logger logger, String format, Object... arguments) {
		logger.warn(format, arguments);
	}

	/**
	 * @see org.java0.logging.slf4j.LevelLogger#log(org.slf4j.Logger,
	 *      java.lang.String, java.lang.Throwable)
	 */
	@Override
	public void log(Logger logger, String msg, Throwable t) {
		logger.warn(msg, t);
	}

	/**
	 * @see org.java0.logging.slf4j.LevelLogger#log(org.slf4j.Logger,
	 *      org.slf4j.Marker, java.lang.String)
	 */
	@Override
	public void log(Logger logger, Marker marker, String msg) {
		logger.warn(marker, msg);
	}

	/**
	 * @see org.java0.logging.slf4j.LevelLogger#log(org.slf4j.Logger,
	 *      org.slf4j.Marker, java.lang.String, java.lang.Object)
	 */
	@Override
	public void log(Logger logger, Marker marker, String format, Object arg) {
		logger.warn(marker, format, arg);
	}

	/**
	 * @see org.java0.logging.slf4j.LevelLogger#log(org.slf4j.Logger,
	 *      org.slf4j.Marker, java.lang.String, java.lang.Object,
	 *      java.lang.Object)
	 */
	@Override
	public void log(Logger logger, Marker marker, String format, Object arg1,
			Object arg2) {
		logger.warn(marker, format, arg1, arg2);
	}

	/**
	 * @see org.java0.logging.slf4j.LevelLogger#log(org.slf4j.Logger,
	 *      org.slf4j.Marker, java.lang.String, java.lang.Object[])
	 */
	@Override
	public void log(Logger logger, Marker marker, String format,
			Object... arguments) {
		logger.warn(marker, format, arguments);
	}

	/**
	 * @see org.java0.logging.slf4j.LevelLogger#log(org.slf4j.Logger,
	 *      org.slf4j.Marker, java.lang.String, java.lang.Throwable)
	 */
	@Override
	public void log(Logger logger, Marker marker, String msg, Throwable t) {
		logger.warn(marker, msg, t);
	}
}
