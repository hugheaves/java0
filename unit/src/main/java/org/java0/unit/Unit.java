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


/**
 * The Interface NumericUnit.
 * 
 * @author Hugh Eaves
 * @param <BASE_UNIT>
 *            the generic type
 */
public interface Unit<BASE_UNIT extends Unit<BASE_UNIT>> extends NamedObject
/* ,org.unitsofmeasurement.unit.Unit<NumericQuantity<U>> */{

    /**
     * Returns the product of two numeric units.
     * 
     * @param <PARAM_BASE_UNIT>
     *            the generic type
     * @param <PARAM_UNIT>
     *            the generic type
     * @param unit
     *            the unit
     * @return the unit product
     */
    public <PARAM_BASE_UNIT extends Unit<PARAM_BASE_UNIT>, PARAM_UNIT extends Unit<PARAM_BASE_UNIT>> UnitProduct<BASE_UNIT, PARAM_BASE_UNIT> multiply(
            PARAM_UNIT unit);

    /**
     * Returns the quotient of two numeric units.
     * 
     * @param <PARAM_BASE_UNIT>
     *            the generic type
     * @param <PARAM_UNIT>
     *            the generic type
     * @param unit
     *            the unit
     * @return the unit quotient
     */
    public <PARAM_BASE_UNIT extends Unit<PARAM_BASE_UNIT>, PARAM_UNIT extends Unit<PARAM_BASE_UNIT>> UnitQuotient<BASE_UNIT, PARAM_BASE_UNIT> divide(
            PARAM_UNIT unit);

    /**
     * Returns the inverse of this unit.
     * 
     * @return the inverse unit
     */
    public InverseUnit<BASE_UNIT> invert();

    /**
     * Returns the system unit compatible with this Unit.
     * 
     * @return the system unit compatible with this Unit.
     */
    public Unit<BASE_UNIT> getSystemUnit();

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
