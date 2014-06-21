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
package org.java0.unit.angle;

import org.java0.quantity.Angle;
import org.java0.unit.impl.ScalableUnit;

/**
 * The Class AngleUnit.
 * 
 * @author Hugh Eaves
 */
public abstract class AbstractAngleUnit extends ScalableUnit<Angle> implements
        AngleUnit {

    /**
     * Create a new AngleUnit.
     * 
     * @param name
     *            the name
     * @param toSystemUnitConversionFactor
     *            the to system unit conversion factor
     */
    public AbstractAngleUnit(String name, double toSystemUnitConversionFactor) {
        super(name, toSystemUnitConversionFactor);
    }

    /**
     * @see org.java0.unit.Unit#getSystemUnit()
     */
    @Override
    public AbstractAngleUnit getSystemUnit() {
        return RadiansUnit.INSTANCE;
    }
}
