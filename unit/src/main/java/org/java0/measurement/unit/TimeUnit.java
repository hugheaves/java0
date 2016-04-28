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
package org.java0.measurement.unit;

import org.java0.measurement.Units;
import org.java0.measurement.quantity.Time;

public interface TimeUnit extends BaseUnit<Time> {

    public java.util.concurrent.TimeUnit convertFromTimeUnit();

    /**
     * Convert to time unit.
     * 
     * @param unit
     *            the unit
     * @return the time unit
     */
    public static TimeUnit convertToTimeUnit(final java.util.concurrent.TimeUnit unit) {
        switch (unit) {
        case DAYS:
            return Units.DAYS;
        case HOURS:
            return Units.HOURS;
        case MICROSECONDS:
            return Units.MICROSECONDS;
        case MILLISECONDS:
            return Units.MILLISECONDS;
        case MINUTES:
            return Units.MINUTES;
        case NANOSECONDS:
            return Units.NANOSECONDS;
        case SECONDS:
            return Units.SECONDS;
        default:
            return null;
        }

    }
}
