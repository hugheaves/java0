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
package org.java0.quantity.impl;

import java.util.logging.Logger;

import org.java0.logging.LogUtil;
import org.java0.quantity.Quantity;
import org.java0.quantity.QuantityProduct;
import org.java0.quantity.QuantityQuotient;
import org.java0.unit.Unit;
import org.java0.unit.UnitProduct;
import org.java0.unit.UnitQuotient;

/**
 * @author Hugh Eaves
 * 
 */
public class QuantityImpl<UNIT_TYPE extends Unit<?>> implements
        Quantity<UNIT_TYPE> {

    private static final Logger logger = Logger.getLogger(QuantityImpl.class
            .getName());
    private static final LogUtil logUtil = new LogUtil(logger);

    protected Number value;
    protected UNIT_TYPE unit;

    protected QuantityImpl() {

    }

    public QuantityImpl(Number value, UNIT_TYPE unit) {
        this.value = value;
        this.unit = unit;
    }

    public QuantityImpl(double value, UNIT_TYPE unit) {
        this.value = value;
        this.unit = unit;
    }

    /**
     * @see org.java0.quantity.Quantity#unit()
     */
    @Override
    public UNIT_TYPE unit() {
        return unit;
    }

    @Override
    public <A extends UNIT_TYPE> Number value(A unit) {
        logUtil.valuesFinest("converting value", "this.value", this.value,
                "this.unit", this.unit, "to unit", unit);

        Number convertedValue = value();

        if (unit.equals(unit())) {
            logUtil.valuesFinest("no conversion needed", "convertedValue",
                    convertedValue);
            return convertedValue;
        }

        if (!unit().isSystemUnit()) {
            convertedValue = unit().convertToSystem(convertedValue);
            logUtil.valuesFinest(
                    "to unit is not system unit, converting value to system unit",
                    "convertedValue", convertedValue);
        }

        if (!unit.isSystemUnit()) {
            convertedValue = unit.convertFromSystem(convertedValue);
            logUtil.valuesFinest(
                    "this unit is not system unit, converting value from system unit",
                    "convertedValue", convertedValue);
        }

        return convertedValue;
    }

    @Override
    public Number value() {
        return value;
    }

    @Override
    public String toString() {
        return value + " " + unit().getName();
    }

    @Override
    public Quantity<UNIT_TYPE> add(Quantity<UNIT_TYPE> amount) {
        double sum = value().doubleValue() + amount.value(unit()).doubleValue();
        return new QuantityImpl<UNIT_TYPE>(sum, unit());
    }

    @Override
    public Quantity<UNIT_TYPE> subtract(Quantity<UNIT_TYPE> amount) {
        double difference = value().doubleValue()
                - amount.value(unit()).doubleValue();
        return new QuantityImpl<UNIT_TYPE>(difference, unit());
    }

    /**
     * @see org.java0.quantity.Quantity#multiply(org.java0.quantity.Quantity)
     */

    // public <P extends NumericUnit<? super P>, Q extends P>
    // NumericUnitProduct<U, P> multiply(Q unit);

    @Override
    public <LOWER_BOUND extends Unit<?>, QUANTITY_TYPE extends Quantity<LOWER_BOUND>> QuantityProduct<UNIT_TYPE, LOWER_BOUND> multiply(
            QUANTITY_TYPE quantity) {

        UNIT_TYPE a = unit();
        LOWER_BOUND b = quantity.unit();

        @SuppressWarnings("unchecked")
        UnitProduct<UNIT_TYPE, LOWER_BOUND> c = (UnitProduct<UNIT_TYPE, LOWER_BOUND>) a
                .multiply(b);

        double result = value().doubleValue() * quantity.value().doubleValue();

        return new QuantityProductImpl<UNIT_TYPE, LOWER_BOUND>(result, c);

    }

    /**
     * @see org.java0.quantity.Quantity#divide(org.java0.quantity.Quantity)
     */
    @Override
    public <LOWER_BOUND extends Unit<?>, PARAM_QUANTITY_TYPE extends Quantity<LOWER_BOUND>> QuantityQuotient<UNIT_TYPE, LOWER_BOUND> divide(
            PARAM_QUANTITY_TYPE quantity) {
        UNIT_TYPE a = unit();
        LOWER_BOUND b = quantity.unit();

        @SuppressWarnings("unchecked")
        UnitQuotient<UNIT_TYPE, LOWER_BOUND> c = (UnitQuotient<UNIT_TYPE, LOWER_BOUND>) a
                .divide(b);

        double result = value().doubleValue() / quantity.value().doubleValue();

        return new QuantityQuotientImpl<UNIT_TYPE, LOWER_BOUND>(result, c);

    }

    /**
     * @see org.java0.quantity.Quantity#asType(java.lang.Class)
     */
    @Override
    public <CAST_UNIT extends UNIT_TYPE, CAST_QUANTITY extends Quantity<CAST_UNIT>> CAST_QUANTITY asType(
            Class<CAST_QUANTITY> type) {
        throw new UnsupportedOperationException();
    }

    /**
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Quantity<UNIT_TYPE> quantity) {
        double val = quantity.value(unit()).doubleValue();
        if (val < value().doubleValue()) {
            return -1;
        } else if (val > value().doubleValue()) {
            return 1;
        } else {
            return 0;
        }
    }
}