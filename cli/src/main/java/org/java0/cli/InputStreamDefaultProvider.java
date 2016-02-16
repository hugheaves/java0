package org.java0.cli;

import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;

import com.beust.jcommander.IDefaultProvider;

public class InputStreamDefaultProvider implements IDefaultProvider {
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(InputStreamDefaultProvider.class);

    @Override
    public String getDefaultValueFor(final String optionName) {
        return "-i".equals(optionName) ? "-" : null;
    }
}
