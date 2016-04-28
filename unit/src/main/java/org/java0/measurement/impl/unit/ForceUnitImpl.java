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
import org.java0.measurement.quantity.Force;
import org.java0.measurement.unit.EnergyUnit;
import org.java0.measurement.unit.ForceUnit;
import org.java0.measurement.unit.LengthUnit;

public class ForceUnitImpl extends AbstractBaseUnit<Force> implements ForceUnit {
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(ForceUnitImpl.class);

    public ForceUnitImpl(final String symbol, final String name) {
        super(symbol, name);
    }

    public ForceUnitImpl(final String symbol, final String name, final Number factor) {
        super(symbol, name, factor);
    }

    @Override
    public ForceUnit getSystemUnit() {
        return Units.NEWTONS;
    }

    @Override
    public EnergyUnit multiply(final LengthUnit unit) {
        return null;
    }

}
