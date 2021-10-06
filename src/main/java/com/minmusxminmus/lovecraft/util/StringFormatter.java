package com.minmusxminmus.lovecraft.util;

import net.minecraft.util.ResourceLocation;

import static com.minmusxminmus.lovecraft.LoveCraft.MOD_ID;

public class StringFormatter {
    public static String unlocalize(String itemName) {
        return MOD_ID + "." + itemName;
    }

    public static ResourceLocation asResourceLocation(String name) {
        return new ResourceLocation(MOD_ID, name);
    }
}
