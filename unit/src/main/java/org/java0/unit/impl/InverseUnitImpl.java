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
import org.java0.unit.InverseUnit;
import org.java0.unit.Unit;

/**
 * The Class InverseUnitImpl.
 * 
 * @author Hugh Eaves
 * @param <BASE_UNIT>
 *            the generic type
 */
public class InverseUnitImpl<QUANTITY extends Quantity> extends
        AbstractUnit<QUANTITY> implements InverseUnit<QUANTITY> {

    /** The target unit. */
    protected Unit<QUANTITY> targetUnit;

    /**
     * Create a new InverseImpl.
     * 
     * @param targetUnit
     *            the target unit
     */
    public InverseUnitImpl(Unit<QUANTITY> targetUnit) {
        super("1/" + targetUnit.getName());
        this.targetUnit = targetUnit;
    }

    /**
     * Gets the system unit.
     * 
     * @return the system unit
     * @see org.java0.unit.Unit#getSystemUnit()
     */
    @Override
    public Unit<QUANTITY> getSystemUnit() {
        throw new UnsupportedOperationException();
    }

    /**
     * Checks if is system unit.
     * 
     * @return true, if is system unit
     * @see org.java0.unit.Unit#isSystemUnit()
     */
    @Override
    public boolean isSystemUnit() {
        throw new UnsupportedOperationException();
    }

    /**
     * Convert to system.
     * 
     * @param value
     *            the value
     * @return the number
     * @see org.java0.unit.Unit#convertToSystem(java.lang.Object)
     */
    @Override
    public Number convertToSystem(Number value) {
        throw new UnsupportedOperationException();
    }

    /**
     * Convert from system.
     * 
     * @param value
     *            the value
     * @return the number
     * @see org.java0.unit.Unit#convertFromSystem(java.lang.Object)
     */
    @Override
    public Number convertFromSystem(Number value) {
        throw new UnsupportedOperationException();
    }

    /**
     * Uninvert.
     * 
     * @return the unit
     * @see org.java0.unit.InverseUnit#uninvert()
     */
    @Override
    public Unit<QUANTITY> uninvert() {
        return targetUnit;
    }

}
