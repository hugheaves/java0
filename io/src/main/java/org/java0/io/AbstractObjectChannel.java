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

import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author Hugh Eaves
 * 
 */

public abstract class AbstractObjectChannel implements ObjectChannel {
    @SuppressWarnings("unused")
    private static final Logger logger = Logger
            .getLogger(AbstractObjectChannel.class.getName());

    protected boolean blocking;
    protected boolean open;

    /**
     * Create a new AbstractIOChannel.
     * 
     */
    protected AbstractObjectChannel() {
        open = true;
        blocking = true;
    }

    /**
     * @see java.nio.channels.Channel#isOpen()
     */
    @Override
    public boolean isOpen() {
        return open;
    }

    /**
     * @see java.nio.channels.Channel#close()
     */
    @Override
    public void close() throws IOException {
        open = false;
    }

    /**
     * @see java.nio.channels.SelectableChannel#isBlocking()
     */
    @Override
    public boolean isBlocking() {
        return blocking;
    }

    /**
     * @see java.nio.channels.SelectableChannel#configureBlocking()
     */
    @Override
    public void configureBlocking(boolean blocking) throws IOException {
        this.blocking = blocking;
    }

    /**
     * @see org.java0.io.ObjectChannel#hasBlocking()
     */
    @Override
    public boolean hasBlocking() {
        return true;
    }

    /**
     * @see org.java0.io.ObjectChannel#hasNonblocking()
     */
    @Override
    public boolean hasNonblocking() {
        return true;
    }
}
