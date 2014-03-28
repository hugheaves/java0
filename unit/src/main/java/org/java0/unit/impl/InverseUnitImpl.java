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

/**
 * @author Hugh Eaves
 * 
 */
public class InverseUnitImpl<U extends NumericUnit<? super U>> extends
        AbstractNumericUnit<InverseUnit<U>> implements InverseUnit<U> {

    protected U targetUnit;

    /**
     * Create a new InverseImpl.
     * 
     * @param name
     */
    public InverseUnitImpl(U targetUnit) {
        super("1/" + targetUnit.getName());
        this.targetUnit = targetUnit;
    }

    /**
     * @see org.java0.unit.Unit#getSystemUnit()
     */
    @Override
    public InverseUnit<U> getSystemUnit() {
        throw new UnsupportedOperationException();
    }

    /**
     * @see org.java0.unit.Unit#isSystemUnit()
     */
    @Override
    public boolean isSystemUnit() {
        throw new UnsupportedOperationException();
    }

    /**
     * @see org.java0.unit.Unit#convertToSystem(java.lang.Object)
     */
    @Override
    public Number convertToSystem(Number value) {
        throw new UnsupportedOperationException();
    }

    /**
     * @see org.java0.unit.Unit#convertFromSystem(java.lang.Object)
     */
    @Override
    public Number convertFromSystem(Number value) {
        throw new UnsupportedOperationException();
    }

    /**
     * @see org.java0.unit.InverseUnit#uninvert()
     */
    @Override
    public U uninvert() {
        return targetUnit;
    }

}
