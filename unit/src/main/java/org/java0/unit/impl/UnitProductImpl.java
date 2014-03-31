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
import org.java0.unit.Unit;
import org.java0.unit.UnitProduct;

/**
 * @author Hugh Eaves
 * 
 */
public class UnitProductImpl<UNIT_1_TYPE extends Unit<?, ?>, UNIT_2_TYPE extends Unit<?, ?>>
        extends
        BinaryUnitImpl<UNIT_1_TYPE, UNIT_2_TYPE, UnitProduct<UNIT_1_TYPE, UNIT_2_TYPE>>
        implements UnitProduct<UNIT_1_TYPE, UNIT_2_TYPE>

{
    public UnitProductImpl(UNIT_1_TYPE unit1, UNIT_2_TYPE unit2) {
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
        Number value1 = unit1.convertFromSystem(value);
        Number value2 = unit2.convertFromSystem(value1);
        return value2;
    }

    /**
     * @see org.java0.unit.Unit#getSystemUnit()
     */
    @SuppressWarnings("unchecked")
    @Override
    public UnitProduct<UNIT_1_TYPE, UNIT_2_TYPE> getSystemUnit() {
        if (isSystemUnit()) {
            return this;
        } else {
            return new UnitProductImpl<UNIT_1_TYPE, UNIT_2_TYPE>(
                    (UNIT_1_TYPE) unit1.getSystemUnit(),
                    (UNIT_2_TYPE) unit2.getSystemUnit());
        }
    }

    /**
     * @see org.java0.unit.UnitProduct#multiplyAndCancel2(org.java0.unit.InverseUnit)
     */
    @Override
    public UNIT_1_TYPE multiplyAndCancel2(InverseUnit<?, ?> unit) {
        return unit1;
    }

    /**
     * @see org.java0.unit.UnitProduct#multiplyAndCancel1(org.java0.unit.InverseUnit)
     */
    @Override
    public UNIT_2_TYPE multiplyAndCancel1(InverseUnit<?, ?> unit) {
        return unit2;
    }

    /**
     * @see org.java0.unit.UnitProduct#divideAndCancel2(org.java0.unit.Unit)
     */
    @Override
    public UNIT_1_TYPE divideAndCancel2(UNIT_2_TYPE unit) {
        return unit1;
    }

    /**
     * @see org.java0.unit.UnitProduct#divideAndCancel1(org.java0.unit.Unit)
     */
    @Override
    public UNIT_2_TYPE divideAndCancel1(UNIT_1_TYPE unit) {
        return unit2;
    }
}