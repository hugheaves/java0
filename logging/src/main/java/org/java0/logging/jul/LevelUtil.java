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
package org.java0.logging.jul;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Hugh Eaves
 *
 */
public class LevelUtil {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(LevelUtil.class
			.getName());

	public static final List<Level> LEVELS = Collections
			.unmodifiableList(Arrays.asList(new Level[] { Level.ALL,
					Level.FINEST, Level.FINER, Level.FINE, Level.CONFIG,
					Level.INFO, Level.WARNING, Level.SEVERE, Level.OFF }));

	public static final Comparator<Level> LEVEL_COMPARATOR = new Comparator<Level>() {
		/**
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(Level o1, Level o2) {
			if (o1.intValue() < o2.intValue()) {
				return -1;
			} else if (o1.intValue() > o2.intValue()) {
				return 1;
			} else {
				return 0;
			}
		}
	};

	/**
	 * Get the next highest logging level. If level already represents the
	 * highest logging level, then the highest logging level will be returned.
	 *
	 * @param level
	 *            the logging level for which a higher level should be found.
	 * @return
	 */
	public static Level nextHighest(Level level) {
		int position = Collections
				.binarySearch(LEVELS, level, LEVEL_COMPARATOR);

		/*
		 * If we don't have an exact match, -position points to the next highest
		 * level.
		 */
		if (position < 0) {
			position = -position;

		}
		/*
		 * If we have an exact match for the level value, we point position at
		 * the next highest level.
		 */
		else if (position < LEVELS.size() - 1) {
			position++;
		}

		Level newLevel = LEVELS.get(position);
		return newLevel;

	}

	/**
	 * Get then next lowest logging level.
	 *
	 * @param level
	 *            the logging level for which a lower level should be found. If
	 *            level already represents the lowest logging level, then the
	 *            lowest logging level will be returned.
	 *
	 * @return
	 */
	public static Level nextLowest(Level level) {
		int position = Collections
				.binarySearch(LEVELS, level, LEVEL_COMPARATOR);
		/*
		 * If we don't have an exact match, -(position+1) points to the next
		 * highest level.
		 */
		if (position < 0) {
			position = -(position + 1);

		}
		/*
		 * If we have an exact match for the level value, we point position at
		 * the next lowest level.
		 */
		else if (position > 0) {
			position--;
		}

		Level newLevel = LEVELS.get(position);
		return newLevel;
	}
}
