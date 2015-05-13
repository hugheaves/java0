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
package org.java0.collection.rowset;


/**
 * @author Hugh Eaves
 *
 */
public class TwoColumnRow<T1, T2> extends AbstractRow {

    /**
     * Create a new TwoColumnRow.
     *
     * @param t1
     * @param t2
     */
    public <V1 extends T1, V2 extends T2> TwoColumnRow(V1 t1, V2 t2) {
        super(new Object[] { t1, t2 });
    }

    /**
     * Create a new TwoColumnRow.
     *
     * @param objects
     */
    protected TwoColumnRow(Object[] objects) {
        super(objects);
    }

    @SuppressWarnings("unchecked")
    public T1 getColumn1() {
        return (T1) this.getValue(0);
    }

    @SuppressWarnings("unchecked")
    public T2 getColumn2() {
        return (T2) this.getValue(1);
    }
}
