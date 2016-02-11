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
package org.java0.amount.impl;

import java.util.logging.Logger;

import org.java0.amount.Amount;
import org.java0.amount.AmountProduct;
import org.java0.amount.AmountQuotient;
import org.java0.amount.InverseAmount;
import org.java0.logging.jul.LogUtil;
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
public class AmountImpl<QUANTITY extends Quantity> implements Amount<QUANTITY> {

    private static final Logger logger = Logger.getLogger(AmountImpl.class
            .getName());
    private static final LogUtil logUtil = new LogUtil(logger);

    protected Number value;
    protected Unit<? extends QUANTITY> unit;

    protected AmountImpl() {

    }

    public AmountImpl(Number value, Unit<? extends QUANTITY> unit) {
        this.value = value;
        this.unit = unit;
    }

    public AmountImpl(double value, Unit<QUANTITY> unit) {
        this.value = value;
        this.unit = unit;
    }

    /**
     * @see org.java0.quantity.Quantity#unit()
     */
    @Override
    public Unit<QUANTITY> unit() {
        return (Unit<QUANTITY>) unit;
    }

    @Override
    public <A extends QUANTITY> Number value(Unit<QUANTITY> unit) {
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
    public Amount<QUANTITY> add(Amount<QUANTITY> amount) {
        double sum = value().doubleValue() + amount.value(unit()).doubleValue();
        return new AmountImpl<QUANTITY>(sum, unit());
    }

    @Override
    public Amount<QUANTITY> subtract(Amount<QUANTITY> amount) {
        double difference = value().doubleValue()
                - amount.value(unit()).doubleValue();
        return new AmountImpl<QUANTITY>(difference, unit());
    }

    /**
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Amount<QUANTITY> quantity) {
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
    public Amount<QUANTITY> multiply(Number quantity) {
        double product = value().doubleValue() * quantity.doubleValue();
        return new AmountImpl<QUANTITY>(product, unit());
    }

    /**
     * @see org.java0.quantity.Quantity#divide(java.lang.Number)
     */
    @Override
    public Amount<QUANTITY> divide(Number quantity) {
        double quotient = value().doubleValue() / quantity.doubleValue();
        return new AmountImpl<QUANTITY>(quotient, unit());
    }

    /**
     * @see org.java0.quantity.Quantity#abs()
     */
    @Override
    public Amount<QUANTITY> abs() {
        return new AmountImpl<QUANTITY>(Math.abs(value().doubleValue()), unit());
    }

    /**
     * @see org.java0.quantity.Quantity#multiply(org.java0.quantity.Quantity)
     */
    @Override
    public <COMBINED_QUANTITY extends QuantityProduct<QUANTITY, PARAM_QUANTITY>, PARAM_QUANTITY extends Quantity> AmountProduct<COMBINED_QUANTITY, QUANTITY, PARAM_QUANTITY> multiply(
            Amount<PARAM_QUANTITY> quantity) {
        Unit<QUANTITY> a = unit();
        Unit<PARAM_QUANTITY> b = quantity.unit();

        UnitProduct<COMBINED_QUANTITY, QUANTITY, PARAM_QUANTITY> c = a
                .multiply(b);

        double result = value().doubleValue() * quantity.value().doubleValue();

        return new AmountProductImpl<COMBINED_QUANTITY, QUANTITY, PARAM_QUANTITY>(
                result, c);
    }

    /**
     * @see org.java0.quantity.Quantity#divide(org.java0.quantity.Quantity)
     */
    @Override
    public <COMBINED_QUANTITY extends QuantityQuotient<QUANTITY, PARAM_QUANTITY>, PARAM_QUANTITY extends Quantity> AmountQuotient<COMBINED_QUANTITY, QUANTITY, PARAM_QUANTITY> divide(
            Amount<PARAM_QUANTITY> quantity) {
        Unit<QUANTITY> a = unit();
        Unit<PARAM_QUANTITY> b = quantity.unit();

        UnitQuotient<COMBINED_QUANTITY, QUANTITY, PARAM_QUANTITY> c = a
                .divide(b);

        double result = value().doubleValue() / quantity.value().doubleValue();

        return new AmountQuotientImpl<COMBINED_QUANTITY, QUANTITY, PARAM_QUANTITY>(
                result, c);
    }

    /**
     * @see org.java0.quantity.Quantity#multiplyAndCancel(org.java0.quantity.Quantity)
     */
    @Override
    public Number multiplyAndCancel(InverseAmount<QUANTITY> quantity) {
        return null;
    }

    /**
     * @see org.java0.quantity.Quantity#divideAndCancel(org.java0.quantity.Quantity)
     */
    @Override
    public Number divideAndCancel(Amount<QUANTITY> quantity) {
        return null;
    }

}