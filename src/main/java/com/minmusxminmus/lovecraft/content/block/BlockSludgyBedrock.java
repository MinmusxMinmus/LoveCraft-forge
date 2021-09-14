package com.minmusxminmus.lovecraft.content.block;

import com.minmusxminmus.lovecraft.LoveCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = LoveCraft.MOD_ID)
public class BlockSludgyBedrock extends Block {

    public BlockSludgyBedrock() {
        super(Material.GROUND, MapColor.BLACK);
        setCreativeTab(CreativeTabs.TRANSPORTATION);
        setUnlocalizedName(LoveCraft.MOD_ID + ".sludgy_bedrock");
    }

    @SubscribeEvent
    public static void register(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new BlockSludgyBedrock().setRegistryName(LoveCraft.MOD_ID, "sludgy_bedrock"));
    }
}
