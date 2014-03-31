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
 * @author Hugh Eaves
 * 
 */
public interface Quantity<UNIT_TYPE extends Unit<?>> extends
        Comparable<Quantity<UNIT_TYPE>>
/* , org.unitsofmeasurement.quantity.Quantity<NumericQuantity<U>> */{

    /**
     * Subtracts the given quantity from this one.
     * 
     * @param quantity
     * @return
     */
    public Quantity<UNIT_TYPE> subtract(Quantity<UNIT_TYPE> quantity);

    /**
     * Adds the given quantity to this one.
     * 
     * @param quantity
     * @return
     */
    public Quantity<UNIT_TYPE> add(Quantity<UNIT_TYPE> quantity);

    /**
     * Multiplies the given quantity by this one.
     * 
     * @param quantity
     * @return
     */
    public <LOWER_BOUND extends Unit<?>, QUANTITY_TYPE extends Quantity<LOWER_BOUND>> QuantityProduct<UNIT_TYPE, LOWER_BOUND> multiply(
            QUANTITY_TYPE quantity);

    /**
     * Divides this quantity by the given one.
     * 
     * @param quantity
     * @return
     */
    public <LOWER_BOUND extends Unit<?>, QUANTITY_TYPE extends Quantity<LOWER_BOUND>> QuantityQuotient<UNIT_TYPE, LOWER_BOUND> divide(
            QUANTITY_TYPE quantity);

    /**
     * Returns this quantity as the specified type.
     * 
     * @param type
     * @return
     */
    public <CAST_UNIT extends UNIT_TYPE, CAST_QUANTITY extends Quantity<CAST_UNIT>> CAST_QUANTITY asType(
            Class<CAST_QUANTITY> type);

    /**
     * Returns the Unit for this Quantity.
     * 
     * @return the Unit for this Quantity.
     */
    public UNIT_TYPE unit();

    /**
     * Returns the value of this Quantity, expressed in the given Unit.
     * 
     * @param unit
     *            the unit in which the value of this Quantity should be
     *            expressed.
     * @return the value of this Quantity, expressed in the given Unit.
     */
    public <A extends UNIT_TYPE> Number value(A unit);

    /**
     * Returns the value of this Quantity expressed in its Unit.
     * 
     * @return
     */
    public Number value();

}
