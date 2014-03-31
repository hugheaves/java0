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

import org.java0.unit.BinaryUnit;
import org.java0.unit.Unit;
import org.java0.unit.UnitProduct;

/**
 * @author Hugh Eaves
 * 
 */
public abstract class BinaryUnitImpl<UNIT_1_TYPE extends Unit<?, ?>, UNIT_2_TYPE extends Unit<?, ?>, UNIT_TYPE extends BinaryUnit<UNIT_1_TYPE, UNIT_2_TYPE, UNIT_TYPE>>
        extends AbstractUnit<UNIT_TYPE, UNIT_TYPE> implements
        BinaryUnit<UNIT_1_TYPE, UNIT_2_TYPE, UNIT_TYPE> {

    @SuppressWarnings("unused")
    private static final Logger logger = Logger.getLogger(BinaryUnitImpl.class
            .getName());

    protected UNIT_1_TYPE unit1;
    protected UNIT_2_TYPE unit2;
    protected String operator;

    /**
     * Create a new BinaryNumericUnitImpl.
     * 
     * @param name
     */
    public BinaryUnitImpl(String operator, UNIT_1_TYPE unit1, UNIT_2_TYPE unit2) {
        super("(" + unit1.getName() + " " + operator + " " + unit2.getName()
                + ")");
        this.unit1 = unit1;
        this.unit2 = unit2;
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        } else if (object == this) {
            return true;
        } else if (object instanceof UnitProduct) {
            UnitProduct<?, ?> nup = (UnitProduct<?, ?>) object;
            return (getUnit1().equals(nup.getUnit1())
                    && getUnit2().equals(nup.getUnit2()) && nup.getOperator()
                    .equals(getOperator()));
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return getUnit1().hashCode() ^ getUnit2().hashCode()
                ^ operator.hashCode();
    }

    /**
     * @see org.java0.unit.Unit#isSystemUnit()
     */
    @Override
    public boolean isSystemUnit() {
        return unit1.isSystemUnit() && unit2.isSystemUnit();
    }

    /**
     * @see org.java0.unit.BinaryUnit#getUnit1()
     */
    @Override
    public UNIT_1_TYPE getUnit1() {
        return unit1;
    }

    /**
     * @see org.java0.unit.BinaryUnit#getUnit2()
     */
    @Override
    public UNIT_2_TYPE getUnit2() {
        return unit2;
    }

    @Override
    public String getOperator() {
        return operator;
    }
}
