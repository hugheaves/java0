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

import com.beust.jcommander.ParameterException;

/**
 * The Class InputFileConverter.
 */
public class InputFileConverter extends AbstractInputConverter<InputFile> {

    /**
     * Instantiates a new input file converter.
     *
     * @param optionName
     *            the option name
     */
    public InputFileConverter(final String optionName) {
        super(optionName);
    }

    /**
     * @see org.java0.cli.AbstractInputConverter#getDefaultInput()
     */
    @Override
    protected InputFile getDefaultInput() throws Throwable {
        throw new ParameterException(CLIConst.STANDARD_IO_FLAG + " is not a valid input file name");
    }

    /**
     * @see org.java0.cli.AbstractInputConverter#getFileInput(java.io.File)
     */
    @Override
    protected InputFile getFileInput(final File inputFile) throws Throwable {
        return new InputFile(inputFile.getAbsolutePath());
    }

}
