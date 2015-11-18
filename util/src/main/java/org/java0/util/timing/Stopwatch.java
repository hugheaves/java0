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
	private static final Logger logger = LoggerFactory
			.getLogger(Stopwatch.class);

	/** The start time. */
	private long startTime;

	/** The total time. */
	private long totalTime;

	/** The elapsed time. */
	private long elapsedTime;

	/** The system time. */
	private long systemTime;

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
	public Stopwatch(String name) {
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
	public Stopwatch(String name, Level level) {
		super(name);
		this.level = level;
	}

	/**
	 * Starts the timer.
	 *
	 * Start.
	 */
	public void start() {
		logger.log(level, "Stopwatch [{}] - START - (current total = {}ms)",
				name, totalTime / 1000000);
		startTime = System.nanoTime();
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
	public void log(String message) {
		log(level, message);

	}

	/**
	 * Logs the current time information to the log using the given level.
	 *
	 * @param level
	 *            the level
	 */
	public void log(Level level) {
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
	public void log(Level level, String message) {
		long logStartTime = System.nanoTime();

		logger.log(level,
				"Stopwatch [{}] - {} - elapsed = {}ms (current total = {}ms)",
				name, message, elapsedTime / 1000000, totalTime / 1000000);

		systemTime += System.nanoTime() - logStartTime;
	}

	/**
	 * Stops the timer.
	 */
	public void stop() {
		long stopTime = System.nanoTime();
		if (startTime == 0) {
			logger.warn("Error: Stopwatch stop() called wihout start()");
			return;
		}
		elapsedTime = stopTime - startTime;
		totalTime = totalTime + elapsedTime;
		logger.log(level,
				"Stopwatch [{}] - STOP - elapsed = {}ms (new total = {}ms)",
				name, elapsedTime / 1000000, totalTime / 1000000);
		startTime = System.nanoTime();
	}

	/**
	 * Reset.
	 */
	public void reset() {
		log(level, "reset");
		startTime = 0;
		totalTime = 0;
		elapsedTime = 0;
		systemTime = 0;
	}
}
