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
package org.java0.unit;

import org.java0.core.type.NamedObject;

/**
 * @author Hugh Eaves
 * 
 */
public interface Unit<T, U extends Unit<T, ? super U>> extends NamedObject {
    /**
     * Returns the system unit compatible with this Unit.
     * 
     * @return the system unit compatible with this Unit.
     */
    public U getSystemUnit();

    /**
     * Returns whether or not this unit is a system unit.
     * 
     * @return true if this unit is a system unit.
     */
    boolean isSystemUnit();

    /**
     * Converts a value in this unit type, to a value in the system unit type.
     * 
     * @param value
     * @return
     */
    public T convertToSystem(T value);

    /**
     * Converts a value in the system unit type, to a value in this unit type.
     * 
     * @param value
     * @return
     */
    public T convertFromSystem(T value);
}
