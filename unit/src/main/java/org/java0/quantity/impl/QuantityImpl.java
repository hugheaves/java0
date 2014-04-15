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
import org.java0.unit.InverseUnit;
import org.java0.unit.Unit;
import org.java0.unit.UnitProduct;
import org.java0.unit.UnitQuotient;

/**
 * @author Hugh Eaves
 * 
 */
public class QuantityImpl<UNIT extends Unit<UNIT>> implements Quantity<UNIT> {

    private static final Logger logger = Logger.getLogger(QuantityImpl.class
            .getName());
    private static final LogUtil logUtil = new LogUtil(logger);

    protected Number value;
    protected UNIT unit;

    protected QuantityImpl() {

    }

    public QuantityImpl(Number value, UNIT unit) {
        this.value = value;
        this.unit = unit;
    }

    public QuantityImpl(double value, UNIT unit) {
        this.value = value;
        this.unit = unit;
    }

    /**
     * @see org.java0.quantity.Quantity#unit()
     */
    @Override
    public UNIT unit() {
        return unit;
    }

    @Override
    public <A extends UNIT> Number value(A unit) {
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
    public Quantity<UNIT> add(Quantity<UNIT> amount) {
        double sum = value().doubleValue() + amount.value(unit()).doubleValue();
        return new QuantityImpl<UNIT>(sum, unit());
    }

    @Override
    public Quantity<UNIT> subtract(Quantity<UNIT> amount) {
        double difference = value().doubleValue()
                - amount.value(unit()).doubleValue();
        return new QuantityImpl<UNIT>(difference, unit());
    }

    /**
     * @see org.java0.quantity.Quantity#multiply(org.java0.quantity.Quantity)
     */

    @Override
    public <PARAM_BASE_UNIT extends Unit<PARAM_BASE_UNIT>, PARAM_UNIT extends Unit<PARAM_BASE_UNIT>, PARAM_TYPE extends Quantity<? extends Unit<PARAM_BASE_UNIT>>> QuantityProduct<UNIT, PARAM_BASE_UNIT> multiply(
            PARAM_TYPE quantity) {

        UNIT a = unit();
        Unit<PARAM_BASE_UNIT> b = quantity.unit();

        UnitProduct<UNIT, PARAM_BASE_UNIT> c = a.multiply(b);

        double result = value().doubleValue() * quantity.value().doubleValue();

        return new QuantityProductImpl<UNIT, PARAM_BASE_UNIT>(result, c);
    }

    /**
     * @see org.java0.quantity.Quantity#divide(org.java0.quantity.Quantity)
     */
    @Override
    public <PARAM_BASE_UNIT extends Unit<PARAM_BASE_UNIT>, PARAM_UNIT extends Unit<PARAM_BASE_UNIT>, PARAM_TYPE extends Quantity<? extends Unit<PARAM_BASE_UNIT>>> QuantityQuotient<UNIT, PARAM_BASE_UNIT> divide(
            PARAM_TYPE quantity) {
        UNIT a = unit();
        Unit<PARAM_BASE_UNIT> b = quantity.unit();

        UnitQuotient<UNIT, PARAM_BASE_UNIT> c = a.divide(b);
        double result = value().doubleValue() / quantity.value().doubleValue();

        return new QuantityQuotientImpl<UNIT, PARAM_BASE_UNIT>(result, c);
    }

    /**
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Quantity<UNIT> quantity) {
        double val = quantity.value(unit()).doubleValue();
        if (val < value().doubleValue()) {
            return -1;
        } else if (val > value().doubleValue()) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * @see org.java0.quantity.Quantity#multiply(java.lang.Number)
     */
    @Override
    public Quantity<UNIT> multiply(Number quantity) {
        double product = value().doubleValue() * quantity.doubleValue();
        return new QuantityImpl<UNIT>(product, unit());
    }

    /**
     * @see org.java0.quantity.Quantity#divide(java.lang.Number)
     */
    @Override
    public Quantity<UNIT> divide(Number quantity) {
        double quotient = value().doubleValue() / quantity.doubleValue();
        return new QuantityImpl<UNIT>(quotient, unit());
    }

    /**
     * @see org.java0.quantity.Quantity#abs()
     */
    @Override
    public Quantity<UNIT> abs() {
        return new QuantityImpl<UNIT>(Math.abs(value().doubleValue()), unit());
    }

    /**
     * @param quantity
     * @return
     */
    @Override
    public <PARAM_BASE_UNIT extends Unit<PARAM_BASE_UNIT>, PARAM_UNIT extends Unit<PARAM_BASE_UNIT>, PARAM_TYPE extends Quantity<? extends InverseUnit<PARAM_BASE_UNIT>>> Number multiplyAndCancel(
            PARAM_TYPE quantity) {
        throw new UnsupportedOperationException();
    }

    /**
     * @param quantity
     * @return
     */
    @Override
    public <PARAM_BASE_UNIT extends Unit<PARAM_BASE_UNIT>, PARAM_UNIT extends PARAM_BASE_UNIT, PARAM_TYPE extends Quantity<? extends PARAM_BASE_UNIT>> Number divideAndCancel(
            PARAM_TYPE quantity) {
        throw new UnsupportedOperationException();
    }

}