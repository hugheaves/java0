/*
 * robotjava-core
 *
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
 * 
 */
package org.java0.unit;

/**
 * @author Hugh Eaves
 * 
 */
public class NumericUnitProductImpl<U1 extends UnitType<Number, ?>, U2 extends UnitType<Number, ?>>
		implements NumericUnitProduct<U1, U2> {

	protected UnitType<Number, U1> unit1;
	protected UnitType<Number, U2> unit2;

	public NumericUnitProductImpl(UnitType<Number, U1> unit1,
			UnitType<Number, U2> unit2) {
		this.unit1 = unit1;
		this.unit2 = unit2;
	}

	@Override
	public Number convertToSystem(Number value) {
		Number value1 = unit1.convertToSystem(value);
		Number value2 = unit2.convertToSystem(value);
		return value1.doubleValue() * value2.doubleValue();
	}

	@Override
	public Number convertFromSystem(Number value) {
		return unit1.convertFromSystem(value).doubleValue()
				* unit2.convertFromSystem(value).doubleValue();
	}
}