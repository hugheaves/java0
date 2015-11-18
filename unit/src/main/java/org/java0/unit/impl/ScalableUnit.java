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

/**
 * Implements a numeric unit that converts to and from the system unit by
 * multiplying / dividing by a conversion factor.
 * 
 * @author Hugh Eaves
 * @param <BASE_UNIT>
 *            the generic type
 */
public abstract class ScalableUnit<QUANTITY extends Quantity> extends
        AbstractUnit<QUANTITY> {

    /** The to system unit conversion factor. */
    protected double toSystemUnitConversionFactor;

    /**
     * Create a new ScalableNumericUnit.
     * 
     * @param name
     *            the human readable name of this unit.
     * @param toSystemUnitConversionFactor
     *            the value to multiply by to convert a value in this unit, to a
     *            value in the system unit.
     */
    public ScalableUnit(String name, double toSystemUnitConversionFactor) {
        super(name);
        this.toSystemUnitConversionFactor = toSystemUnitConversionFactor;
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
        return value.doubleValue() * toSystemUnitConversionFactor;
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
        return value.doubleValue() / toSystemUnitConversionFactor;
    }

    /**
     * Gets the to system unit conversion factor.
     * 
     * @return the toSystemUnitConversionFactor
     */
    public double getToSystemUnitConversionFactor() {
        return toSystemUnitConversionFactor;
    }

}
