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
 * The Class OutputFileConverter.
 */
public class OutputFileConverter extends AbstractOutputConverter<OutputFile> {

    /**
     * Instantiates a new output file converter.
     *
     * @param optionName
     *            the option name
     */
    public OutputFileConverter(final String optionName) {
        super(optionName);
    }

    @Override
    protected OutputFile getDefaultOutput() throws Throwable {
        throw new ParameterException(CLIConst.STANDARD_IO_FLAG + " is not a valid output file name");
    }

    @Override
    protected OutputFile getFileOutput(final File outputFile) throws Throwable {
        return new OutputFile(outputFile.getAbsolutePath());
    }
}
