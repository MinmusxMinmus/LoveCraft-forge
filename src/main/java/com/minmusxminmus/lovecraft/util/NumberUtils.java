package com.minmusxminmus.lovecraft.util;

public class NumberUtils {

    private static final double EPSILON = 1.0E-07;

    public static boolean doubleEqual(double a, double b) {
        return Math.abs(a - b) < EPSILON;
    }
}
