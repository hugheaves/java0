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
package org.java0.amount.angularvelocity;

import org.java0.amount.Amount;
import org.java0.amount.AmountQuotient;
import org.java0.amount.impl.AmountQuotientImpl;
import org.java0.quantity.Angle;
import org.java0.quantity.AngularVelocity;
import org.java0.quantity.Time;
import org.java0.unit.UnitQuotient;

/**
 * The Class AngularVelocity.
 * 
 * @author Hugh Eaves
 */
public class AngularVelocityAmount extends
        AmountQuotientImpl<AngularVelocity, Angle, Time> {

    /**
     * Instantiates a new angular velocity.
     * 
     * @param value
     *            the value
     * @param unit
     *            the unit
     */
    public AngularVelocityAmount(Number value,
            UnitQuotient<AngularVelocity, Angle, Time> unit) {
        super(value, unit);
    }

    /**
     * Instantiates a new angular velocity.
     * 
     * @param angularVelocity
     *            the angular velocity
     * @param unit
     *            the unit
     */
    public AngularVelocityAmount(Amount<AngularVelocity> angularVelocity,
            UnitQuotient<AngularVelocity, Angle, Time> unit) {
        super(angularVelocity.value(unit), unit);
    }

    /**
     * Instantiates a new angular velocity.
     * 
     * @param angularVelocity
     *            the angular velocity
     */
    public AngularVelocityAmount(
            AmountQuotient<AngularVelocity, Angle, Time> angularVelocity) {
        super(angularVelocity.value(), angularVelocity.unit());
    }
}
