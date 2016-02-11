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

import org.java0.core.type.Constants;
import org.java0.core.type.Null;

public class AbstractTuple implements Tuple {

    protected Object[] values;
    protected int[] valuePositions;
    protected int hashCode = Constants.HASHCODE_MAGIC_NUM;

    protected AbstractTuple(final Object... values) {
        this.values = values;
        for (int i = 0; i < values.length; ++i) {
            this.values[i] = Null.safe(values[i]);
        }
    }

    @Override
    public Object get(final int valueNum) {
        return Null.unsafe(values[valueNum]);
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof Tuple) {
            final Tuple row = (Tuple) obj;

            if (row.size() != size()) {
                return false;
            }

            for (int i = 0; i < size(); ++i) {
                final Object a = get(i);
                final Object b = row.get(i);
                if (a == null || b == null) {
                    if (a != b) {
                        return false;
                    }
                } else {
                    if (!a.equals(b)) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        // Check if we've previously calculated the hashCode.
        // This is a heuristic that assumes (hopefully correctly)
        // that the actual hash code is almost never actually MAGIC_NUM.
        if (hashCode != Constants.HASHCODE_MAGIC_NUM) {
            return hashCode;
        }

        final int shift = 32 / size();

        hashCode = 0;

        for (int valueNum = 0; valueNum < size(); ++valueNum) {
            hashCode = hashCode << shift;
            hashCode = hashCode ^ values[valueNum].hashCode();
        }

        return hashCode;
    }

    @Override
    public String toString() {
        final StringBuffer buffer = new StringBuffer();
        buffer.append(getClass().getName());
        buffer.append(": ");
        for (int i = 0; i < values.length; ++i) {
            if (i > 0) {
                buffer.append(", ");
            }
            buffer.append("values[");
            buffer.append(i);
            buffer.append("]=");
            buffer.append(values[i]);
        }
        return buffer.toString();
    }

}