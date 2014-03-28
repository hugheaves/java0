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
public interface NumericUnit<U extends NumericUnit<? super U>> extends
        Unit<Number, U>
/* ,org.unitsofmeasurement.unit.Unit<NumericQuantity<U>> */{

    /**
     * Returns the product of two numeric units.
     * 
     * @param unit
     * @return
     */
    public <P extends NumericUnit<? super P>, Q extends P> NumericUnitProduct<U, P> multiply(
            Q unit);

    /**
     * Returns the quotient of two numeric units.
     * 
     * @param unit
     * @return
     */
    public <P extends NumericUnit<? super P>, Q extends P> NumericUnitQuotient<U, P> divide(
            Q unit);

    /**
     * Returns the inverse of this unit.
     * 
     * @return
     */
    public InverseUnit<U> invert();

    /**
     * @see org.java0.unit.Unit#getSystemUnit()
     */
    @Override
    public U getSystemUnit();
}
