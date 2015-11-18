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
package org.java0.tag;

import java.util.logging.Logger;

/**
 * @author Hugh Eaves
 *
 */
public class DefaultTagComparator implements TagComparator {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger
			.getLogger(DefaultTagComparator.class.getName());

	@Override
	public int matchScore(Object a, Object b) {
		int score = Integer.MIN_VALUE;

		if (a == null || b == null) {
			if (a == b) {
				score = Integer.MAX_VALUE;
			}
		} else if (a instanceof Tag && b instanceof Tag) {
			score = compareSets((Tag) a, (Tag) b);
		} else if (a.equals(b)) {
			score = Integer.MAX_VALUE;
		}
		return score;
	}

	/**
	 * @param tagSet
	 * @param value
	 * @return
	 */
	private int compareSets(Tag a, Tag b) {
		int matches = 0;

		if (a.size() == 1 && b.size() == 1) {
			if (a.equals(b)) {
				return 1;
			} else {
				return -2;
			}
		}

		for (Tag bTag : b.getAll()) {
			if (a.getAll().contains(bTag)) {
				++matches;
			}
		}

		return (3 * matches) - a.size() - b.size();
	}
}
