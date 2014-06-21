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
package org.java0.amount;

import org.java0.quantity.Quantity;
import org.java0.quantity.QuantityProduct;
import org.java0.quantity.QuantityQuotient;
import org.java0.unit.Unit;

/**
 * @author Hugh Eaves
 * 
 */
public interface Amount<QUANTITY extends Quantity> extends
        Comparable<Amount<QUANTITY>> {

    /**
     * Subtracts the given quantity from this one.
     * 
     * @param quantity
     *            the quantity
     * @return the quantity
     */
    public Amount<QUANTITY> subtract(Amount<QUANTITY> quantity);

    /**
     * Adds the given quantity to this one.
     * 
     * @param quantity
     *            the quantity
     * @return the quantity
     */
    public Amount<QUANTITY> add(Amount<QUANTITY> quantity);

    /**
     * Multiplies the given quantity by this one.
     * 
     * @param <PARAM_BASE_UNIT>
     *            the generic type
     * @param <PARAM_UNIT>
     *            the generic type
     * @param <PARAM_TYPE>
     *            the generic type
     * @param quantity
     *            the quantity
     * @return the quantity product
     */
    public <COMBINED_QUANTITY extends QuantityProduct<QUANTITY, PARAM_QUANTITY>, PARAM_QUANTITY extends Quantity> AmountProduct<COMBINED_QUANTITY, QUANTITY, PARAM_QUANTITY> multiply(
            Amount<PARAM_QUANTITY> quantity);

    /**
     * Divides this quantity by the given one.
     * 
     * @param <PARAM_BASE_UNIT>
     *            the generic type
     * @param <PARAM_UNIT>
     *            the generic type
     * @param <PARAM_TYPE>
     *            the generic type
     * @param quantity
     *            the quantity
     * @return the quantity quotient
     */
    public <COMBINED_QUANTITY extends QuantityQuotient<QUANTITY, PARAM_QUANTITY>, PARAM_QUANTITY extends Quantity> AmountQuotient<COMBINED_QUANTITY, QUANTITY, PARAM_QUANTITY> divide(
            Amount<PARAM_QUANTITY> quantity);

    /**
     * Scales this quantity by multiplying by the given amount.
     * 
     * @param quantity
     *            the quantity
     * @return the quantity
     */
    public Amount<QUANTITY> multiply(Number quantity);

    /**
     * Scales this quantity by dividing by the given amount.
     * 
     * @param quantity
     *            the quantity
     * @return the quantity
     */
    public Amount<QUANTITY> divide(Number quantity);

    /**
     * Returns the Unit for this Quantity.
     * 
     * @return the Unit for this Quantity.
     */
    public Unit<QUANTITY> unit();

    /**
     * Returns the value of this Quantity, expressed in the given Unit.
     * 
     * @param <A>
     *            the generic type
     * @param unit
     *            the unit in which the value of this Quantity should be
     *            expressed.
     * @return the value of this Quantity, expressed in the given Unit.
     */
    public <A extends QUANTITY> Number value(Unit<QUANTITY> unit);

    /**
     * Returns the value of this Quantity expressed in its Unit.
     * 
     * @return the number
     */
    public Number value();

    /**
     * Returns the absolute value of the Quantity.
     * 
     * @return the absolute value of the quantity
     */
    public Amount<QUANTITY> abs();

    /**
     * Multiply and cancel.
     * 
     * @param <PARAM_BASE_UNIT>
     *            the generic type
     * @param <PARAM_UNIT>
     *            the generic type
     * @param <PARAM_TYPE>
     *            the generic type
     * @param quantity
     *            the quantity
     * @return the number
     */
    public Number multiplyAndCancel(InverseAmount<QUANTITY> quantity);

    /**
     * Divide and cancel.
     * 
     * @param <PARAM_BASE_UNIT>
     *            the generic type
     * @param <PARAM_UNIT>
     *            the generic type
     * @param <PARAM_TYPE>
     *            the generic type
     * @param quantity
     *            the quantity
     * @return the number
     */
    public Number divideAndCancel(Amount<QUANTITY> quantity);
}
