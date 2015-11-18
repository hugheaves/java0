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
package org.java0.unit.angularvelocity;

import org.java0.unit.angle.RadiansUnit;
import org.java0.unit.time.SecondsUnit;


/**
 * The Class RadiansPerSecondUnit.
 *
 * @author Hugh Eaves
 */
public class RadiansPerSecondUnit extends AbstractAngularVelocityUnit {
    
    /** The Constant INSTANCE. */
    public static final RadiansPerSecondUnit INSTANCE = new RadiansPerSecondUnit();

    /**
     * Instantiates a new radians per second unit.
     */
    public RadiansPerSecondUnit() {
        super(RadiansUnit.INSTANCE, SecondsUnit.INSTANCE);
    }
}
