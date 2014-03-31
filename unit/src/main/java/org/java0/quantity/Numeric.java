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

import org.java0.unit.NumericUnit;

/**
 * @author Hugh Eaves
 * 
 */
public interface Numeric<UNIT_TYPE extends NumericUnit<?>> extends
        Quantity<Number, UNIT_TYPE>
/* , org.unitsofmeasurement.quantity.Quantity<NumericQuantity<U>> */{

    /**
     * Subtracts the given quantity from this one.
     * 
     * @param quantity
     * @return
     */
    public Numeric<UNIT_TYPE> subtract(Numeric<UNIT_TYPE> quantity);

    /**
     * Adds the given quantity to this one.
     * 
     * @param quantity
     * @return
     */
    public Numeric<UNIT_TYPE> add(Numeric<UNIT_TYPE> quantity);

    /**
     * Multiplies the given quantity by this one.
     * 
     * @param quantity
     * @return
     */
    public <LOWER_BOUND extends NumericUnit<?>, QUANTITY_TYPE extends Numeric<LOWER_BOUND>> NumericProduct<UNIT_TYPE, LOWER_BOUND> multiply(
            QUANTITY_TYPE quantity);

    /**
     * Divides this quantity by the given one.
     * 
     * @param quantity
     * @return
     */
    public <LOWER_BOUND extends NumericUnit<?>, QUANTITY_TYPE extends Numeric<LOWER_BOUND>> NumericQuotient<UNIT_TYPE, LOWER_BOUND> divide(
            QUANTITY_TYPE quantity);

    /**
     * Returns this quantity as the specified concrete type.
     * 
     * @param type
     * @return
     */
    public <CAST_TYPE extends Numeric<UNIT_TYPE>> CAST_TYPE asType(
            Class<CAST_TYPE> type);

    /**
     * @see org.java0.quantity.Quantity#unit()
     */
    @Override
    public UNIT_TYPE unit();
}
