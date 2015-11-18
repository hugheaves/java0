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
package org.java0.string;

/**
 * @author Hugh Eaves
 *
 */
public class ASCII {
	public static final int NUM_LETTERS = 26;

	public static final int LOWER_CASE_START = 96;
	public static final int LOWER_CASE_END = LOWER_CASE_START + NUM_LETTERS;

	public static final int UPPER_CASE_START = 64;
	public static final int UPPER_CASE_END = UPPER_CASE_START + NUM_LETTERS;

	public static final int PRINTABLE_START = 32;
	public static final int PRINTABLE_END = 127;

	public static final int NUM_CHARACTERS = 128;

	private static final int NUM_VALUES = 256;

	private static final boolean IS_LOWERCASE[] = new boolean[NUM_VALUES];
	private static final boolean IS_UPPERCASE[] = new boolean[NUM_VALUES];
	private static final boolean IS_PRINTABLE[] = new boolean[NUM_VALUES];

	static {
		for (int i = 0; i < NUM_VALUES; ++i) {
			if (i >= LOWER_CASE_START && i <= LOWER_CASE_END) {
				IS_LOWERCASE[i] = true;
			}
			if (i >= UPPER_CASE_START && i <= UPPER_CASE_END) {
				IS_LOWERCASE[i] = true;
			}
			if (i >= PRINTABLE_START && i <= PRINTABLE_END) {
				IS_PRINTABLE[i] = true;
			}
		}
	}

	public static final boolean isLowerCase(final byte ch) {
		return IS_LOWERCASE[ch & 0xff];
	}

	public static final boolean isUpperCase(final byte ch) {
		return IS_UPPERCASE[ch & 0xff];
	}

	public static final boolean isPrintable(final byte ch) {
		return IS_PRINTABLE[ch & 0xff];
	}

}
