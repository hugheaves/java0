/*
 * Robot Java Framework
 *
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

package org.java0.unit;

public enum Color {

	RED(0), GREEN(1), BLUE(2), YELLOW(3), MAGENTA(4), ORANGE(5), WHITE(6), BLACK(
			7), PINK(8), GRAY(9), LIGHT_GRAY(10), DARK_GRAY(11), CYAN(12), BROWN(
			13), NONE(-1);

	private int colorId;

	private Color(int colorId) {
		this.colorId = colorId;
	}

	public int getColorId() {
		return colorId;
	}

	public static Color getColorForColorId(int colorId) {
		for (Color color : Color.values()) {
			if (color.getColorId() == colorId) {
				return color;
			}
		}

		return null;
	}
}
