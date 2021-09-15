package com.minmusxminmus.lovecraft.content.items;

import com.minmusxminmus.lovecraft.content.blocks.BlockSludgyBedrock;
import com.minmusxminmus.lovecraft.util.StringFormatter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

public class ItemSludgyBedrock extends ItemBlock {

    private static final String name = "sludgy_bedrock";

    @ObjectHolder("lovecraft:sludgy_bedrock")
    public static final Item sludgyBedrock = null;

    public ItemSludgyBedrock() {
        super(new BlockSludgyBedrock());
        setUnlocalizedName(new BlockSludgyBedrock().getUnlocalizedName());
        setRegistryName(StringFormatter.registryName(name));
    }
}
