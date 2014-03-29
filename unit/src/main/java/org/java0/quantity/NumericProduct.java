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
import org.java0.unit.NumericUnitProduct;

/**
 * @author Hugh Eaves
 * 
 */
public interface NumericProduct<U1 extends NumericUnit<?>, U2 extends NumericUnit<?>>
        extends Numeric<NumericUnitProduct<U1, U2>> {

    /**
     * Returns this quantity with the right unit cancelled by multiplying by the
     * given quantity.
     * 
     * @param unit
     * @return a unit
     */
    public Numeric<U1> multiplyAndCancelRight(Numeric<InverseUnit<U2>> unit);

    /**
     * Returns this quantity with the left unit cancelled by multiplying by the
     * given quantity.
     * 
     * @param unit
     * @return a unit
     */
    public Numeric<U2> multiplyAndCancelLeft(Numeric<InverseUnit<U1>> unit);

    /**
     * Returns this quantity with the right unit cancelled by dividing by the
     * given quantity.
     * 
     * @param unit
     * @return a unit
     */
    public Numeric<U1> divideAndCancelRight(Numeric<U2> unit);

    /**
     * Returns this quantity with the left unit cancelled by dividing by the
     * given quantity.
     * 
     * @param unit
     * @return a unit
     */
    public Numeric<U2> divideAndCancelLeft(Numeric<U1> unit);
}
