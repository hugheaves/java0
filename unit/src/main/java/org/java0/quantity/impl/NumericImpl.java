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
import org.java0.quantity.NumericProduct;
import org.java0.quantity.NumericQuotient;
import org.java0.unit.NumericUnit;
import org.java0.unit.NumericUnitProduct;
import org.java0.unit.NumericUnitQuotient;

/**
 * @author Hugh Eaves
 * 
 */
public class NumericImpl<UNIT_TYPE extends NumericUnit<?>> implements
        Numeric<UNIT_TYPE> {

    private static final Logger logger = Logger.getLogger(NumericImpl.class
            .getName());
    private static final LogUtil logUtil = new LogUtil(logger);

    protected Number value;
    protected UNIT_TYPE unit;

    protected NumericImpl() {

    }

    public NumericImpl(Number value, UNIT_TYPE unit) {
        this.value = value;
        this.unit = unit;
    }

    public NumericImpl(double value, UNIT_TYPE unit) {
        this.value = value;
        this.unit = unit;
    }

    /**
     * @see org.java0.quantity.Numeric#unit()
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
    public Numeric<UNIT_TYPE> add(Numeric<UNIT_TYPE> amount) {
        double sum = value().doubleValue() + amount.value(unit()).doubleValue();
        return new NumericImpl<UNIT_TYPE>(sum, unit());
    }

    @Override
    public Numeric<UNIT_TYPE> subtract(Numeric<UNIT_TYPE> amount) {
        double difference = value().doubleValue()
                - amount.value(unit()).doubleValue();
        return new NumericImpl<UNIT_TYPE>(difference, unit());
    }

    /**
     * @see org.java0.quantity.Numeric#multiply(org.java0.quantity.Numeric)
     */

    // public <P extends NumericUnit<? super P>, Q extends P>
    // NumericUnitProduct<U, P> multiply(Q unit);

    @Override
    public <LOWER_BOUND extends NumericUnit<?>, QUANTITY_TYPE extends Numeric<LOWER_BOUND>> NumericProduct<UNIT_TYPE, LOWER_BOUND> multiply(
            QUANTITY_TYPE quantity) {

        UNIT_TYPE a = unit();
        LOWER_BOUND b = quantity.unit();

        @SuppressWarnings("unchecked")
        NumericUnitProduct<UNIT_TYPE, LOWER_BOUND> c = (NumericUnitProduct<UNIT_TYPE, LOWER_BOUND>) a
                .multiply(b);

        double result = value().doubleValue() * quantity.value().doubleValue();

        return new NumericProductImpl<UNIT_TYPE, LOWER_BOUND>(result, c);

    }

    /**
     * @see org.java0.quantity.Numeric#divide(org.java0.quantity.Numeric)
     */
    @Override
    public <LOWER_BOUND extends NumericUnit<?>, PARAM_QUANTITY_TYPE extends Numeric<LOWER_BOUND>> NumericQuotient<UNIT_TYPE, LOWER_BOUND> divide(
            PARAM_QUANTITY_TYPE quantity) {
        UNIT_TYPE a = unit();
        LOWER_BOUND b = quantity.unit();

        @SuppressWarnings("unchecked")
        NumericUnitQuotient<UNIT_TYPE, LOWER_BOUND> c = (NumericUnitQuotient<UNIT_TYPE, LOWER_BOUND>) a
                .divide(b);

        double result = value().doubleValue() / quantity.value().doubleValue();

        return new NumericQuotientImpl<UNIT_TYPE, LOWER_BOUND>(result, c);

    }

    /**
     * @see org.java0.quantity.Numeric#asType(java.lang.Class)
     */
    @Override
    public <CAST_TYPE extends Numeric<UNIT_TYPE>> CAST_TYPE asType(
            Class<CAST_TYPE> type) {
        throw new UnsupportedOperationException();
    }
}