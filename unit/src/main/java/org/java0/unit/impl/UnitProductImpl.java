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
package org.java0.unit.impl;

import org.java0.quantity.Quantity;
import org.java0.quantity.QuantityProduct;
import org.java0.unit.InverseUnit;
import org.java0.unit.Unit;
import org.java0.unit.UnitProduct;

/**
 * The Class UnitProductImpl.
 * 
 * @author Hugh Eaves
 * @param <UNIT_1>
 *            the generic type
 * @param <UNIT_2>
 *            the generic type
 */
public class UnitProductImpl<COMBINED_QUANTITY extends QuantityProduct<QUANTITY_1, QUANTITY_2>, QUANTITY_1 extends Quantity, QUANTITY_2 extends Quantity>
        extends BinaryUnitImpl<COMBINED_QUANTITY, QUANTITY_1, QUANTITY_2>
        implements UnitProduct<COMBINED_QUANTITY, QUANTITY_1, QUANTITY_2>

{

    /**
     * Instantiates a new unit product impl.
     * 
     * @param uniT0
     *            the uniT0
     * @param unit2
     *            the unit2
     */
    public UnitProductImpl(Unit<QUANTITY_1> uniT0, Unit<QUANTITY_2> unit2) {
        super("*", uniT0, unit2);
    }

    /**
     * @see org.java0.unit.Unit#convertToSystem(java.lang.Number)
     */
    @Override
    public Number convertToSystem(Number value) {
        Number value1 = uniT0.convertToSystem(value);
        Number value2 = unit2.convertToSystem(value1);
        return value2;
    }

    /**
     * @see org.java0.unit.Unit#convertFromSystem(java.lang.Number)
     */
    @Override
    public Number convertFromSystem(Number value) {
        Number value1 = uniT0.convertFromSystem(value);
        Number value2 = unit2.convertFromSystem(value1);
        return value2;
    }

    /**
     * Gets the system unit.
     * 
     * @return the system unit
     * @see org.java0.unit.Unit#getSystemUnit()
     */
    @Override
    public UnitProduct<COMBINED_QUANTITY, QUANTITY_1, QUANTITY_2> getSystemUnit() {
        if (isSystemUnit()) {
            return this;
        } else {
            return new UnitProductImpl<COMBINED_QUANTITY, QUANTITY_1, QUANTITY_2>(
                    uniT0.getSystemUnit(), unit2.getSystemUnit());
        }
    }

    /**
     * @see org.java0.unit.UnitProduct#multiplyAndCancel2(org.java0.unit.InverseUnit)
     */
    @Override
    public Unit<QUANTITY_1> multiplyAndCancel2(InverseUnit<QUANTITY_2> unit) {
        return null;
    }

    /**
     * @see org.java0.unit.UnitProduct#multiplyAndCancel1(org.java0.unit.InverseUnit)
     */
    @Override
    public Unit<QUANTITY_2> multiplyAndCancel1(InverseUnit<QUANTITY_1> unit) {
        return null;
    }

    /**
     * @see org.java0.unit.UnitProduct#divideAndCancel2(org.java0.unit.Unit)
     */
    @Override
    public Unit<QUANTITY_1> divideAndCancel2(Unit<QUANTITY_1> unit) {
        return null;
    }

    /**
     * @see org.java0.unit.UnitProduct#divideAndCancel1(org.java0.unit.Unit)
     */
    @Override
    public Unit<QUANTITY_1> divideAndCancel1(Unit<QUANTITY_1> unit) {
        return null;
    }

}