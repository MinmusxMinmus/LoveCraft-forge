package com.minmusxminmus.lovecraft.util;

import static com.minmusxminmus.lovecraft.LoveCraft.MOD_ID;

public class StringFormatter {
    public static String unlocalize(String itemName) {
        return MOD_ID + "." + itemName;
    }

    public static String registryName(String itemName) {
        return MOD_ID + ":" + itemName;
    }
}
