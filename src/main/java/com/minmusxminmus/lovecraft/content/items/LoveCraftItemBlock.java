package com.minmusxminmus.lovecraft.content.items;

import com.minmusxminmus.lovecraft.util.StringFormatter;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;

public abstract class LoveCraftItemBlock extends ItemBlock {

    private final String name;

    public LoveCraftItemBlock(Block block, String name, CreativeTabs creativeTab) {
        super(block);
        this.name = name;
        setCreativeTab(creativeTab);
        setRegistryName(StringFormatter.registryName(name));
        setUnlocalizedName(StringFormatter.unlocalize(name));
    }

    public String getName() {
        return name;
    }
}
