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
import org.java0.quantity.Quantity;
import org.java0.quantity.QuantityQuotient;
import org.java0.unit.InverseUnit;
import org.java0.unit.Unit;
import org.java0.unit.UnitQuotient;

/**
 * The Class UnitQuotientImpl.
 * 
 * @author Hugh Eaves
 * @param <UNIT_1>
 *            the generic type
 * @param <UNIT_2>
 *            the generic type
 */
public class UnitQuotientImpl<COMBINED_QUANTITY extends QuantityQuotient<QUANTITY_1, QUANTITY_2>, QUANTITY_1 extends Quantity, QUANTITY_2 extends Quantity>
        extends BinaryUnitImpl<COMBINED_QUANTITY, QUANTITY_1, QUANTITY_2>
        implements UnitQuotient<COMBINED_QUANTITY, QUANTITY_1, QUANTITY_2> {

    /** The Constant logger. */
    private static final Logger logger = Logger
            .getLogger(UnitQuotientImpl.class.getName());

    /** The Constant logUtil. */
    private static final LogUtil logUtil = new LogUtil(logger);

    /**
     * Instantiates a new unit quotient impl.
     * 
     * @param unit1
     *            the unit1
     * @param unit2
     *            the unit2
     */
    public UnitQuotientImpl(Unit<QUANTITY_1> unit1, Unit<QUANTITY_2> unit2) {
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
    @Override
    public UnitQuotient<COMBINED_QUANTITY, QUANTITY_1, QUANTITY_2> getSystemUnit() {
        if (isSystemUnit()) {
            return this;
        } else {
            return new UnitQuotientImpl<COMBINED_QUANTITY, QUANTITY_1, QUANTITY_2>(
                    unit1.getSystemUnit(), unit2.getSystemUnit());
        }
    }

    /**
     * @see org.java0.unit.UnitQuotient#multiplyAndCancel2(org.java0.unit.Unit)
     */
    @Override
    public Unit<QUANTITY_1> multiplyAndCancel2(Unit<QUANTITY_2> unit) {
        return null;
    }

    /**
     * @see org.java0.unit.UnitQuotient#divideAndCancel2(org.java0.unit.InverseUnit)
     */
    @Override
    public Unit<QUANTITY_1> divideAndCancel2(InverseUnit<QUANTITY_2> unit) {
        return null;
    }

    /**
     * @see org.java0.unit.UnitQuotient#multiplyAndCancel1(org.java0.unit.InverseUnit)
     */
    @Override
    public Unit<QUANTITY_2> multiplyAndCancel1(InverseUnit<QUANTITY_1> unit) {
        return null;
    }

    /**
     * @see org.java0.unit.UnitQuotient#divideAndCancel1(org.java0.unit.Unit)
     */
    @Override
    public Unit<QUANTITY_2> divideAndCancel1(Unit<QUANTITY_1> unit) {
        return null;
    }

}