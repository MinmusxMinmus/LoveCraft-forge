package com.minmusxminmus.lovecraft.content.items;

import com.minmusxminmus.lovecraft.util.StringFormatter;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public abstract class LoveCraftItem extends Item {

    private final String name;

    public LoveCraftItem(String name, CreativeTabs creativeTab) {
        super();
        this.name = name;
        setCreativeTab(creativeTab);
        setUnlocalizedName(StringFormatter.unlocalize(name));
        setRegistryName(StringFormatter.registryName(name));
    }

    public String getName() {
        return name;
    }
}
