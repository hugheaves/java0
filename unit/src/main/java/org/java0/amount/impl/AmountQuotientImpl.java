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
package org.java0.amount.impl;

import java.util.logging.Logger;

import org.java0.amount.Amount;
import org.java0.amount.AmountQuotient;
import org.java0.amount.InverseAmount;
import org.java0.quantity.Quantity;
import org.java0.quantity.QuantityQuotient;
import org.java0.unit.UnitQuotient;

/**
 * @author Hugh Eaves
 * 
 */
public class AmountQuotientImpl<COMBINED_QUANTITY extends QuantityQuotient<QUANTITY_1, QUANTITY_2>, QUANTITY_1 extends Quantity, QUANTITY_2 extends Quantity>
        extends AmountImpl<COMBINED_QUANTITY> implements
        AmountQuotient<COMBINED_QUANTITY, QUANTITY_1, QUANTITY_2> {

    @SuppressWarnings("unused")
    private static final Logger logger = Logger
            .getLogger(AmountQuotientImpl.class.getName());

    /**
     * Create a new AbstractNumericQuantityQuotient.
     * 
     * @param value
     * @param unit
     */
    public AmountQuotientImpl(Number value,
            UnitQuotient<COMBINED_QUANTITY, QUANTITY_1, QUANTITY_2> unit) {
        super(value, unit);
    }

    @Override
    public UnitQuotient<COMBINED_QUANTITY, QUANTITY_1, QUANTITY_2> unit() {
        return (UnitQuotient<COMBINED_QUANTITY, QUANTITY_1, QUANTITY_2>) super
                .unit();
    }

    /**
     * @see org.java0.amount.AmountQuotient#multiplyAndCancelDenominator(org.java0.amount.Amount)
     */
    @Override
    public Amount<QUANTITY_1> multiplyAndCancelDenominator(
            Amount<QUANTITY_2> quantity) {
        return null;
    }

    /**
     * @see org.java0.amount.AmountQuotient#divideAndCancelDenominator(org.java0.amount.InverseAmount)
     */
    @Override
    public Amount<QUANTITY_1> divideAndCancelDenominator(
            InverseAmount<QUANTITY_2> quantity) {
        return null;
    }

    /**
     * @see org.java0.amount.AmountQuotient#multiplyAndCancelNumerator(org.java0.amount.InverseAmount)
     */
    @Override
    public Amount<QUANTITY_1> multiplyAndCancelNumerator(
            InverseAmount<QUANTITY_2> quantity) {
        return null;
    }

    /**
     * @see org.java0.amount.AmountQuotient#divideAndCancelNumerator(org.java0.amount.Amount)
     */
    @Override
    public Amount<QUANTITY_1> divideAndCancelNumerator(
            Amount<QUANTITY_1> quantity) {
        return null;
    }
}
