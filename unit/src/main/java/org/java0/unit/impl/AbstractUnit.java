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
import org.java0.quantity.Quantity;
import org.java0.quantity.QuantityProduct;
import org.java0.quantity.QuantityQuotient;
import org.java0.unit.InverseUnit;
import org.java0.unit.Unit;
import org.java0.unit.UnitProduct;
import org.java0.unit.UnitQuotient;

/**
 * The Class AbstractUnit.
 * 
 * @author Hugh Eaves
 * @param <BASE_UNIT>
 *            the generic type
 */
public abstract class AbstractUnit<QUANTITY extends Quantity> extends
        AbstractNamedObject implements Unit<QUANTITY> {

    /** The Constant logger. */
    @SuppressWarnings("unused")
    private static final Logger logger = Logger.getLogger(AbstractUnit.class
            .getName());

    /**
     * Create a new AbstractNumericUnit.
     * 
     * @param name
     *            the name
     */
    public AbstractUnit(String name) {
        super(name);
    }

    /**
     * Equals.
     * 
     * @param object
     *            the object
     * @return true, if successful
     * @see org.java0.core.type.AbstractNamedObject#equals(java.lang.Object)
     */
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

    /**
     * Hash code.
     * 
     * @return the int
     * @see org.java0.core.type.AbstractNamedObject#hashCode()
     */
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    /**
     * Invert.
     * 
     * @return the inverse unit
     * @see org.java0.unit.Unit#invert()
     */
    @Override
    public InverseUnit<QUANTITY> invert() {
        return new InverseUnitImpl<QUANTITY>(this);
    }

    /**
     * Checks if is system unit.
     * 
     * @return true, if is system unit
     * @see org.java0.unit.Unit#isSystemUnit()
     */
    @Override
    public boolean isSystemUnit() {
        return equals(getSystemUnit());
    }

    /**
     * @see org.java0.unit.Unit#multiply(org.java0.unit.Unit)
     */
    @Override
    public <PARAM_QUANTITY extends Quantity, PARAM_UNIT extends Unit<PARAM_QUANTITY>, COMBINED_QUANTITY extends QuantityProduct<QUANTITY, PARAM_QUANTITY>> UnitProduct<COMBINED_QUANTITY, QUANTITY, PARAM_QUANTITY> multiply(
            PARAM_UNIT unit) {
        return new UnitProductImpl<COMBINED_QUANTITY, QUANTITY, PARAM_QUANTITY>(
                this, unit);
    }

    /**
     * @see org.java0.unit.Unit#divide(org.java0.unit.Unit)
     */
    @Override
    public <PARAM_QUANTITY extends Quantity, PARAM_UNIT extends Unit<PARAM_QUANTITY>, COMBINED_QUANTITY extends QuantityQuotient<QUANTITY, PARAM_QUANTITY>> UnitQuotient<COMBINED_QUANTITY, QUANTITY, PARAM_QUANTITY> divide(
            PARAM_UNIT unit) {
        return new UnitQuotientImpl<COMBINED_QUANTITY, QUANTITY, PARAM_QUANTITY>(
                this, unit);
    }
}
