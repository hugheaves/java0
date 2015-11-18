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
package org.java0.unit;

import org.java0.quantity.Quantity;
import org.java0.quantity.QuantityProduct;

/**
 * The Interface NumericUnitProduct.
 * 
 * @author Hugh Eaves
 * @param <UNIT_1>
 *            the generic type
 * @param <UNIT_2>
 *            the generic type
 */
public interface UnitProduct<COMBINED_QUANTITY extends QuantityProduct<QUANTITY_1, QUANTITY_2>, QUANTITY_1 extends Quantity, QUANTITY_2 extends Quantity>
        extends BinaryUnit<COMBINED_QUANTITY, QUANTITY_1, QUANTITY_2> {

    /**
     * Returns this unit with the right unit cancelled by multiplying by the
     * given unit.
     * 
     * @param unit
     *            the unit
     * @return a unit
     */
    public Unit<QUANTITY_1> multiplyAndCancel2(InverseUnit<QUANTITY_2> unit);

    /**
     * Returns this unit with the left unit cancelled by multiplying by the
     * given unit.
     * 
     * @param unit
     *            the unit
     * @return a unit
     */
    public Unit<QUANTITY_2> multiplyAndCancel1(InverseUnit<QUANTITY_1> unit);

    /**
     * Returns this unit with the right unit cancelled by dividing by the given
     * unit.
     * 
     * @param unit
     *            the unit
     * @return a unit
     */
    public Unit<QUANTITY_1> divideAndCancel2(Unit<QUANTITY_1> unit);

    /**
     * Returns this unit with the left unit cancelled by dividing by the given
     * unit.
     * 
     * @param unit
     *            the unit
     * @return a unit
     */
    public Unit<QUANTITY_1> divideAndCancel1(Unit<QUANTITY_1> unit);
}