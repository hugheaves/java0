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
package org.java0.quantity.impl;

import java.util.logging.Logger;

import org.java0.quantity.Quantity;
import org.java0.quantity.QuantityQuotient;
import org.java0.unit.InverseUnit;
import org.java0.unit.Unit;
import org.java0.unit.UnitQuotient;

/**
 * @author Hugh Eaves
 * 
 */
public class QuantityQuotientImpl<UNIT_1 extends Unit<UNIT_1>, UNIT_2 extends Unit<UNIT_2>>
        extends QuantityImpl<UnitQuotient<UNIT_1, UNIT_2>> implements
        QuantityQuotient<UNIT_1, UNIT_2> {

    @SuppressWarnings("unused")
    private static final Logger logger = Logger
            .getLogger(QuantityQuotientImpl.class.getName());

    /**
     * Create a new AbstractNumericQuantityQuotient.
     * 
     * @param value
     * @param unit
     */
    public QuantityQuotientImpl(Number value, UnitQuotient<UNIT_1, UNIT_2> unit) {
        super(value, unit);
    }

    /**
     * @see org.java0.quantity.QuantityQuotient#multiplyAndCancelDenominator(org.java0.quantity.Quantity)
     */
    @Override
    public Quantity<UNIT_1> multiplyAndCancelDenominator(Quantity<UNIT_2> unit) {
        return null;
    }

    /**
     * @see org.java0.quantity.QuantityQuotient#divideAndCancelDenominator(org.java0.quantity.Quantity)
     */
    @Override
    public Quantity<UNIT_1> divideAndCancelDenominator(
            Quantity<InverseUnit<UNIT_2>> unit) {
        return null;
    }

    /**
     * @see org.java0.quantity.QuantityQuotient#multiplyAndCancelNumerator(org.java0.quantity.Quantity)
     */
    @Override
    public Quantity<UNIT_2> multiplyAndCancelNumerator(
            Quantity<InverseUnit<UNIT_1>> unit) {
        return null;
    }

    /**
     * @see org.java0.quantity.QuantityQuotient#divideAndCancelNumerator(org.java0.quantity.Quantity)
     */
    @Override
    public Quantity<UNIT_2> divideAndCancelNumerator(Quantity<UNIT_1> unit) {
        return null;
    }
}
