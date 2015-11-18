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
package org.java0.collection;


/**
 * An object representing the special value "null".
 *
 * @author Hugh Eaves
 *
 */
public final class Null {
    /**
     * Static instance of Null.
     */
    public static final Null INSTANCE = new Null();

    /**
     * Create a new Null.
     *
     */
    private Null() {
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return 0;
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        } else if (object instanceof Null) {
            return true;
        }
        return false;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Null";
    }

    /**
     * Returns Null instance if object == null, object otherwise.
     *
     * @param object the "safed" object
     * @return
     */
    public static Object safe(Object object) {
        if (object == null) {
            return Null.INSTANCE;
        } else {
            return object;
        }
    }

    /**
     * Returns null if object.equals(Null), object otherwise
     *
     * @param object the "unsafed" object
     * @return
     */
    public static Object unsafe(Object object) {
        if (Null.INSTANCE.equals(object)) {
            return null;
        } else {
            return object;
        }
    }
}
