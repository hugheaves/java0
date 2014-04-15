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
package org.java0.quantity.power;

import org.java0.quantity.impl.QuantityImpl;
import org.java0.unit.power.PowerUnit;


/**
 * The Class Power.
 *
 * @author Hugh Eaves
 */
public class Power extends QuantityImpl<PowerUnit> {

    /**
     * Instantiates a new power.
     */
    protected Power() {
    }

    /**
     * Instantiates a new power.
     *
     * @param value the value
     * @param unit the unit
     */
    public Power(Number value, PowerUnit unit) {
        super(value, unit);
    }
}
