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

import org.java0.quantity.Numeric;
import org.java0.quantity.NumericQuotient;
import org.java0.unit.InverseUnit;
import org.java0.unit.NumericUnit;
import org.java0.unit.NumericUnitQuotient;
import org.java0.unit.Unit;

/**
 * @author Hugh Eaves
 * 
 */
public class NumericQuotientImpl<U1 extends NumericUnit<? super U1>, U2 extends NumericUnit<? super U2>>
        extends NumericImpl<NumericUnitQuotient<U1, U2>> implements
        NumericQuotient<U1, U2> {
    @SuppressWarnings("unused")
    private static final Logger logger = Logger
            .getLogger(NumericQuotientImpl.class.getName());

    /**
     * Create a new AbstractNumericQuantityQuotient.
     * 
     * @param value
     * @param unit
     */
    public NumericQuotientImpl(
            Number value,
            Unit<Number, ? extends NumericUnitQuotient<? extends U1, ? extends U2>> unit) {
        super(value, (NumericUnitQuotient<U1, U2>) unit);
    }

    /**
     * @see org.java0.quantity.NumericQuotient#multiplyAndCancelDenominator(org.java0.quantity.Numeric)
     */
    @Override
    public Numeric<U1> multiplyAndCancelDenominator(Numeric<U2> unit) {
        return null;
    }

    /**
     * @see org.java0.quantity.NumericQuotient#divideAndCancelDenominator(org.java0.quantity.Numeric)
     */
    @Override
    public Numeric<U1> divideAndCancelDenominator(Numeric<InverseUnit<U2>> unit) {
        return null;
    }

    /**
     * @see org.java0.quantity.NumericQuotient#multiplyAndCancelNumerator(org.java0.quantity.Numeric)
     */
    @Override
    public Numeric<U2> multiplyAndCancelNumerator(Numeric<InverseUnit<U1>> unit) {
        return null;
    }

    /**
     * @see org.java0.quantity.NumericQuotient#divideAndCancelNumerator(org.java0.quantity.Numeric)
     */
    @Override
    public Numeric<U2> divideAndCancelNumerator(Numeric<U1> unit) {
        return null;
    }
}
