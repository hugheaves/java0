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

/**
 * @author Hugh Eaves
 * 
 */
public class GenericUnit extends OffsetUnit<GenericUnit> {
    private static final GenericUnit SYSTEM_UNIT = new GenericUnit("generic",
            1, 0);

    /**
     * Create a new GenericUnit.
     * 
     * @param name
     * @param toSystemUnitConversionFactor
     * @param toSystemUnitOffset
     */
    public GenericUnit(String name, double toSystemUnitConversionFactor,
            double toSystemUnitOffset) {
        super(name, toSystemUnitConversionFactor, toSystemUnitOffset);

    }

    @SuppressWarnings("unused")
    private static final Logger logger = Logger.getLogger(GenericUnit.class
            .getName());

    /**
     * @see org.java0.unit.Unit#getSystemUnit()
     */
    @Override
    public GenericUnit getSystemUnit() {
        return SYSTEM_UNIT;
    }
}
