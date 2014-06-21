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
package org.java0.unit.time;

import org.java0.quantity.Time;
import org.java0.unit.impl.ScalableUnit;

/**
 * The Class TimeUnit.
 * 
 * @author Hugh Eaves
 */
public abstract class TimeUnit extends ScalableUnit<Time> {

    /**
     * Instantiates a new time unit.
     * 
     * @param name
     *            the name
     * @param toSystemUnitConversionFactor
     *            the to system unit conversion factor
     */
    public TimeUnit(String name, double toSystemUnitConversionFactor) {
        super(name, toSystemUnitConversionFactor);
    }

    /**
     * Gets the system unit.
     * 
     * @return the system unit
     * @see org.java0.unit.Unit#getSystemUnit()
     */
    @Override
    public TimeUnit getSystemUnit() {
        return SecondsUnit.INSTANCE;
    }

    /**
     * Convert to time unit.
     * 
     * @param unit
     *            the unit
     * @return the time unit
     */
    public static TimeUnit convertToTimeUnit(java.util.concurrent.TimeUnit unit) {
        switch (unit) {
        case DAYS:
            return DaysUnit.INSTANCE;
        case HOURS:
            return HoursUnit.INSTANCE;
        case MICROSECONDS:
            return MicrosecondsUnit.INSTANCE;
        case MILLISECONDS:
            return MillisecondsUnit.INSTANCE;
        case MINUTES:
            return MinutesUnit.INSTANCE;
        case NANOSECONDS:
            return NanosecondsUnit.INSTANCE;
        case SECONDS:
            return SecondsUnit.INSTANCE;
        default:
            return null;
        }
    }

    /**
     * Convert from time unit.
     * 
     * @return the java.util.concurrent. time unit
     */
    public abstract java.util.concurrent.TimeUnit convertFromTimeUnit();

}