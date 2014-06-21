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
package org.java0.unit.energy;

import org.java0.quantity.Energy;
import org.java0.unit.Unit;
import org.java0.unit.impl.AbstractUnit;

/**
 * @author Hugh Eaves
 * 
 */
public final class JoulesUnit extends AbstractUnit<Energy> implements
        EnergyUnit {

    public static final Unit<Energy> INSTANCE = new JoulesUnit();

    /**
     * Create a new JoulesUnit.
     * 
     * @param name
     */
    private JoulesUnit() {
        super("joules");
    }

    /**
     * @see org.java0.unit.Unit#getSystemUnit()
     */
    @Override
    public Unit<Energy> getSystemUnit() {
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
