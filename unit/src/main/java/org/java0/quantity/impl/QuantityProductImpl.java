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
import org.java0.quantity.QuantityProduct;
import org.java0.unit.InverseUnit;
import org.java0.unit.Unit;
import org.java0.unit.UnitProduct;

/**
 * @author Hugh Eaves
 * 
 */
public class QuantityProductImpl<U1 extends Unit<?, ?>, U2 extends Unit<?, ?>>
        extends QuantityImpl<UnitProduct<U1, U2>> implements
        QuantityProduct<U1, U2> {
    @SuppressWarnings("unused")
    private static final Logger logger = Logger
            .getLogger(QuantityProductImpl.class.getName());

    /**
     * Create a new NumericProductImpl.
     * 
     * @param value
     * @param unit
     */
    public QuantityProductImpl(Number value, UnitProduct<U1, U2> unit) {
        super(value, unit);
    }

    /**
     * @see org.java0.quantity.QuantityProduct#multiplyAndCancelRight(org.java0.quantity.Quantity)
     */
    @Override
    public Quantity<U1> multiplyAndCancelRight(Quantity<InverseUnit<?, ?>> unit) {
        return null;
    }

    /**
     * @see org.java0.quantity.QuantityProduct#multiplyAndCancelLeft(org.java0.quantity.Quantity)
     */
    @Override
    public Quantity<U2> multiplyAndCancelLeft(Quantity<InverseUnit<?, ?>> unit) {
        return null;
    }

    /**
     * @see org.java0.quantity.QuantityProduct#divideAndCancelRight(org.java0.quantity.Quantity)
     */
    @Override
    public Quantity<U1> divideAndCancelRight(Quantity<U2> unit) {
        return null;
    }

    /**
     * @see org.java0.quantity.QuantityProduct#divideAndCancelLeft(org.java0.quantity.Quantity)
     */
    @Override
    public Quantity<U2> divideAndCancelLeft(Quantity<U1> unit) {
        return null;
    }

}
