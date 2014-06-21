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
import org.java0.unit.UnitProduct;

/**
 * The Interface QuantityProduct.
 * 
 * @author Hugh Eaves
 * @param <UNIT_1>
 *            the generic type
 * @param <UNIT_2>
 *            the generic type
 */
public interface AmountProduct<COMBINED_QUANTITY extends QuantityProduct<QUANTITY_1, QUANTITY_2>, QUANTITY_1 extends Quantity, QUANTITY_2 extends Quantity>
        extends Amount<COMBINED_QUANTITY> {

    @Override
    public UnitProduct<COMBINED_QUANTITY, QUANTITY_1, QUANTITY_2> unit();

    /**
     * Returns this quantity with the right unit cancelled by multiplying by the
     * given quantity.
     * 
     * @param unit
     *            the unit
     * @return a unit
     */
    public Amount<QUANTITY_1> multiplyAndCancelRight(
            InverseAmount<QUANTITY_2> quantity);

    /**
     * Returns this quantity with the left unit cancelled by multiplying by the
     * given quantity.
     * 
     * @param unit
     *            the unit
     * @return a unit
     */
    public Amount<QUANTITY_2> multiplyAndCancelLeft(
            InverseAmount<QUANTITY_1> quantity);

    /**
     * Returns this quantity with the right unit cancelled by dividing by the
     * given quantity.
     * 
     * @param unit
     *            the unit
     * @return a unit
     */
    public Amount<QUANTITY_1> divideAndCancelRight(Amount<QUANTITY_2> quantity);

    /**
     * Returns this quantity with the left unit cancelled by dividing by the
     * given quantity.
     * 
     * @param unit
     *            the unit
     * @return a unit
     */
    public Amount<QUANTITY_2> divideAndCancelLeft(Amount<QUANTITY_1> quantity);
}
