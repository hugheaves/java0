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

import org.java0.unit.InverseUnit;
import org.java0.unit.NumericUnit;
import org.java0.unit.NumericUnitQuotient;

/**
 * @author Hugh Eaves
 * 
 */
public interface NumericQuotient<U1 extends NumericUnit<?>, U2 extends NumericUnit<?>>
        extends Numeric<NumericUnitQuotient<U1, U2>> {

    /**
     * Returns this quantity with the denominator unit cancelled by multiplying
     * by the given quantity.
     * 
     * @param unit
     * @return a unit
     */
    public Numeric<U1> multiplyAndCancelDenominator(Numeric<U2> unit);

    /**
     * Returns this quantity with the denominator unit cancelled by dividing by
     * the given quantity.
     * 
     * @param unit
     * @return a unit
     */
    public Numeric<U1> divideAndCancelDenominator(Numeric<InverseUnit<U2>> unit);

    /**
     * Returns this quantity with the numerator unit cancelled by multiplying by
     * the given quantity.
     * 
     * @param unit
     * @return a unit
     */
    public Numeric<U2> multiplyAndCancelNumerator(Numeric<InverseUnit<U1>> unit);

    /**
     * Returns this quantity with the numerator unit cancelled by dividing by
     * the given quantity.
     * 
     * @param unit
     * @return a unit
     */
    public Numeric<U2> divideAndCancelNumerator(Numeric<U1> unit);
}
