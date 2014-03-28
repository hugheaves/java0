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
package org.java0.quantity;

import org.java0.unit.NumericUnit;
import org.java0.unit.NumericUnitProduct;
import org.java0.unit.NumericUnitQuotient;

/**
 * @author Hugh Eaves
 * 
 */
public interface Numeric<U extends NumericUnit<? super U>> extends
        Quantity<Number, U>
/* , org.unitsofmeasurement.quantity.Quantity<NumericQuantity<U>> */{

    /**
     * Subtracts the given quantity from this one.
     * 
     * @param quantity
     * @return
     */
    public Numeric<U> subtract(Numeric<U> quantity);

    /**
     * Adds the given quantity to this one.
     * 
     * @param quantity
     * @return
     */
    public Numeric<U> add(Numeric<U> quantity);

    /**
     * Multiplies the given quantity by this one.
     * 
     * @param quantity
     * @return
     */
    public <A extends Numeric<P>, P extends NumericUnit<? super P>> Numeric<NumericUnitProduct<U, P>> multiply(
            A quantity);

    /**
     * Divides this quantity by the given one.
     * 
     * @param quantity
     * @return
     */
    public <A extends Numeric<P>, P extends NumericUnit<? super P>> Numeric<NumericUnitQuotient<U, P>> divide(
            A quantity);

    /**
     * Returns this quantity as the specified concrete type.
     * 
     * @param type
     * @return
     */
    public <P extends Numeric<? super P>> P asType(Class<P> type);

    /**
     * @see org.java0.quantity.Quantity#unit()
     */
    @Override
    public NumericUnit<U> unit();
}
