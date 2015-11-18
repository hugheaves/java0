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
package org.java0.amount.angularacceleration;

import org.java0.amount.impl.AmountQuotientImpl;
import org.java0.quantity.AngularAcceleration;
import org.java0.quantity.AngularVelocity;
import org.java0.quantity.Time;
import org.java0.unit.UnitQuotient;

/**
 * The Class AngularAcceleration.
 * 
 * @author Hugh Eaves
 */
public class AngularAccelerationAmount extends
        AmountQuotientImpl<AngularAcceleration, AngularVelocity, Time> {

    /**
     * Instantiates a new angular acceleration.
     * 
     * @param value
     *            the value
     * @param unit
     *            the unit
     */
    public AngularAccelerationAmount(Number value,
            UnitQuotient<AngularAcceleration, AngularVelocity, Time> unit) {
        super(value, unit);
    }
}
