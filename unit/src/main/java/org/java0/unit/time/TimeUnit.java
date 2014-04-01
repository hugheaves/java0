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

import org.java0.unit.impl.ScalableUnit;

/**
 * @author Hugh Eaves
 * 
 */
public abstract class TimeUnit<T extends TimeUnit<?>> extends
        ScalableUnit<TimeUnit<?>, T> {

    /**
     * Create a new TimeUnit.
     * 
     * @param name
     * @param toSystemUnitConversionFactor
     */
    protected TimeUnit(String name, double toSystemUnitConversionFactor) {
        super(name, toSystemUnitConversionFactor);

    }

    @Override
    public TimeUnit<?> getSystemUnit() {
        return SecondsUnit.INSTANCE;
    }

    public static TimeUnit<?> convertFromJavaTimeUnit(
            java.util.concurrent.TimeUnit unit) {
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

    public abstract java.util.concurrent.TimeUnit convertToJavaTimeUnit();

}