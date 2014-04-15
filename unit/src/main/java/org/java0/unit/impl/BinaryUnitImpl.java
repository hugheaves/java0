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
 * The Class BinaryUnitImpl.
 *
 * @author Hugh Eaves
 * @param <UNIT_1> the generic type
 * @param <UNIT_2> the generic type
 * @param <COMBINED_UNIT> the generic type
 */
public abstract class BinaryUnitImpl<UNIT_1 extends Unit<UNIT_1>, UNIT_2 extends Unit<UNIT_2>, COMBINED_UNIT extends Unit<COMBINED_UNIT>>
        extends AbstractUnit<COMBINED_UNIT> implements
        BinaryUnit<UNIT_1, UNIT_2, COMBINED_UNIT> {

    /** The Constant logger. */
    @SuppressWarnings("unused")
    private static final Logger logger = Logger.getLogger(BinaryUnitImpl.class
            .getName());

    /** The unit1. */
    protected UNIT_1 unit1;
    
    /** The unit2. */
    protected UNIT_2 unit2;
    
    /** The operator. */
    protected String operator;

    /**
     * Create a new BinaryNumericUnitImpl.
     *
     * @param operator the operator
     * @param unit1 the unit1
     * @param unit2 the unit2
     */
    public BinaryUnitImpl(String operator, UNIT_1 unit1, UNIT_2 unit2) {
        super("(" + unit1.getName() + " " + operator + " " + unit2.getName()
                + ")");
        this.unit1 = unit1;
        this.unit2 = unit2;
    }

    /**
     * Equals.
     *
     * @param object the object
     * @return true, if successful
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

    /**
     * @see org.java0.unit.impl.AbstractUnit#hashCode()
     */
    @Override
    public int hashCode() {
        return getUnit1().hashCode() ^ getUnit2().hashCode()
                ^ operator.hashCode();
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
     * Gets the unit1.
     *
     * @return the unit1
     * @see org.java0.unit.BinaryUnit#getUnit1()
     */
    @Override
    public UNIT_1 getUnit1() {
        return unit1;
    }

    /**
     * Gets the unit2.
     *
     * @return the unit2
     * @see org.java0.unit.BinaryUnit#getUnit2()
     */
    @Override
    public UNIT_2 getUnit2() {
        return unit2;
    }

    /**
     * @see org.java0.unit.BinaryUnit#getOperator()
     */
    @Override
    public String getOperator() {
        return operator;
    }
}
