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

import org.java0.unit.Unit;

/**
 * Implements a numeric unit that converts to and from the system unit by
 * multiplying / dividing by a conversion factor and adding / subtracting an
 * offset.
 * 
 * @author Hugh Eaves
 * 
 */
public abstract class OffsetUnit<BASE_TYPE extends Unit<?, ?>, SUB_TYPE extends Unit<BASE_TYPE, SUB_TYPE>>
        extends ScalableUnit<BASE_TYPE, SUB_TYPE> {

    @SuppressWarnings("unused")
    private static final Logger logger = Logger.getLogger(OffsetUnit.class
            .getName());

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

    @Override
    public Number convertToSystem(Number value) {
        return (value.doubleValue() + toSystemUnitOffset)
                * toSystemUnitConversionFactor;
    }

    @Override
    public Number convertFromSystem(Number value) {
        return (value.doubleValue() - toSystemUnitOffset)
                / toSystemUnitConversionFactor;
    }

    /**
     * @return the toSystemUnitOffset
     */
    public double getToSystemUnitOffset() {
        return toSystemUnitOffset;
    }

}
