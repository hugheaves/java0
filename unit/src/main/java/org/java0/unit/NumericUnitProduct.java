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
public interface NumericUnitProduct<U1 extends NumericUnit<? super U1>, U2 extends NumericUnit<? super U2>>
        extends BinaryNumericUnit<U1, U2, NumericUnitProduct<U1, U2>> {

    /**
     * Returns this unit with the right unit cancelled by multiplying by the
     * given unit.
     * 
     * @param unit
     * @return a unit
     */
    public U1 multiplyAndCancel2(InverseUnit<U2> unit);

    /**
     * Returns this unit with the left unit cancelled by multiplying by the
     * given unit.
     * 
     * @param unit
     * @return a unit
     */
    public U2 multiplyAndCancel1(InverseUnit<U1> unit);

    /**
     * Returns this unit with the right unit cancelled by dividing by the given
     * unit.
     * 
     * @param unit
     * @return a unit
     */
    public U1 divideAndCancel2(U2 unit);

    /**
     * Returns this unit with the left unit cancelled by dividing by the given
     * unit.
     * 
     * @param unit
     * @return a unit
     */
    public U2 divideAndCancel1(U1 unit);
}