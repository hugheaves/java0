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

import org.java0.quantity.BinaryQuantity;
import org.java0.quantity.Quantity;

/**
 * The Interface BinaryNumericUnit.
 * 
 * @author Hugh Eaves
 * @param <UNIT_1>
 *            the generic type
 * @param <UNIT_2>
 *            the generic type
 * @param <COMBINED_UNIT>
 *            the generic type
 */
public interface BinaryUnit<COMBINED_QUANTITY extends BinaryQuantity<QUANTITY_1, QUANTITY_2>, QUANTITY_1 extends Quantity, QUANTITY_2 extends Quantity>
        extends Unit<COMBINED_QUANTITY> {
    /**
     * Returns the first / left unit of this binary numeric unit.
     * 
     * @return a unit
     */
    public Unit<QUANTITY_1> getUniT0();

    /**
     * Returns the second / right unit of this binary numeric unit.
     * 
     * @return a unit
     */
    public Unit<QUANTITY_2> getUnit2();

    /**
     * Gets the relationship between these two units;.
     * 
     * @return the operator
     */
    public String getOperator();
}