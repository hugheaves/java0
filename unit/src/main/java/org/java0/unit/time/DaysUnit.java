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
 * @author Hugh Eaves
 * 
 */
public final class DaysUnit extends TimeUnit {
    public static final DaysUnit INSTANCE = new DaysUnit();

    public DaysUnit() {
        super("days", 86400);
    }

    /**
     * @see org.java0.unit.time.TimeUnit#convertFromTimeUnit(org.java0.unit.time.TimeUnit)
     */
    @Override
    public java.util.concurrent.TimeUnit convertFromTimeUnit(TimeUnit unit) {
        return java.util.concurrent.TimeUnit.DAYS;
    }
}