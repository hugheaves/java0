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
package org.java0.quantity.angularvelocity;

import org.java0.quantity.Numeric;
import org.java0.quantity.impl.NumericQuotientImpl;
import org.java0.unit.NumericUnitQuotient;
import org.java0.unit.angle.AngleUnit;
import org.java0.unit.time.TimeUnit;

/**
 * @author Hugh Eaves
 * 
 */
public class AngularVelocity extends NumericQuotientImpl<AngleUnit, TimeUnit> {

    public AngularVelocity(Number value,
            NumericUnitQuotient<AngleUnit, TimeUnit> unit) {
        super(value, unit);
    }

    public AngularVelocity(
            Numeric<NumericUnitQuotient<AngleUnit, TimeUnit>> angularVelocity,
            NumericUnitQuotient<AngleUnit, TimeUnit> unit) {
        super(angularVelocity.value(unit), unit);
    }

    public AngularVelocity(
            Numeric<NumericUnitQuotient<AngleUnit, TimeUnit>> angularVelocity) {
        super(angularVelocity.value(), angularVelocity.unit());
    }
}
