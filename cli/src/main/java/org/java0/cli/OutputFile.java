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
 * The Class OutputFile.
 */
public class OutputFile extends File {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4843292651911600107L;

	/**
	 * Instantiates a new output file.
	 *
	 * @param pathname
	 *            the pathname
	 */
	public OutputFile(String pathname) {
		super(pathname);
	}

	/**
	 * Instantiates a new output file.
	 *
	 * @param uri
	 *            the uri
	 */
	public OutputFile(URI uri) {
		super(uri);
	}

	/**
	 * Instantiates a new output file.
	 *
	 * @param parent
	 *            the parent
	 * @param child
	 *            the child
	 */
	public OutputFile(String parent, String child) {
		super(parent, child);
	}

	/**
	 * Instantiates a new output file.
	 *
	 * @param parent
	 *            the parent
	 * @param child
	 *            the child
	 */
	public OutputFile(File parent, String child) {
		super(parent, child);
	}

}
