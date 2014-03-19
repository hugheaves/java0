/*
 * robotjava
 *
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
 *
 */
package org.java0.util.logging;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * A java.util.logging formatter than's more CPU efficient than the format based
 * SimpleFormat. (Which is nice for low resource platforms)
 *
 * @author Hugh Eaves
 *
 */
public class FastFormatter extends Formatter {

	/**
	 * @see java.util.logging.Formatter#format(java.util.logging.LogRecord)
	 */
	@Override
	public String format(LogRecord record) {
		StringBuffer formattedRecord = new StringBuffer();

		formattedRecord.append("| ");
		formattedRecord.append(record.getMillis());
		formattedRecord.append(" | ");
		formattedRecord.append(record.getLevel().getName());
		formattedRecord.append(" | ");
		formattedRecord.append(record.getMessage());
		formattedRecord.append(" | ");
		Object[] parameters = record.getParameters();
		if (parameters != null) {
			for (int i = 0; i < parameters.length; ++i) {
				if (i > 0) {
					formattedRecord.append(", ");
				}
				formattedRecord.append(parameters[i]);
			}
		}
		formattedRecord.append(" | ");
		formattedRecord.append(record.getLoggerName());
		formattedRecord.append(" | ");
		if (record.getThrown() != null) {
			record.getThrown().getMessage();
			StringWriter stringWriter = new StringWriter();
			record.getThrown().printStackTrace(new PrintWriter(stringWriter));
			formattedRecord.append(stringWriter);
		}
		formattedRecord.append(" |\n");

		return formattedRecord.toString();
	}

}
