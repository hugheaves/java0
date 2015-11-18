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
package org.java0.unit.energy;

import org.java0.quantity.Energy;
import org.java0.quantity.Force;
import org.java0.quantity.Length;
import org.java0.unit.force.NewtonsUnit;
import org.java0.unit.impl.UnitProductImpl;
import org.java0.unit.length.MetersUnit;

/**
 * @author Hugh Eaves
 * 
 */
public class NewtonMeterUnit extends UnitProductImpl<Energy, Force, Length>
        implements EnergyUnit {

    /**
     * Create a new NewtonMeterUnit.
     * 
     * @param unit1
     * @param unit2
     */
    public NewtonMeterUnit() {
        super(NewtonsUnit.INSTANCE, MetersUnit.INSTANCE);
    }
}
