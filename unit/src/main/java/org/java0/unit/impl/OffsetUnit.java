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

import org.java0.quantity.Quantity;

/**
 * Implements a numeric unit that converts to and from the system unit by
 * multiplying / dividing by a conversion factor and adding / subtracting an
 * offset.
 * 
 * @author Hugh Eaves
 * @param <BASE_UNIT>
 *            the generic type
 */
public abstract class OffsetUnit<QUANTITY extends Quantity> extends
        ScalableUnit<QUANTITY> {

    /** The Constant logger. */
    @SuppressWarnings("unused")
    private static final Logger logger = Logger.getLogger(OffsetUnit.class
            .getName());

    /** The to system unit offset. */
    protected double toSystemUnitOffset;

    /**
     * Create a new ScalableNumericUnit.
     * 
     * @param name
     *            the human readable name of this unit.
     * @param toSystemUnitConversionFactor
     *            the factor to multiply by to convert a value in this unit, to
     *            a value in the system unit.
     * @param toSystemUnitOffset
     *            the offset to add to a value in this unit, to convert to a
     *            value in the system unit
     * 
     */
    public OffsetUnit(String name, double toSystemUnitConversionFactor,
            double toSystemUnitOffset) {
        super(name, toSystemUnitConversionFactor);
        this.toSystemUnitOffset = toSystemUnitOffset;

    }

    /**
     * @see org.java0.unit.impl.ScalableUnit#convertToSystem(java.lang.Number)
     */
    @Override
    public Number convertToSystem(Number value) {
        return (value.doubleValue() + toSystemUnitOffset)
                * toSystemUnitConversionFactor;
    }

    /**
     * @see org.java0.unit.impl.ScalableUnit#convertFromSystem(java.lang.Number)
     */
    @Override
    public Number convertFromSystem(Number value) {
        return (value.doubleValue() - toSystemUnitOffset)
                / toSystemUnitConversionFactor;
    }

    /**
     * Gets the to system unit offset.
     * 
     * @return the toSystemUnitOffset
     */
    public double getToSystemUnitOffset() {
        return toSystemUnitOffset;
    }

}
