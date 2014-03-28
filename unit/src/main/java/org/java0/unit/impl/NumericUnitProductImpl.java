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
package org.java0.unit.impl;

import org.java0.unit.InverseUnit;
import org.java0.unit.NumericUnit;
import org.java0.unit.NumericUnitProduct;

/**
 * @author Hugh Eaves
 * 
 */
public class NumericUnitProductImpl<U1 extends NumericUnit<? super U1>, U2 extends NumericUnit<? super U2>>
        extends BinaryNumericUnitImpl<U1, U2, NumericUnitProduct<U1, U2>>
        implements NumericUnitProduct<U1, U2>

{
    public NumericUnitProductImpl(U1 unit1, U2 unit2) {
        super("*", unit1, unit2);
    }

    @Override
    public Number convertToSystem(Number value) {
        Number value1 = unit1.convertToSystem(value);
        Number value2 = unit2.convertToSystem(value1);
        return value2;
    }

    @Override
    public Number convertFromSystem(Number value) {
        return unit1.convertFromSystem(value).doubleValue()
                * unit2.convertFromSystem(value).doubleValue();
    }

    /**
     * @see org.java0.unit.Unit#getSystemUnit()
     */
    @Override
    public NumericUnitProduct<U1, U2> getSystemUnit() {
        if (isSystemUnit()) {
            return this;
        } else {
            return new NumericUnitProductImpl<U1, U2>(
                    (U1) unit1.getSystemUnit(), (U2) unit2.getSystemUnit());
        }
    }

    /**
     * @see org.java0.unit.NumericUnitProduct#multiplyAndCancel2(org.java0.unit.InverseUnit)
     */
    @Override
    public U1 multiplyAndCancel2(InverseUnit<U2> unit) {
        return unit1;
    }

    /**
     * @see org.java0.unit.NumericUnitProduct#multiplyAndCancel1(org.java0.unit.InverseUnit)
     */
    @Override
    public U2 multiplyAndCancel1(InverseUnit<U1> unit) {
        return unit2;
    }

    /**
     * @see org.java0.unit.NumericUnitProduct#divideAndCancel2(org.java0.unit.NumericUnit)
     */
    @Override
    public U1 divideAndCancel2(U2 unit) {
        return unit1;
    }

    /**
     * @see org.java0.unit.NumericUnitProduct#divideAndCancel1(org.java0.unit.NumericUnit)
     */
    @Override
    public U2 divideAndCancel1(U1 unit) {
        return unit2;
    }

}