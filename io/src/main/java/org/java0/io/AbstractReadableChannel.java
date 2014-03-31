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
package org.java0.io;

import java.util.logging.Logger;

import org.java0.collection.Buffer;

/**
 * @author Hugh Eaves
 * 
 */
public abstract class AbstractReadableChannel<T> extends AbstractObjectChannel
        implements ReadableChannel<T> {
    @SuppressWarnings("unused")
    private static final Logger logger = Logger
            .getLogger(AbstractReadableChannel.class.getName());

    @Override
    public int read(Buffer<T> buffer) {
        return read(buffer, Integer.MAX_VALUE);
    }

    @Override
    public int read(Buffer<T> buffer, int maxValues) {
        int count = 0;
        T val;
        while (buffer.remainingCapacity() > 0 && count < maxValues
                && (val = read()) != null) {
            buffer.add(val);
            ++count;
        }
        return count;
    }
}
