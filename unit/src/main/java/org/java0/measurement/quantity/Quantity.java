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
package org.java0.measurement.quantity;

public interface Quantity<T extends Quantity<?>> extends QuantityBase {
    // Unit unit();
    //
    Quantity<T> add(Quantity<T> value);

    Quantity<T> subtract(Quantity<T> value);

    <U extends Quantity<?>> QuantityProduct<T, U> multiply(Quantity<U> quantity);

    <U extends Quantity<?>> QuantityQuotient<T, U> divide(Quantity<U> quantity);

}
