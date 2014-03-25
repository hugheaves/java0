/*
 * Copyright (C) 2014  Hugh Eaves
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
 *
 */
package org.java0.util.timing;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.java0.core.type.AbstractNamedObject;

/**
 * @author Hugh Eaves
 *
 */
public final class Stopwatch extends AbstractNamedObject {
	private static final Logger logger = Logger.getLogger(Stopwatch.class
			.getName());

	private long startTime;
	private long totalTime;
	private long elapsedTime;
	private long systemTime;

	private Level level = Level.CONFIG;

	public Stopwatch(String name) {
		this.name = name;
	}

	public Stopwatch(String name, Level level) {
		this.name = name;
		this.level = level;
	}

	public void start() {
		logTimes(level, "start");
		startTime = System.nanoTime();
	}

	public void log() {
		logTimes(level, "log");

	}

	public void log(String message) {
		logTimes(level, message);

	}

	public void log(Level level) {
		logTimes(level, "log");

	}

	public void logTimes(Level level, String message) {
		long logStartTime = System.nanoTime();
		if (logger.isLoggable(level)) {
			logger.log(level, "Stopwatch [" + name + "] " + message
					+ " - elapsed time = " + (elapsedTime / 1000000) + "ms, totalTime = "
					+ (totalTime / 1000000) + "ms, system time = " + (systemTime / 1000000) + "ms");
		}
		systemTime += System.nanoTime() - logStartTime;
	}

	public void stop() {
		long stopTime = System.nanoTime();
		if (startTime == 0) {
			logger.warning("Error: Stopwatch stop() called wihout start()");
			return;
		}
		elapsedTime = stopTime - startTime;
		totalTime = totalTime + elapsedTime;
		logTimes(level, "stop");
	}

	public void reset() {
		logTimes(level, "reset");
		startTime = 0;
		totalTime = 0;
		elapsedTime = 0;
		systemTime = 0;
	}
}
