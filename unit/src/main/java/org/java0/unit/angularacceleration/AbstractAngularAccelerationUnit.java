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
package org.java0.unit.angularacceleration;

import org.java0.quantity.AngularAcceleration;
import org.java0.quantity.AngularVelocity;
import org.java0.quantity.Time;
import org.java0.unit.Unit;
import org.java0.unit.impl.UnitQuotientImpl;

/**
 * The Class AngularAccelerationUnit.
 * 
 * @author Hugh Eaves
 */
public abstract class AbstractAngularAccelerationUnit extends
        UnitQuotientImpl<AngularAcceleration, AngularVelocity, Time> implements
        AngularAccelerationUnit {

    /**
     * Instantiates a new angular acceleration unit.
     * 
     * @param uniT0
     *            the uniT0
     * @param unit2
     *            the unit2
     */
    public AbstractAngularAccelerationUnit(Unit<AngularVelocity> uniT0,
            Unit<Time> unit2) {
        super(uniT0, unit2);
    }

    /**
     * @see org.java0.unit.impl.UnitQuotientImpl#getSystemUnit()
     */
    @Override
    public AbstractAngularAccelerationUnit getSystemUnit() {
        return RadiansPerSecondPerSecondUnit.INSTANCE;
    }
}
