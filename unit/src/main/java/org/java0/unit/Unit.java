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

// TODO: Auto-generated Javadoc
/**
 * The Interface Unit.
 * 
 * @author Hugh Eaves
 * @param <VALUE_TYPE>
 *            the generic type
 * @param <U>
 *            the generic type
 */
public interface Unit<VALUE_TYPE, UNIT_TYPE extends Unit<VALUE_TYPE, ?>>
        extends NamedObject {
    /**
     * Returns the system unit compatible with this Unit.
     * 
     * @return the system unit compatible with this Unit.
     */
    public UNIT_TYPE getSystemUnit();

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
     *            the value
     * @return the t
     */
    public VALUE_TYPE convertToSystem(VALUE_TYPE value);

    /**
     * Converts a value in the system unit type, to a value in this unit type.
     * 
     * @param value
     *            the value
     * @return the t
     */
    public VALUE_TYPE convertFromSystem(VALUE_TYPE value);
}
