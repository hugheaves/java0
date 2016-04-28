package org.java0.cli;

import java.io.File;

import org.java0.core.exception.Exceptions;
import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;

import com.beust.jcommander.ParameterException;
import com.beust.jcommander.converters.BaseConverter;

public abstract class AbstractInputConverter<T> extends BaseConverter<T> {

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(AbstractInputConverter.class);

    protected AbstractInputConverter(final String optionName) {
        super(optionName);

    }

    @Override
    public T convert(final String value) {
        try {
            if (CLIConst.STANDARD_IO_FLAG.equals(value)) {
                return getDefaultInput();
            } else {
                return getFileInput(createInputFile(value));
            }
        } catch (final Throwable e) {
            Exceptions.throwUnchecked(e);
        }
        return null;
    }

    protected abstract T getDefaultInput() throws Throwable;

    protected abstract T getFileInput(final File inputFile) throws Throwable;

    protected File createInputFile(final String fileName) {
        final File file = new File(fileName);

        if (file.canRead()) {
            return file;
        }

        throw new ParameterException("Unable to read the " + getOptionName() + " file [" + fileName + "]");
    }
}
