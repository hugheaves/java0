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
import org.java0.unit.Unit;
import org.java0.unit.UnitQuotient;


/**
 * The Class UnitQuotientImpl.
 *
 * @author Hugh Eaves
 * @param <UNIT_1_TYPE> the generic type
 * @param <UNIT_2_TYPE> the generic type
 */
public class UnitQuotientImpl<UNIT_1_TYPE extends Unit<UNIT_1_TYPE>, UNIT_2_TYPE extends Unit<UNIT_2_TYPE>>
        extends
        BinaryUnitImpl<UNIT_1_TYPE, UNIT_2_TYPE, UnitQuotient<UNIT_1_TYPE, UNIT_2_TYPE>>
        implements UnitQuotient<UNIT_1_TYPE, UNIT_2_TYPE> {

    /** The Constant logger. */
    private static final Logger logger = Logger
            .getLogger(UnitQuotientImpl.class.getName());
    
    /** The Constant logUtil. */
    private static final LogUtil logUtil = new LogUtil(logger);

    /**
     * Instantiates a new unit quotient impl.
     *
     * @param unit1 the unit1
     * @param unit2 the unit2
     */
    public UnitQuotientImpl(UNIT_1_TYPE unit1, UNIT_2_TYPE unit2) {
        super("/", unit1, unit2);
    }

    /**
     * @see org.java0.unit.Unit#convertToSystem(java.lang.Number)
     */
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

    /**
     * @see org.java0.unit.Unit#convertFromSystem(java.lang.Number)
     */
    @Override
    public Number convertFromSystem(Number value) {
        logUtil.valuesFinest("convertFromSystem", "this.unit1", this.unit1,
                "this.unit2", this.unit2, "value", value);

        double value1 = unit1.convertFromSystem(value).doubleValue();

        logUtil.valuesFinest("after convertFromSystem by unit1", "value1",
                value1);

        double value2 = unit2.convertFromSystem(1).doubleValue();

        logUtil.valuesFinest("after convertFromSystem by unit2", "value2",
                value2);

        return value1 / value2;

    }

    /**
     * Checks if is system unit.
     *
     * @return true, if is system unit
     * @see org.java0.unit.Unit#isSystemUnit()
     */
    @Override
    public boolean isSystemUnit() {
        return unit1.isSystemUnit() && unit2.isSystemUnit();
    }

    /**
     * Gets the system unit.
     *
     * @return the system unit
     * @see org.java0.unit.Unit#getSystemUnit()
     */
    @SuppressWarnings("unchecked")
    @Override
    public UnitQuotient<UNIT_1_TYPE, UNIT_2_TYPE> getSystemUnit() {
        if (isSystemUnit()) {
            return this;
        } else {
            return new UnitQuotientImpl<UNIT_1_TYPE, UNIT_2_TYPE>(
                    (UNIT_1_TYPE) unit1.getSystemUnit(),
                    (UNIT_2_TYPE) unit2.getSystemUnit());
        }
    }

    /**
     * Multiply and cancel2.
     *
     * @param unit the unit
     * @return the UNI t_1_ type
     * @see org.java0.unit.UnitQuotient#multiplyAndCancel2(org.java0.unit.Unit)
     */
    @Override
    public UNIT_1_TYPE multiplyAndCancel2(UNIT_2_TYPE unit) {
        return unit1;
    }

    /**
     * Divide and cancel2.
     *
     * @param unit the unit
     * @return the UNI t_1_ type
     * @see org.java0.unit.UnitQuotient#divideAndCancel2(org.java0.unit.InverseUnit)
     */
    @Override
    public UNIT_1_TYPE divideAndCancel2(InverseUnit<UNIT_2_TYPE> unit) {
        return unit1;
    }

    /**
     * Multiply and cancel1.
     *
     * @param unit the unit
     * @return the UNI t_2_ type
     * @see org.java0.unit.UnitQuotient#multiplyAndCancel1(org.java0.unit.InverseUnit)
     */
    @Override
    public UNIT_2_TYPE multiplyAndCancel1(InverseUnit<UNIT_1_TYPE> unit) {
        return unit2;
    }

    /**
     * Divide and cancel1.
     *
     * @param unit the unit
     * @return the UNI t_2_ type
     * @see org.java0.unit.UnitQuotient#divideAndCancel1(org.java0.unit.Unit)
     */
    @Override
    public UNIT_2_TYPE divideAndCancel1(UNIT_1_TYPE unit) {
        return unit2;
    }

}