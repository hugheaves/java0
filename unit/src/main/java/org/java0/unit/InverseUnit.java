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
 * This class represents an "inverse" or "inverted" unit. (i.e. 1 / UNIT instead
 * of just UNIT)
 * 
 * @author Hugh Eaves
 * @param <BASE_UNIT>
 *            the generic type
 */
public interface InverseUnit<BASE_UNIT extends Unit<?>> extends Unit<BASE_UNIT> {
    /**
     * Returns the uninverted unit. (or the inverse of the inverse).
     * 
     * @return the uninverted unit.
     */
    public Unit<BASE_UNIT> uninvert();
}
