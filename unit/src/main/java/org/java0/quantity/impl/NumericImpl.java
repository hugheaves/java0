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
import org.java0.quantity.Numeric;
import org.java0.unit.NumericUnit;
import org.java0.unit.NumericUnitProduct;
import org.java0.unit.NumericUnitQuotient;

/**
 * @author Hugh Eaves
 * 
 */
public class NumericImpl<U extends NumericUnit<U>> implements Numeric<U> {

    private static final Logger logger = Logger.getLogger(NumericImpl.class
            .getName());
    private static final LogUtil logUtil = new LogUtil(logger);

    protected Number value;
    protected U unit;

    protected NumericImpl() {

    }

    public NumericImpl(Number value, U unit) {
        this.value = value;
        this.unit = unit;
    }

    public NumericImpl(double value, U unit) {
        this.value = value;
        this.unit = unit;
    }

    /**
     * @see org.java0.quantity.Numeric#unit()
     */
    @Override
    public U unit() {
        return unit;
    }

    @Override
    public <A extends U> Number value(A unit) {
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
    public Numeric<U> add(Numeric<U> amount) {
        double sum = value().doubleValue() + amount.value(unit()).doubleValue();
        return new NumericImpl<U>(sum, unit());
    }

    @Override
    public Numeric<U> subtract(Numeric<U> amount) {
        double difference = value().doubleValue()
                - amount.value(unit()).doubleValue();
        return new NumericImpl<U>(difference, unit());
    }

    /**
     * @see org.java0.quantity.Numeric#multiply(org.java0.quantity.Numeric)
     */
    @Override
    public <A extends Numeric<P>, P extends NumericUnit<? super P>> Numeric<NumericUnitProduct<U, P>> multiply(
            A quantity) {
        double product = value().doubleValue() * quantity.value().doubleValue();
        return new NumericProductImpl<U, P>(product, unit().multiply(
                (P) quantity.unit()));

    }

    /**
     * @see org.java0.quantity.Numeric#divide(org.java0.quantity.Numeric)
     */
    @Override
    public <A extends Numeric<P>, P extends NumericUnit<? super P>> Numeric<NumericUnitQuotient<U, P>> divide(
            A quantity) {
        double quotient = value().doubleValue()
                / quantity.value().doubleValue();
        return new NumericQuotientImpl<U, P>(quotient, unit().divide(
                (P) quantity.unit()));
    }

    /**
     * @see org.java0.quantity.Numeric#asType(java.lang.Class)
     */
    @Override
    public <P extends Numeric<? super P>> P asType(Class<P> type) {
        throw new UnsupportedOperationException();
    }
}