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
import org.java0.quantity.NumericProduct;
import org.java0.unit.InverseUnit;
import org.java0.unit.NumericUnit;
import org.java0.unit.NumericUnitProduct;

/**
 * @author Hugh Eaves
 * 
 */
public class NumericProductImpl<U1 extends NumericUnit<?>, U2 extends NumericUnit<?>>
        extends NumericImpl<NumericUnitProduct<U1, U2>> implements
        NumericProduct<U1, U2> {
    @SuppressWarnings("unused")
    private static final Logger logger = Logger
            .getLogger(NumericProductImpl.class.getName());

    /**
     * Create a new NumericProductImpl.
     * 
     * @param value
     * @param unit
     */
    public NumericProductImpl(Number value, NumericUnitProduct<U1, U2> unit) {
        super(value, unit);
    }

    /**
     * @see org.java0.quantity.NumericProduct#multiplyAndCancelRight(org.java0.quantity.Numeric)
     */
    @Override
    public Numeric<U1> multiplyAndCancelRight(Numeric<InverseUnit<U2>> unit) {
        return null;
    }

    /**
     * @see org.java0.quantity.NumericProduct#multiplyAndCancelLeft(org.java0.quantity.Numeric)
     */
    @Override
    public Numeric<U2> multiplyAndCancelLeft(Numeric<InverseUnit<U1>> unit) {
        return null;
    }

    /**
     * @see org.java0.quantity.NumericProduct#divideAndCancelRight(org.java0.quantity.Numeric)
     */
    @Override
    public Numeric<U1> divideAndCancelRight(Numeric<U2> unit) {
        return null;
    }

    /**
     * @see org.java0.quantity.NumericProduct#divideAndCancelLeft(org.java0.quantity.Numeric)
     */
    @Override
    public Numeric<U2> divideAndCancelLeft(Numeric<U1> unit) {
        return null;
    }

}
