/*
 * Copyright (C) 2015  Hugh Eaves
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
package org.java0.amount.impl;

import java.util.logging.Logger;

import org.java0.amount.Amount;
import org.java0.amount.AmountProduct;
import org.java0.amount.InverseAmount;
import org.java0.quantity.Quantity;
import org.java0.quantity.QuantityProduct;
import org.java0.unit.UnitProduct;

/**
 * @author Hugh Eaves
 * 
 */
public class AmountProductImpl<COMBINED_QUANTITY extends QuantityProduct<QUANTITY_1, QUANTITY_2>, QUANTITY_1 extends Quantity, QUANTITY_2 extends Quantity>
        extends AmountImpl<COMBINED_QUANTITY> implements
        AmountProduct<COMBINED_QUANTITY, QUANTITY_1, QUANTITY_2> {
    @SuppressWarnings("unused")
    private static final Logger logger = Logger
            .getLogger(AmountProductImpl.class.getName());

    /**
     * Create a new NumericProductImpl.
     * 
     * @param value
     * @param unit
     */
    public AmountProductImpl(Number value,
            UnitProduct<COMBINED_QUANTITY, QUANTITY_1, QUANTITY_2> unit) {
        super(value, unit);
    }

    @Override
    public UnitProduct<COMBINED_QUANTITY, QUANTITY_1, QUANTITY_2> unit() {
        return (UnitProduct<COMBINED_QUANTITY, QUANTITY_1, QUANTITY_2>) super
                .unit();
    }

    /**
     * @see org.java0.amount.AmountProduct#multiplyAndCancelRight(org.java0.amount.InverseAmount)
     */
    @Override
    public Amount<QUANTITY_1> multiplyAndCancelRight(
            InverseAmount<QUANTITY_2> quantity) {
        return null;
    }

    /**
     * @see org.java0.amount.AmountProduct#multiplyAndCancelLeft(org.java0.amount.InverseAmount)
     */
    @Override
    public Amount<QUANTITY_2> multiplyAndCancelLeft(
            InverseAmount<QUANTITY_1> quantity) {
        return null;
    }

    /**
     * @see org.java0.amount.AmountProduct#divideAndCancelRight(org.java0.amount.Amount)
     */
    @Override
    public Amount<QUANTITY_1> divideAndCancelRight(Amount<QUANTITY_2> quantity) {
        return null;
    }

    /**
     * @see org.java0.amount.AmountProduct#divideAndCancelLeft(org.java0.amount.Amount)
     */
    @Override
    public Amount<QUANTITY_2> divideAndCancelLeft(Amount<QUANTITY_1> quantity) {
        return null;
    }

}
