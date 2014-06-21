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
package org.java0.unit.temperature;

import java.util.logging.Logger;

import org.java0.quantity.Temperature;
import org.java0.unit.impl.OffsetUnit;

/**
 * The Class TemperatureUnit.
 * 
 * @author Hugh Eaves
 */
public abstract class TemperatureUnit extends OffsetUnit<Temperature> {

    /**
     * Create a new TemperatureUnit.
     * 
     * @param name
     *            the name
     * @param toSystemUnitConversionFactor
     *            the to system unit conversion factor
     * @param toSystemUnitOffset
     *            the to system unit offset
     */
    public TemperatureUnit(String name, double toSystemUnitConversionFactor,
            double toSystemUnitOffset) {
        super(name, toSystemUnitConversionFactor, toSystemUnitOffset);

    }

    /** The Constant logger. */
    @SuppressWarnings("unused")
    private static final Logger logger = Logger.getLogger(TemperatureUnit.class
            .getName());

    /**
     * Gets the system unit.
     * 
     * @return the system unit
     * @see org.java0.unit.Unit#getSystemUnit()
     */
    @Override
    public TemperatureUnit getSystemUnit() {
        return KelvinUnit.INSTANCE;
    }
}
