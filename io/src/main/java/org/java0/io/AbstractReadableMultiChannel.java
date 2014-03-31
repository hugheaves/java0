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
public abstract class AbstractReadableMultiChannel extends AbstractMultiChannel
        implements ReadableMultiChannel {
    @SuppressWarnings("unused")
    private static final Logger logger = Logger
            .getLogger(AbstractReadableMultiChannel.class.getName());

    /**
     * @see org.java0.io.ReadableMultiChannel#read(org.java0.io.ReadableChannelId)
     */
    @Override
    public <T> T read(ReadableChannelId<T> channelId) {
        return getChannel(channelId).read();
    }

    /**
     * @see org.java0.io.ReadableMultiChannel#read(org.java0.io.ReadableChannelId,
     *      org.java0.collection.Buffer, int)
     */
    @Override
    public <T> int read(ReadableChannelId<T> channelId, Buffer<T> buffer,
            int maxValues) {
        return getChannel(channelId).read(buffer, maxValues);
    }

    /**
     * @see org.java0.io.ReadableMultiChannel#read(org.java0.io.ReadableChannelId,
     *      org.java0.collection.Buffer)
     */
    @Override
    public <T> int read(ReadableChannelId<T> channelId, Buffer<T> buffer) {
        return getChannel(channelId).read(buffer);
    }

    /**
     * @see org.java0.io.ReadableMultiChannel#getChannel(org.java0.io.ReadableChannelId)
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> ReadableChannel<T> getChannel(ReadableChannelId<T> channelId) {
        return (ReadableChannel<T>) getChannel((ChannelId<T>) channelId);
    }
}
