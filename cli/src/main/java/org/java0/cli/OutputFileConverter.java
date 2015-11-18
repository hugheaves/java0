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
import java.io.IOException;

import com.beust.jcommander.ParameterException;
import com.beust.jcommander.converters.BaseConverter;

/**
 * The Class OutputFileConverter.
 */
public class OutputFileConverter extends BaseConverter<File> {

	/**
	 * Instantiates a new output file converter.
	 *
	 * @param optionName
	 *            the option name
	 */
	public OutputFileConverter(String optionName) {
		super(optionName);
	}

	/**
	 * @see com.beust.jcommander.IStringConverter#convert(java.lang.String)
	 */
	@Override
	public OutputFile convert(String value) {
		OutputFile file = new OutputFile(value);

		try {
			if (file.canWrite()) {
				return file;
			} else if (file.createNewFile()) {
				return file;
			}
		} catch (IOException e) {
		}

		throw new ParameterException("Unable to write to the "
				+ getOptionName() + "file [" + value + "]");
	}
}
