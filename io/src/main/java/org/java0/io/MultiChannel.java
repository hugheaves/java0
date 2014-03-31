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
import java.nio.channels.Channel;

/**
 * @author Hugh Eaves
 * 
 */
public interface MultiChannel extends Channel {
    /**
     * Returns the number of values that can processed without blocking.
     * 
     * @return
     */
    public <T extends Object> int limit(ChannelId<T> channelId);

    /**
     * Returns true if this {@code ObjectChannel} is in blocking mode. An
     * interface in blocking mode blocks on operations until they are complete
     * and/or data is available.
     * 
     * @return true is the interface is in blocking mode
     */
    public <T extends Object> boolean isBlocking(ChannelId<T> channelId);

    /**
     * Indicates whether the {@code ObjectChannel} supports blocking mode.
     * 
     * @return true if blocking mode is supported.
     */
    public <T extends Object> boolean hasBlocking(ChannelId<T> channelId);

    /**
     * Indicates whether this {@code ObjectChannel} supports non-blocking mode.
     * 
     * @return true if non-blocking mode is supported.
     */
    public <T extends Object> boolean hasNonblocking(ChannelId<T> channelId);

    /**
     * Switches the {@code ObjectChannel} into blocking or non-blocking mode.
     * 
     * @param blocking
     *            Indicates whether to switch to blocking mode (true) or
     *            non-blocking mode (false).
     * @throws BlockingException
     *             If the requested mode is not supported by this
     *             {@code ObjectChannel}.
     */
    public <T extends Object> void configureBlocking(ChannelId<T> channelId,
            boolean blocking) throws IOException;

    /**
     * Returns the ObjectChannel matching the given channel id.
     * 
     * @param channel
     * @return
     */
    public <T extends Object> ObjectChannel getChannel(ChannelId<T> channelId);
}
