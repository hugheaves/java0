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
package org.java0.unit.force;

import org.java0.quantity.Force;
import org.java0.unit.Unit;
import org.java0.unit.impl.AbstractUnit;

/**
 * @author Hugh Eaves
 * 
 */
public class NewtonsUnit extends AbstractUnit<Force> implements ForceUnit {
    public static final NewtonsUnit INSTANCE = new NewtonsUnit();

    /**
     * Create a new MetersUnit.
     * 
     * @param name
     */
    public NewtonsUnit() {
        super("meters");

    }

    /**
     * @see org.java0.unit.Unit#getSystemUnit()
     */
    @Override
    public Unit<Force> getSystemUnit() {
        return INSTANCE;
    }

    /**
     * @see org.java0.unit.Unit#convertToSystem(java.lang.Number)
     */
    @Override
    public Number convertToSystem(Number value) {
        return value;
    }

    /**
     * @see org.java0.unit.Unit#convertFromSystem(java.lang.Number)
     */
    @Override
    public Number convertFromSystem(Number value) {
        return value;
    }
}
