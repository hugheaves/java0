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
package org.java0.unit;

// TODO: Auto-generated Javadoc
/**
 * The Interface BinaryNumericUnit.
 * 
 * @author Hugh Eaves
 * @param <U1>
 *            the generic type
 * @param <U2>
 *            the generic type
 * @param <T>
 *            the generic type
 */
public interface BinaryNumericUnit<UNIT_1_TYPE extends NumericUnit<?>, UNIT_2_TYPE extends NumericUnit<?>, UNIT_TYPE extends NumericUnit<?>>
        extends NumericUnit<UNIT_TYPE> {
    /**
     * Returns the first / left unit of this binary numeric unit.
     * 
     * @return a unit
     */
    public UNIT_1_TYPE getUnit1();

    /**
     * Returns the second / right unit of this binary numeric unit.
     * 
     * @return a unit
     */
    public UNIT_2_TYPE getUnit2();

    /**
     * Gets the relationship between these two units;.
     * 
     * @return the operator
     */
    public String getOperator();
}