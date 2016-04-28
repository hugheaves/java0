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
import org.java0.measurement.quantity.Quantity;
import org.java0.measurement.unit.BaseUnit;

public abstract class AbstractBaseUnit<T extends Quantity<?>> extends AbstractUnit implements BaseUnit<T> {

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(AbstractBaseUnit.class);

    protected final String symbol;
    protected final String name;
    protected final Number factor;
    protected final Number offset;

    protected AbstractBaseUnit(final String symbol, final String name) {
        this(symbol, name, 1d, 0d);
    }

    protected AbstractBaseUnit(final String symbol, final String name, final Number factor) {
        this(symbol, name, factor, 0d);
    }

    protected AbstractBaseUnit(final String symbol, final String name, final Number factor, final Number offset) {
        this.symbol = symbol;
        this.name = name;
        this.factor = factor;
        this.offset = offset;
    }

    @Override
    public Number getFactor() {
        return factor;
    }

    @Override
    public Number getOffset() {
        return offset;
    }

}
