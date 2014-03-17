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
package org.java0.amount;

import org.java0.unit.NumericUnitProduct;
import org.java0.unit.NumericUnitQuotient;
import org.java0.unit.UnitType;

/**
 * @author Hugh Eaves
 * 
 */
public interface NumericAmount<U extends UnitType<Number, ?>>
		extends Amount<Number, U> {
	public NumericAmount<U> subtract(NumericAmount<? extends U> amount);
	public NumericAmount<U> add(NumericAmount<? extends U> amount);
	public <A2 extends NumericAmount<U2>, U2 extends UnitType<Number, ?>> NumericAmount<NumericUnitProduct<U, U2>> multiply(A2 amount);
	public <A2 extends NumericAmount<U2>, U2 extends UnitType<Number, ?>> NumericAmount<NumericUnitQuotient<U, U2>> divde(A2 amount);

}
