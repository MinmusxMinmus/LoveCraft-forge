package com.minmusxminmus.lovecraft.content.blocks;

import com.minmusxminmus.lovecraft.util.StringFormatter;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

public class BlockSludgyBedrock extends Block {

    private static final String name = "sludgy_bedrock";

    @ObjectHolder("lovecraft:sludgy_bedrock")
    public static final Block INSTANCE = null;

    public BlockSludgyBedrock() {
        super(Material.GROUND, MapColor.BLACK);
        setUnlocalizedName(StringFormatter.unlocalize(name));
        setRegistryName(StringFormatter.registryName(name));
    }
}
