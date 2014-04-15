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


/**
 * The Class DaysUnit.
 * 
 * @author Hugh Eaves
 */
public final class DaysUnit extends TimeUnit {

    /** The Constant INSTANCE. */
    public static final DaysUnit INSTANCE = new DaysUnit();

    /**
     * Instantiates a new days unit.
     */
    public DaysUnit() {
        super("days", 86400);
    }

    /**
     * Convert from time unit.
     * 
     * @param unit
     *            the unit
     * @return the java.util.concurrent. time unit
     * @see org.java0.unit.time.TimeUnit#convertFromTimeUnit(org.java0.unit.time.TimeUnit)
     */
    @Override
    public java.util.concurrent.TimeUnit convertFromTimeUnit(TimeUnit unit) {
        return java.util.concurrent.TimeUnit.DAYS;
    }
}
