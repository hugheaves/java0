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

import org.java0.core.type.AbstractNamedObject;
import org.java0.unit.InverseUnit;
import org.java0.unit.NumericUnit;
import org.java0.unit.NumericUnitProduct;
import org.java0.unit.NumericUnitQuotient;

/**
 * @author Hugh Eaves
 * 
 */
public abstract class AbstractNumericUnit<UNIT_TYPE extends NumericUnit<?>>
        extends AbstractNamedObject implements NumericUnit<UNIT_TYPE> {
    @SuppressWarnings("unused")
    private static final Logger logger = Logger
            .getLogger(AbstractNumericUnit.class.getName());

    /**
     * Create a new AbstractNumericUnit.
     * 
     * @param name
     */
    public AbstractNumericUnit(String name) {
        super(name);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        } else if (object == this) {
            return true;
        } else {
            return (object.getClass().equals(getClass()));
        }
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    //
    // @Override
    // public <P extends NumericUnit<P>, Q extends P> NumericUnitProduct<U, P>
    // multiply(
    // Q unit) {
    // return new NumericUnitProductImpl<U, P>((U) this, unit);
    // }
    //
    // /**
    // * @see org.java0.unit.NumericUnit#divide(org.java0.unit.NumericUnit)
    // */
    // @Override
    // public <P extends NumericUnit<P>, Q extends P> NumericUnitQuotient<U, P>
    // divide(
    // Q unit) {
    // return new NumericUnitQuotientImpl<U, P>((U) this, unit);
    //
    // }

    /**
     * @see org.java0.unit.NumericUnit#invert()
     */
    @Override
    public InverseUnit<UNIT_TYPE> invert() {
        // return new InverseUnitImpl<UNIT_TYPE>((UNIT_TYPE) this);
        return null;
    }

    /**
     * @see org.java0.unit.Unit#isSystemUnit()
     */
    @Override
    public boolean isSystemUnit() {
        return equals(getSystemUnit());
    }

    /**
     * Returns the product of two numeric units.
     */
    @SuppressWarnings("unchecked")
    @Override
    public <LOWER_BOUND extends NumericUnit<?>, PARAM_UNIT_TYPE extends LOWER_BOUND> NumericUnitProduct<UNIT_TYPE, LOWER_BOUND> multiply(
            PARAM_UNIT_TYPE unit) {
        return new NumericUnitProductImpl<UNIT_TYPE, LOWER_BOUND>(
                (UNIT_TYPE) this, unit);
    }

    /**
     * Returns the quotient of two numeric units.
     */
    @SuppressWarnings("unchecked")
    @Override
    public <LOWER_BOUND extends NumericUnit<?>, PARAM_UNIT_TYPE extends LOWER_BOUND> NumericUnitQuotient<UNIT_TYPE, LOWER_BOUND> divide(
            PARAM_UNIT_TYPE unit) {
        return new NumericUnitQuotientImpl<UNIT_TYPE, LOWER_BOUND>(
                (UNIT_TYPE) this, unit);
    }

}
