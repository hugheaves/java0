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
package org.java0.amount;

import org.java0.unit.NumericUnitProduct;
import org.java0.unit.NumericUnitProductImpl;
import org.java0.unit.NumericUnitQuotient;
import org.java0.unit.NumericUnitQuotientImpl;
import org.java0.unit.UnitType;

/**
 * @author Hugh Eaves
 * 
 */
public class NumericAmountImpl<U extends UnitType<Number, U>> implements
		NumericAmount<U> {

	private Number value;
	private U unit;

	public NumericAmountImpl(Number value, U unit) {
		this.value = value;
		this.unit = unit;
	}

	@Override
	public U getUnit() {
		return unit;
	}

	@Override
	public <A extends U> Number getValue(A unit) {
		Number newValue = unit.convertFromSystem(getSystemValue());
		return newValue;
	}

	public String toString() {
		return (this.getClass().getName() + ": " + value);
	}


	@Override
	public NumericAmount<U> subtract(NumericAmount<? extends U> amount) {
		return new NumericAmountImpl<U>(this.getUnit()
				.convertFromSystem(
						this.getSystemValue()
								.doubleValue()
								- getSystemValue()
										.doubleValue()), this.getUnit());
	}

	@Override
	public NumericAmount<U> add(NumericAmount<? extends U> amount) {
		return new NumericAmountImpl<U>(this.getUnit()
				.convertFromSystem(
						getSystemValue()
								.doubleValue()
								- amount.getSystemValue()
										.doubleValue()), this.getUnit());

	}

	@Override
	public <A2 extends NumericAmount<U2>, U2 extends UnitType<Number, ?>> NumericAmount<NumericUnitProduct<U, U2>> multiply(
			A2 amount) {
		Number product = getSystemValue().doubleValue() * amount.getSystemValue().doubleValue();
		NumericUnitProduct<U, U2> newUnit = new NumericUnitProductImpl<U, U2>(
				getUnit(), amount.getUnit());
		NumericAmount<NumericUnitProduct<U, U2>> newAmount = new NumericAmountImpl<NumericUnitProduct<U, U2>> (product, newUnit);
		return newAmount;
	}


	@Override
	public <A2 extends NumericAmount<U2>, U2 extends UnitType<Number, ?>> NumericAmount<NumericUnitQuotient<U, U2>> divde(
			A2 amount) {
		Number product = getSystemValue().doubleValue() / amount.getSystemValue().doubleValue();
		NumericUnitQuotient<U, U2> newUnit = new NumericUnitQuotientImpl<U, U2>(
				getUnit(), amount.getUnit());
		NumericAmount<NumericUnitQuotient<U, U2>> newAmount = new NumericAmountImpl<NumericUnitQuotient<U, U2>> (product, newUnit);
		return newAmount;
	}

	@Override
	public Number getSystemValue() {
		return getUnit().convertToSystem(value);
	}

}