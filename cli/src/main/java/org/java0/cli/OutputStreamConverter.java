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
import java.io.OutputStream;

import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;

/**
 * The Class OutputStreamConverter.
 */
public class OutputStreamConverter extends AbstractOutputConverter<OutputStream> {
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(OutputStreamConverter.class);

    /**
     * Instantiates a new output stream converter.
     *
     * @param optionName
     *            the option name
     */
    public OutputStreamConverter(final String optionName) {
        super(optionName);
    }

    @Override
    protected OutputStream getDefaultOutput() throws Throwable {
        return System.out;
    }

    @Override
    protected OutputStream getFileOutput(final File outputFile) throws Throwable {
        return new FileOutputStream(outputFile);
    }

}
