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
 *
 */
package org.java0.util.collections;

public class AbstractRow implements Row {

    protected Object[] values;
    protected int[] valuePositions;
    protected int hashCode = CollectionsConstants.HASHCODE_MAGIC_NUM;

    public AbstractRow(Object[] values) {
        this.values = new Object[values.length];
        for (int i = 0; i < values.length; ++i) {
            this.values[i] = Null.safe(values[i]);
        }
    }

    @Override
    public Object getValue(int valueNum) {
        return Null.unsafe(values[valueNum]);
    }

    @Override
    public int numColumns() {
        return values.length;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Row) {
            Row row = (Row) obj;

            if (row.numColumns() != numColumns()) {
                return false;
            }

            for (int i = 0; i < numColumns(); ++i) {
                Object a = getValue(i);
                Object b = row.getValue(i);
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
        if (hashCode != CollectionsConstants.HASHCODE_MAGIC_NUM) {
            return hashCode;
        }

        int shift = 32 / numColumns();

        hashCode = 0;

        for (int valueNum = 0; valueNum < numColumns(); ++valueNum) {
            hashCode = hashCode << shift;
            hashCode = hashCode ^ values[valueNum].hashCode();
        }

        return hashCode;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
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