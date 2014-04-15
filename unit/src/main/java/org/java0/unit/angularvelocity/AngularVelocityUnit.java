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

import org.java0.unit.angle.AngleUnit;
import org.java0.unit.impl.UnitQuotientImpl;
import org.java0.unit.time.TimeUnit;


/**
 * // * @author Hugh Eaves.
 */
public class AngularVelocityUnit extends
        UnitQuotientImpl<AngleUnit, TimeUnit> {

    /**
     * Instantiates a new angular velocity unit.
     *
     * @param unit1 the unit1
     * @param unit2 the unit2
     */
    public AngularVelocityUnit(AngleUnit unit1, TimeUnit unit2) {
        super(unit1, unit2);
    }

    /**
     * @see org.java0.unit.impl.UnitQuotientImpl#getSystemUnit()
     */
    @Override
    public AngularVelocityUnit getSystemUnit() {
        return RadiansPerSecondUnit.INSTANCE;
    }
}
