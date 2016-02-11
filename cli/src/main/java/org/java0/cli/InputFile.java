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
package org.java0.cli;

import java.io.File;
import java.net.URI;

// TODO: Auto-generated Javadoc
/**
 * The Class InputFile.
 */
public class InputFile extends File {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new input file.
     *
     * @param pathname
     *            the pathname
     */
    public InputFile(final String pathname) {
        super(pathname);
    }

    /**
     * Instantiates a new input file.
     *
     * @param uri
     *            the uri
     */
    public InputFile(final URI uri) {
        super(uri);
    }

    /**
     * Instantiates a new input file.
     *
     * @param parent
     *            the parent
     * @param child
     *            the child
     */
    public InputFile(final String parent, final String child) {
        super(parent, child);
    }

    /**
     * Instantiates a new input file.
     *
     * @param parent
     *            the parent
     * @param child
     *            the child
     */
    public InputFile(final File parent, final String child) {
        super(parent, child);
    }
}
