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
package org.java0.measurement.impl.unit;

import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;
import org.java0.measurement.Units;
import org.java0.measurement.quantity.Power;
import org.java0.measurement.unit.PowerUnit;

public class PowerUnitImpl extends AbstractBaseUnit<Power> implements PowerUnit {
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(PowerUnitImpl.class);

    public PowerUnitImpl(final String symbol, final String name) {
        super(symbol, name);
    }

    public PowerUnitImpl(final String symbol, final String name, final Number factor) {
        super(symbol, name, factor);
    }

    @Override
    public PowerUnit getSystemUnit() {
        return Units.WATTS;
    }

}
