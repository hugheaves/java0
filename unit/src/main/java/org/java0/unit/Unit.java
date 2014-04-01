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
package org.java0.unit;

import org.java0.core.type.NamedObject;

// TODO: Auto-generated Javadoc
/**
 * The Interface NumericUnit.
 * 
 * @author Hugh Eaves
 * @param <U>
 *            the generic type
 */
public interface Unit<BASE_TYPE extends Unit<?, ?>, SUB_TYPE extends BASE_TYPE>
        extends NamedObject
/* ,org.unitsofmeasurement.unit.Unit<NumericQuantity<U>> */{

    /**
     * Returns the product of two numeric units.
     */
    public <LOWER_BOUND extends Unit<?, ?>, PARAM_UNIT_TYPE extends LOWER_BOUND> UnitProduct<BASE_TYPE, LOWER_BOUND> multiply(
            PARAM_UNIT_TYPE unit);

    /**
     * Returns the quotient of two numeric units.
     */
    public <LOWER_BOUND extends Unit<?, ?>, PARAM_UNIT_TYPE extends LOWER_BOUND> UnitQuotient<BASE_TYPE, LOWER_BOUND> divide(
            PARAM_UNIT_TYPE unit);

    /**
     * Returns the inverse of this unit.
     * 
     * @return the inverse unit
     */
    public InverseUnit<BASE_TYPE, SUB_TYPE> invert();

    /**
     * Returns the system unit compatible with this Unit.
     * 
     * @return the system unit compatible with this Unit.
     */
    public BASE_TYPE getSystemUnit();

    /**
     * Returns whether or not this unit is a system unit.
     * 
     * @return true if this unit is a system unit.
     */
    boolean isSystemUnit();

    /**
     * Converts a value in this unit type, to a value in the system unit type.
     * 
     * @param value
     *            the value
     * @return the t
     */
    public Number convertToSystem(Number value);

    /**
     * Converts a value in the system unit type, to a value in this unit type.
     * 
     * @param value
     *            the value
     * @return the t
     */
    public Number convertFromSystem(Number value);

}
