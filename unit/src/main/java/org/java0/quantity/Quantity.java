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

import org.java0.unit.InverseUnit;
import org.java0.unit.Unit;


/**
 * The Interface Quantity.
 *
 * @author Hugh Eaves
 * @param <UNIT> the generic type
 */
public interface Quantity<UNIT extends Unit<UNIT>> extends
        Comparable<Quantity<UNIT>>
/* , org.unitsofmeasurement.quantity.Quantity<NumericQuantity<U>> */{

    /**
     * Subtracts the given quantity from this one.
     *
     * @param quantity the quantity
     * @return the quantity
     */
    public Quantity<UNIT> subtract(Quantity<UNIT> quantity);

    /**
     * Adds the given quantity to this one.
     *
     * @param quantity the quantity
     * @return the quantity
     */
    public Quantity<UNIT> add(Quantity<UNIT> quantity);

    /**
     * Multiplies the given quantity by this one.
     *
     * @param <PARAM_BASE_UNIT> the generic type
     * @param <PARAM_UNIT> the generic type
     * @param <PARAM_TYPE> the generic type
     * @param quantity the quantity
     * @return the quantity product
     */
    public <PARAM_BASE_UNIT extends Unit<PARAM_BASE_UNIT>, PARAM_UNIT extends Unit<PARAM_BASE_UNIT>, PARAM_TYPE extends Quantity<? extends Unit<PARAM_BASE_UNIT>>> QuantityProduct<UNIT, PARAM_BASE_UNIT> multiply(
            PARAM_TYPE quantity);

    /**
     * Divides this quantity by the given one.
     *
     * @param <PARAM_BASE_UNIT> the generic type
     * @param <PARAM_UNIT> the generic type
     * @param <PARAM_TYPE> the generic type
     * @param quantity the quantity
     * @return the quantity quotient
     */
    public <PARAM_BASE_UNIT extends Unit<PARAM_BASE_UNIT>, PARAM_UNIT extends Unit<PARAM_BASE_UNIT>, PARAM_TYPE extends Quantity<? extends Unit<PARAM_BASE_UNIT>>> QuantityQuotient<UNIT, PARAM_BASE_UNIT> divide(
            PARAM_TYPE quantity);

    /**
     * Scales this quantity by multiplying by the given amount.
     *
     * @param quantity the quantity
     * @return the quantity
     */
    public Quantity<UNIT> multiply(Number quantity);

    /**
     * Scales this quantity by dividing by the given amount.
     *
     * @param quantity the quantity
     * @return the quantity
     */
    public Quantity<UNIT> divide(Number quantity);

    /**
     * Returns the Unit for this Quantity.
     * 
     * @return the Unit for this Quantity.
     */
    public UNIT unit();

    /**
     * Returns the value of this Quantity, expressed in the given Unit.
     *
     * @param <A> the generic type
     * @param unit            the unit in which the value of this Quantity should be
     *            expressed.
     * @return the value of this Quantity, expressed in the given Unit.
     */
    public <A extends UNIT> Number value(A unit);

    /**
     * Returns the value of this Quantity expressed in its Unit.
     *
     * @return the number
     */
    public Number value();

    /**
     * Abs.
     *
     * @return the quantity
     */
    public Quantity<UNIT> abs();

    /**
     * Multiply and cancel.
     *
     * @param <PARAM_BASE_UNIT> the generic type
     * @param <PARAM_UNIT> the generic type
     * @param <PARAM_TYPE> the generic type
     * @param quantity the quantity
     * @return the number
     */
    public <PARAM_BASE_UNIT extends Unit<PARAM_BASE_UNIT>, PARAM_UNIT extends Unit<PARAM_BASE_UNIT>, PARAM_TYPE extends Quantity<? extends InverseUnit<PARAM_BASE_UNIT>>> Number multiplyAndCancel(
            PARAM_TYPE quantity);

    /**
     * Divide and cancel.
     *
     * @param <PARAM_BASE_UNIT> the generic type
     * @param <PARAM_UNIT> the generic type
     * @param <PARAM_TYPE> the generic type
     * @param quantity the quantity
     * @return the number
     */
    public <PARAM_BASE_UNIT extends Unit<PARAM_BASE_UNIT>, PARAM_UNIT extends PARAM_BASE_UNIT, PARAM_TYPE extends Quantity<? extends PARAM_BASE_UNIT>> Number divideAndCancel(
            PARAM_TYPE quantity);

}
