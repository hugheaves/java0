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
public class QuantityImpl<BASE_TYPE extends Unit<?, ?>, SUB_TYPE extends BASE_TYPE>
        implements Quantity<BASE_TYPE, SUB_TYPE> {

    private static final Logger logger = Logger.getLogger(QuantityImpl.class
            .getName());
    private static final LogUtil logUtil = new LogUtil(logger);

    protected Number value;
    protected BASE_TYPE unit;

    protected QuantityImpl() {

    }

    public QuantityImpl(Number value, BASE_TYPE unit) {
        this.value = value;
        this.unit = unit;
    }

    public QuantityImpl(double value, BASE_TYPE unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public BASE_TYPE unit() {
        return unit;
    }

    @Override
    public <A extends BASE_TYPE> Number value(A unit) {
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
    public Quantity<BASE_TYPE, SUB_TYPE> add(Quantity<BASE_TYPE, ?> amount) {
        double sum = value().doubleValue() + amount.value(unit()).doubleValue();
        return new QuantityImpl<BASE_TYPE, SUB_TYPE>(sum, unit());
    }

    @Override
    public Quantity<BASE_TYPE, SUB_TYPE> subtract(Quantity<BASE_TYPE, ?> amount) {
        double difference = value().doubleValue()
                - amount.value(unit()).doubleValue();
        return new QuantityImpl<BASE_TYPE, SUB_TYPE>(difference, unit());
    }

    /**
     * @see org.java0.quantity.Quantity#multiply(org.java0.quantity.Quantity)
     */

    @Override
    public <LOWER_BOUND extends Unit<?, ?>, UPPER_BOUND extends LOWER_BOUND, QUANTITY_TYPE extends Quantity<LOWER_BOUND, UPPER_BOUND>> QuantityProduct<BASE_TYPE, LOWER_BOUND> multiply(
            QUANTITY_TYPE quantity) {

        BASE_TYPE a = unit();
        LOWER_BOUND b = quantity.unit();

        @SuppressWarnings("unchecked")
        UnitProduct<BASE_TYPE, LOWER_BOUND> c = (UnitProduct<BASE_TYPE, LOWER_BOUND>) a
                .multiply(b);

        double result = value().doubleValue() * quantity.value().doubleValue();

        return new QuantityProductImpl<BASE_TYPE, LOWER_BOUND>(result, c);

    }

    /**
     * @see org.java0.quantity.Quantity#divide(org.java0.quantity.Quantity)
     */
    @Override
    public <LOWER_BOUND extends Unit<?, ?>, UPPER_BOUND extends LOWER_BOUND, QUANTITY_TYPE extends Quantity<LOWER_BOUND, UPPER_BOUND>> QuantityQuotient<BASE_TYPE, LOWER_BOUND> divide(
            QUANTITY_TYPE quantity)

    {
        BASE_TYPE a = unit();
        LOWER_BOUND b = quantity.unit();

        @SuppressWarnings("unchecked")
        UnitQuotient<BASE_TYPE, LOWER_BOUND> c = (UnitQuotient<BASE_TYPE, LOWER_BOUND>) a
                .divide(b);

        double result = value().doubleValue() / quantity.value().doubleValue();

        return new QuantityQuotientImpl<BASE_TYPE, LOWER_BOUND>(result, c);

    }

    /**
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Quantity<BASE_TYPE, ?> quantity) {
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