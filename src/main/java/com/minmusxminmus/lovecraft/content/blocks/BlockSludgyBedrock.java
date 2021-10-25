package com.minmusxminmus.lovecraft.content.blocks;

import com.minmusxminmus.lovecraft.util.StringFormatter;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

public class BlockSludgyBedrock extends Block implements BlockItem {

    private static final String name = "sludgy_bedrock";

    @ObjectHolder("lovecraft:sludgy_bedrock")
    public static final Block INSTANCE_BLOCK = null;

    @ObjectHolder("lovecraft:sludgy_bedrock")
    public static final Item INSTANCE_ITEM = null;

    public BlockSludgyBedrock() {
        super(Material.GROUND, MapColor.BLACK);
        setUnlocalizedName(StringFormatter.unlocalize(name));
        setRegistryName(StringFormatter.registryName(name));
        setCreativeTab(CreativeTabs.TRANSPORTATION);
    }

    @Override
    public Item getItem() {
        return new ItemBlock(this).setRegistryName(this.getRegistryName());
    }
}
