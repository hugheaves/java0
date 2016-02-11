package org.java0.string;

import java.io.IOException;
import java.io.InputStream;

public class CharArrayInputStream extends InputStream {
    private final char[] chars;
    private int pos = 0;

    public CharArrayInputStream(final char[] chars) {
        this.chars = chars;
    }

    @Override
    public int read() throws IOException {
        if (pos >= chars.length) {
            return -1;
        } else {
            return (chars[pos++] & 0xff);
        }
    }

}
