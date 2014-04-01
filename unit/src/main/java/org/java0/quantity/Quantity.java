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
public interface Quantity<BASE_TYPE extends Unit<?, ?>, SUB_TYPE extends BASE_TYPE>
        extends Comparable<Quantity<BASE_TYPE, ?>>
/* , org.unitsofmeasurement.quantity.Quantity<NumericQuantity<U>> */{

    /**
     * Subtracts the given quantity from this one.
     * 
     * @param quantity
     * @return
     */
    public Quantity<BASE_TYPE, SUB_TYPE> subtract(
            Quantity<BASE_TYPE, ?> quantity);

    /**
     * Adds the given quantity to this one.
     * 
     * @param quantity
     * @return
     */
    public Quantity<BASE_TYPE, SUB_TYPE> add(Quantity<BASE_TYPE, ?> quantity);

    /**
     * Multiplies the given quantity by this one.
     * 
     * @param quantity
     * @return
     */
    public <LOWER_BOUND extends Unit<?, ?>, UPPER_BOUND extends LOWER_BOUND, QUANTITY_TYPE extends Quantity<LOWER_BOUND, UPPER_BOUND>> QuantityProduct<BASE_TYPE, LOWER_BOUND> multiply(
            QUANTITY_TYPE quantity);
    /**
     * Divides this quantity by the given one.
     * 
     * @param quantity
     * @return
     */
    public <LOWER_BOUND extends Unit<?, ?>, UPPER_BOUND extends LOWER_BOUND, QUANTITY_TYPE extends Quantity<LOWER_BOUND, UPPER_BOUND>> QuantityQuotient<BASE_TYPE, LOWER_BOUND> divide(
            QUANTITY_TYPE quantity);

    /**
     * Returns the Unit for this Quantity.
     * 
     * @return the Unit for this Quantity.
     */
    public BASE_TYPE unit();

    /**
     * Returns the value of this Quantity, expressed in the given Unit.
     * 
     * @param unit
     *            the unit in which the value of this Quantity should be
     *            expressed.
     * @return the value of this Quantity, expressed in the given Unit.
     */
    public <A extends BASE_TYPE> Number value(A unit);

    /**
     * Returns the value of this Quantity expressed in its Unit.
     * 
     * @return
     */
    public Number value();

}
