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

import java.util.logging.Logger;

import org.java0.quantity.BinaryQuantity;
import org.java0.quantity.Quantity;
import org.java0.unit.BinaryUnit;
import org.java0.unit.Unit;
import org.java0.unit.UnitProduct;

/**
 * The Class BinaryUnitImpl.
 * 
 * @author Hugh Eaves
 * @param <UNIT_1>
 *            the generic type
 * @param <UNIT_2>
 *            the generic type
 * @param <COMBINED_UNIT>
 *            the generic type
 */
public abstract class BinaryUnitImpl<COMBINED_QUANTITY extends BinaryQuantity<QUANTITY_1, QUANTITY_2>, QUANTITY_1 extends Quantity, QUANTITY_2 extends Quantity>
        extends AbstractUnit<COMBINED_QUANTITY> implements
        BinaryUnit<COMBINED_QUANTITY, QUANTITY_1, QUANTITY_2> {

    /** The Constant logger. */
    @SuppressWarnings("unused")
    private static final Logger logger = Logger.getLogger(BinaryUnitImpl.class
            .getName());

    /** The uniT0. */
    protected Unit<QUANTITY_1> uniT0;

    /** The unit2. */
    protected Unit<QUANTITY_2> unit2;

    /** The operator. */
    protected String operator;

    /**
     * Create a new BinaryNumericUnitImpl.
     * 
     * @param operator
     *            the operator
     * @param uniT0
     *            the uniT0
     * @param unit2
     *            the unit2
     */
    public BinaryUnitImpl(String operator, Unit<QUANTITY_1> uniT0,
            Unit<QUANTITY_2> unit2) {
        super("(" + uniT0.getName() + " " + operator + " " + unit2.getName()
                + ")");
        this.uniT0 = uniT0;
        this.unit2 = unit2;
    }

    /**
     * Equals.
     * 
     * @param object
     *            the object
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
            UnitProduct<?, ?, ?> nup = (UnitProduct<?, ?, ?>) object;
            return (getUniT0().equals(nup.getUniT0())
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
        return getUniT0().hashCode() ^ getUnit2().hashCode()
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
        return uniT0.isSystemUnit() && unit2.isSystemUnit();
    }

    /**
     * Gets the uniT0.
     * 
     * @return the uniT0
     * @see org.java0.unit.BinaryUnit#getUniT0()
     */
    @Override
    public Unit<QUANTITY_1> getUniT0() {
        return uniT0;
    }

    /**
     * Gets the unit2.
     * 
     * @return the unit2
     * @see org.java0.unit.BinaryUnit#getUnit2()
     */
    @Override
    public Unit<QUANTITY_2> getUnit2() {
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
