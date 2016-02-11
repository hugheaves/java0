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
package org.java0.collection.tuple;

/**
 * @author Hugh Eaves
 *
 */
public class TwoTuple<T0, T1> extends AbstractTuple {

    public <V0 extends T0, V1 extends T1> TwoTuple(final V0 value0, final V1 value1) {
        super(value0, value1);
    }

    protected TwoTuple(final Object... values) {
        super(values);
    }

    @SuppressWarnings("unchecked")
    public T0 get0() {
        return (T0) this.get(0);
    }

    @SuppressWarnings("unchecked")
    public T1 get1() {
        return (T1) this.get(1);
    }
}
