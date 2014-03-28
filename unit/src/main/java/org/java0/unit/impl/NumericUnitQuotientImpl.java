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

import java.util.logging.Logger;

import org.java0.logging.LogUtil;
import org.java0.unit.InverseUnit;
import org.java0.unit.NumericUnit;
import org.java0.unit.NumericUnitQuotient;

/**
 * @author Hugh Eaves
 * 
 */
public class NumericUnitQuotientImpl<U1 extends NumericUnit<? super U1>, U2 extends NumericUnit<? super U2>>
        extends BinaryNumericUnitImpl<U1, U2, NumericUnitQuotient<U1, U2>>
        implements NumericUnitQuotient<U1, U2> {

    private static final Logger logger = Logger
            .getLogger(NumericUnitQuotientImpl.class.getName());
    private static final LogUtil logUtil = new LogUtil(logger);

    public NumericUnitQuotientImpl(U1 unit1, U2 unit2) {
        super("/", unit1, unit2);
    }

    @Override
    public Number convertToSystem(Number value) {
        logUtil.valuesFinest("convertToSystem", "this.unit1", this.unit1,
                "this.unit2", this.unit2, "value", value);

        double value1 = unit1.convertToSystem(value).doubleValue();

        logUtil.valuesFinest("after convertToSystem by unit1", "value1", value1);

        double value2 = unit2.convertToSystem(1).doubleValue();

        logUtil.valuesFinest("after convertToSystem by unit2", "value2", value2);

        return value1 / value2;
    }

    @Override
    public Number convertFromSystem(Number value) {
        logUtil.valuesFinest("convertFromSystem", "this.unit1", this.unit1,
                "this.unit2", this.unit2, "value", value);

        double value1 = unit1.convertFromSystem(value).doubleValue();

        logUtil.valuesFinest("after convertFromSystem by unit1", "value1",
                value1);

        double value2 = value1 / unit2.convertFromSystem(1).doubleValue();

        logUtil.valuesFinest("after convertFromSystem by unit2", "value2",
                value2);

        return value2;

    }

    /**
     * @see org.java0.unit.Unit#isSystemUnit()
     */
    @Override
    public boolean isSystemUnit() {
        return unit1.isSystemUnit() && unit2.isSystemUnit();
    }

    /**
     * @see org.java0.unit.Unit#getSystemUnit()
     */
    @Override
    public NumericUnitQuotient<U1, U2> getSystemUnit() {
        if (isSystemUnit()) {
            return this;
        } else {
            return new NumericUnitQuotientImpl<U1, U2>(
                    (U1) unit1.getSystemUnit(), (U2) unit2.getSystemUnit());
        }

    }

    /**
     * @see org.java0.unit.NumericUnitQuotient#multiplyAndCancel2(org.java0.unit.NumericUnit)
     */
    @Override
    public U1 multiplyAndCancel2(U2 unit) {
        return unit1;
    }

    /**
     * @see org.java0.unit.NumericUnitQuotient#divideAndCancel2(org.java0.unit.InverseUnit)
     */
    @Override
    public U1 divideAndCancel2(InverseUnit<U2> unit) {
        return unit1;
    }

    /**
     * @see org.java0.unit.NumericUnitQuotient#multiplyAndCancel1(org.java0.unit.InverseUnit)
     */
    @Override
    public U2 multiplyAndCancel1(InverseUnit<U1> unit) {
        return unit2;
    }

    /**
     * @see org.java0.unit.NumericUnitQuotient#divideAndCancel1(org.java0.unit.NumericUnit)
     */
    @Override
    public U2 divideAndCancel1(U1 unit) {
        return unit2;
    }

}