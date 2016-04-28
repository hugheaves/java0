package org.java0.collection;

import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;

public class HashCachingMap {
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(HashCachingMap.class);

    static double PHI_A = (Math.sqrt(5) + 1) / 2;
    static double PHI_B = (Math.sqrt(5) - 1) / 2;
    static int PHI_INT = (int) Math.round(Math.pow(2, 32) * PHI_B);

    public static void main(final String[] args) {
        System.out.println(PHI_INT);
        System.out.println(Integer.toHexString(PHI_INT));
    }
}
