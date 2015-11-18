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
package org.java0.io;

import java.util.logging.Logger;

import org.java0.collection.Buffer;

/**
 * @author Hugh Eaves
 * 
 */
public abstract class AbstractWritableChannel<T> extends AbstractObjectChannel
        implements WritableChannel<T> {
    @SuppressWarnings("unused")
    private static final Logger logger = Logger
            .getLogger(AbstractWritableChannel.class.getName());

    @Override
    public int write(Buffer<T> buffer) {
        return write(buffer, Integer.MAX_VALUE);

    }

    @Override
    public int write(Buffer<T> buffer, int maxValues) {
        int count = 0;
        int numWritten = Integer.MAX_VALUE;
        while (buffer.remainingCapacity() > 0 && count < maxValues
                && numWritten > 0) {
            numWritten = write(buffer.poll());
            count += numWritten;
        }
        return count;
    }
}
