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
 * The Interface QuantityProduct.
 * 
 * @author Hugh Eaves
 * @param <UNIT_1>
 *            the generic type
 * @param <UNIT_2>
 *            the generic type
 */
public interface QuantityProduct<UNIT_1 extends Unit<UNIT_1>, UNIT_2 extends Unit<UNIT_2>>
        extends Quantity<UnitProduct<UNIT_1, UNIT_2>> {

    /**
     * Returns this quantity with the right unit cancelled by multiplying by the
     * given quantity.
     * 
     * @param unit
     *            the unit
     * @return a unit
     */
    public Quantity<UNIT_1> multiplyAndCancelRight(
            Quantity<InverseUnit<UNIT_2>> unit);

    /**
     * Returns this quantity with the left unit cancelled by multiplying by the
     * given quantity.
     * 
     * @param unit
     *            the unit
     * @return a unit
     */
    public Quantity<UNIT_2> multiplyAndCancelLeft(
            Quantity<InverseUnit<UNIT_1>> unit);

    /**
     * Returns this quantity with the right unit cancelled by dividing by the
     * given quantity.
     * 
     * @param unit
     *            the unit
     * @return a unit
     */
    public Quantity<UNIT_1> divideAndCancelRight(Quantity<UNIT_2> unit);

    /**
     * Returns this quantity with the left unit cancelled by dividing by the
     * given quantity.
     * 
     * @param unit
     *            the unit
     * @return a unit
     */
    public Quantity<UNIT_2> divideAndCancelLeft(Quantity<UNIT_1> unit);
}
