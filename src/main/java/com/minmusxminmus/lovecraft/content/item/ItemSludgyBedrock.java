package com.minmusxminmus.lovecraft.content.item;

import com.minmusxminmus.lovecraft.content.block.BlockSludgyBedrock;
import net.minecraft.item.ItemBlock;

public class ItemSludgyBedrock extends ItemBlock {
    public ItemSludgyBedrock() {
        super(new BlockSludgyBedrock());
        setUnlocalizedName(new BlockSludgyBedrock().getUnlocalizedName());
    }
}
