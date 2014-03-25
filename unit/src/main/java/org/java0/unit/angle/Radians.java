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
 */
package org.java0.unit.angle;

/**
 * @author Hugh Eaves
 *
 */
public final class Radians extends AngleUnit {
	public static final Radians INSTANCE = new Radians();
	
	private static final double TO_SYSTEM_UNIT_CONVERSION_FACTOR = 1.0;

	public Radians() {
		super(TO_SYSTEM_UNIT_CONVERSION_FACTOR);
	}
}