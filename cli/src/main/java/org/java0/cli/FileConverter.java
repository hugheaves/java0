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
package org.java0.cli;

import java.io.File;

import com.beust.jcommander.converters.BaseConverter;

/**
 * @author Hugh Eaves
 *
 */
public class FileConverter extends BaseConverter<File> {

	/**
	 * Instantiates a new file converter.
	 *
	 * @param optionName
	 *            the option name
	 */
	public FileConverter(String optionName) {
		super(optionName);
	}

	/**
	 * @see com.beust.jcommander.IStringConverter#convert(java.lang.String)
	 */
	@Override
	public File convert(String value) {
		File file = new File(value);
		return file;
	}
}
