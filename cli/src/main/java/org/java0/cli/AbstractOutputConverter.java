package org.java0.cli;

import java.io.File;
import java.io.IOException;

import org.java0.core.exception.Exceptions;
import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;

import com.beust.jcommander.ParameterException;
import com.beust.jcommander.converters.BaseConverter;

public abstract class AbstractOutputConverter<T> extends BaseConverter<T> {

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(AbstractOutputConverter.class);

    protected AbstractOutputConverter(final String optionName) {
        super(optionName);

    }

    @Override
    public T convert(final String value) {
        try {
            if (CLIConst.STANDARD_IO_FLAG.equals(value)) {
                return getDefaultOutput();
            } else {
                return getFileOutput(createOutputFile(value));
            }
        } catch (final Throwable e) {
            Exceptions.throwUnchecked(e);
        }
        return null;
    }

    protected abstract T getDefaultOutput() throws Throwable;

    protected abstract T getFileOutput(final File outputFile) throws Throwable;

    protected File createOutputFile(final String fileName) {
        final File file = new File(fileName);

        try {
            if (file.canWrite()) {
                return file;
            } else if (file.createNewFile()) {
                return file;
            }
        } catch (final IOException e) {
        }

        throw new ParameterException("Unable to write to the " + getOptionName() + "file [" + fileName + "]");
    }
}
