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

import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author Hugh Eaves
 * 
 */
public abstract class AbstractMultiChannel implements MultiChannel {
    @SuppressWarnings("unused")
    private static final Logger logger = Logger
            .getLogger(AbstractMultiChannel.class.getName());

    /**
     * @see java.nio.channels.Channel#isOpen()
     */
    @Override
    public boolean isOpen() {
        return false;
    }

    /**
     * @see java.nio.channels.Channel#close()
     */
    @Override
    public void close() throws IOException {
    }

    @Override
    public <T> int limit(ChannelId<T> channel) {
        return getChannel(channel).limit();
    }

    @Override
    public <T> boolean isBlocking(ChannelId<T> channel) {
        return getChannel(channel).isBlocking();
    }

    @Override
    public <T> boolean hasBlocking(ChannelId<T> channel) {
        return getChannel(channel).hasBlocking();
    }

    @Override
    public <T> boolean hasNonblocking(ChannelId<T> channel) {
        return getChannel(channel).hasNonblocking();
    }

    @Override
    public <T> void configureBlocking(ChannelId<T> channel, boolean blocking)
            throws IOException {
        getChannel(channel).configureBlocking(blocking);

    }
}
