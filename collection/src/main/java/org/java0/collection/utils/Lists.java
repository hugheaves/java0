package org.java0.collection.utils;

import java.util.List;

import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;

public class Lists {
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(Lists.class);

    public static <T> void fillToCapacity(final List<T> list, final T fillValue, final int capacity) {
        for (int i = list.size(); i < capacity; ++i) {
            list.add(fillValue);
        }
    }
}
