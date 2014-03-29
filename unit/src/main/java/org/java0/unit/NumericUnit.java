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

// TODO: Auto-generated Javadoc
/**
 * The Interface NumericUnit.
 * 
 * @author Hugh Eaves
 * @param <U>
 *            the generic type
 */
public interface NumericUnit<UNIT_TYPE extends NumericUnit<?>> extends
        Unit<Number, UNIT_TYPE>
/* ,org.unitsofmeasurement.unit.Unit<NumericQuantity<U>> */{

    /**
     * Returns the product of two numeric units.
     */
    public <LOWER_BOUND extends NumericUnit<?>, PARAM_UNIT_TYPE extends LOWER_BOUND> NumericUnitProduct<UNIT_TYPE, LOWER_BOUND> multiply(
            PARAM_UNIT_TYPE unit);

    /**
     * Returns the quotient of two numeric units.
     */
    public <LOWER_BOUND extends NumericUnit<?>, PARAM_UNIT_TYPE extends LOWER_BOUND> NumericUnitQuotient<UNIT_TYPE, LOWER_BOUND> divide(
            PARAM_UNIT_TYPE unit);

    /**
     * Returns the inverse of this unit.
     * 
     * @return the inverse unit
     */
    public InverseUnit<UNIT_TYPE> invert();

    /**
     * Gets the system unit.
     * 
     * @return the system unit
     * @see org.java0.unit.Unit#getSystemUnit()
     */
    @Override
    public UNIT_TYPE getSystemUnit();
}
