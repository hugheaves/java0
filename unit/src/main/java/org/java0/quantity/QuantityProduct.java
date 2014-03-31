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
import org.java0.unit.Unit;
import org.java0.unit.UnitProduct;

/**
 * @author Hugh Eaves
 * 
 */
public interface QuantityProduct<U1 extends Unit<?, ?>, U2 extends Unit<?, ?>>
        extends Quantity<UnitProduct<U1, U2>> {

    /**
     * Returns this quantity with the right unit cancelled by multiplying by the
     * given quantity.
     * 
     * @param unit
     * @return a unit
     */
    public Quantity<U1> multiplyAndCancelRight(Quantity<InverseUnit<?, ?>> unit);

    /**
     * Returns this quantity with the left unit cancelled by multiplying by the
     * given quantity.
     * 
     * @param unit
     * @return a unit
     */
    public Quantity<U2> multiplyAndCancelLeft(Quantity<InverseUnit<?, ?>> unit);

    /**
     * Returns this quantity with the right unit cancelled by dividing by the
     * given quantity.
     * 
     * @param unit
     * @return a unit
     */
    public Quantity<U1> divideAndCancelRight(Quantity<U2> unit);

    /**
     * Returns this quantity with the left unit cancelled by dividing by the
     * given quantity.
     * 
     * @param unit
     * @return a unit
     */
    public Quantity<U2> divideAndCancelLeft(Quantity<U1> unit);
}
