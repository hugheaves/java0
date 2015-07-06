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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.beust.jcommander.ParameterException;
import com.beust.jcommander.converters.BaseConverter;

// TODO: Auto-generated Javadoc
/**
 * The Class OutputStreamConverter.
 */
public class OutputStreamConverter extends BaseConverter<OutputStream> {

	/**
	 * Instantiates a new output stream converter.
	 *
	 * @param optionName
	 *            the option name
	 */
	public OutputStreamConverter(String optionName) {
		super(optionName);
	}

	/**
	 * @see com.beust.jcommander.IStringConverter#convert(java.lang.String)
	 */
	@Override
	public OutputStream convert(String value) {
		if ("-".equals(value)) {
			return System.out;
		}

		File file = new File(value);

		try {
			if (file.canWrite()) {
				return new FileOutputStream(file);
			} else if (file.createNewFile()) {
				return new FileOutputStream(file);
			}
		} catch (IOException e) {
		}

		throw new ParameterException("Unable to write to the "
				+ getOptionName() + "file [" + value + "]");
	}
}
