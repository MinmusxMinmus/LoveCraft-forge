package com.minmusxminmus.lovecraft.content.items;

import com.minmusxminmus.lovecraft.content.blocks.BlockSludgyBedrock;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

public class ItemSludgyBedrock extends LoveCraftItemBlock {

    @ObjectHolder("lovecraft:sludgy_bedrock")
    public static final Item sludgyBedrock = null;

    public ItemSludgyBedrock() {
        super(new BlockSludgyBedrock(), "sludgy_bedrock", CreativeTabs.TRANSPORTATION);
    }
}
