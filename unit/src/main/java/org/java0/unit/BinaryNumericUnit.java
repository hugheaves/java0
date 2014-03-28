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

/**
 * @author Hugh Eaves
 * 
 */
public interface BinaryNumericUnit<U1 extends NumericUnit<? super U1>, U2 extends NumericUnit<? super U2>, T extends NumericUnit<? super T>>
        extends NumericUnit<T> {
    /**
     * Returns the first / left unit of this binary numeric unit.
     * 
     * @return a unit
     */
    public U1 getUnit1();

    /**
     * Returns the second / right unit of this binary numeric unit.
     * 
     * @return a unit
     */
    public U2 getUnit2();

    /**
     * Gets the relationship between these two units;
     * 
     * @return
     */
    public String getOperator();
}