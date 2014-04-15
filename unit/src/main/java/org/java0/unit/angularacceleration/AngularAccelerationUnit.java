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
package org.java0.unit.angularacceleration;

import org.java0.unit.UnitQuotient;
import org.java0.unit.angle.AngleUnit;
import org.java0.unit.impl.UnitQuotientImpl;
import org.java0.unit.time.TimeUnit;

/**
 * @author Hugh Eaves
 * 
 */
public abstract class AngularAccelerationUnit extends
        UnitQuotientImpl<UnitQuotient<AngleUnit, TimeUnit>, TimeUnit> {

    public AngularAccelerationUnit(UnitQuotient<AngleUnit, TimeUnit> unit1,
            TimeUnit unit2) {
        super(unit1, unit2);
    }

    @Override
    public AngularAccelerationUnit getSystemUnit() {
        return RadiansPerSecondPerSecondUnit.INSTANCE;
    }
}
