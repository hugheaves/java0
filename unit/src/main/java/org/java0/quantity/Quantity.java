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
package org.java0.quantity;

import org.java0.unit.Unit;

/**
 * TODO Fix sucky docs...
 * 
 * Represents an Quantity as measured in a specific Unit.
 * 
 * @author Hugh Eaves
 * 
 * @param <T>
 *            the type of the measurement / value
 * @param <U>
 *            the Unit type of this Quantity type.
 */
public interface Quantity<T, U extends Unit<T, ?>> {
    /**
     * Returns the Unit for this Quantity.
     * 
     * @return the Unit for this Quantity.
     */
    public U unit();

    /**
     * Returns the value of this Quantity, expressed in the given Unit.
     * 
     * @param unit
     *            the unit in which the value of this Quantity should be
     *            expressed.
     * @return the value of this Quantity, expressed in the given Unit.
     */
    public <A extends U> T value(A unit);

    /**
     * Returns the value of this Quantity expressed in its Unit.
     * 
     * @return
     */
    public T value();
}
