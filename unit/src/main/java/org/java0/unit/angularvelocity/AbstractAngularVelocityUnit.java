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
package org.java0.unit.angularvelocity;

import org.java0.quantity.Angle;
import org.java0.quantity.AngularVelocity;
import org.java0.quantity.Time;
import org.java0.unit.Unit;
import org.java0.unit.impl.UnitQuotientImpl;

/**
 * // * @author Hugh Eaves.
 */
public class AbstractAngularVelocityUnit extends
        UnitQuotientImpl<AngularVelocity, Angle, Time> {

    /**
     * Instantiates a new angular velocity unit.
     * 
     * @param unit1
     *            the unit1
     * @param unit2
     *            the unit2
     */
    public AbstractAngularVelocityUnit(Unit<Angle> unit1, Unit<Time> unit2) {
        super(unit1, unit2);
    }

    /**
     * @see org.java0.unit.impl.UnitQuotientImpl#getSystemUnit()
     */
    @Override
    public AbstractAngularVelocityUnit getSystemUnit() {
        return RadiansPerSecondUnit.INSTANCE;
    }
}
