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
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamConverter extends AbstractOutputConverter<PrintStream> {

    /**
     * Instantiates a new output stream converter.
     *
     * @param optionName
     *            the option name
     */
    public PrintStreamConverter(final String optionName) {
        super(optionName);
    }

    @Override
    protected PrintStream getDefaultOutput() throws Throwable {
        return System.out;
    }

    @Override
    protected PrintStream getFileOutput(final File outputFile) throws Throwable {
        return new PrintStream(new FileOutputStream(outputFile), true);
    }
}
