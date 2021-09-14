package com.minmusxminmus.lovecraft.content.item;

import com.minmusxminmus.lovecraft.LoveCraft;
import com.minmusxminmus.lovecraft.content.block.BlockSludgyBedrock;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@Mod.EventBusSubscriber(modid = LoveCraft.MOD_ID)
public class ItemSludgyBedrock extends ItemBlock {
    public ItemSludgyBedrock() {
        super(new BlockSludgyBedrock());
        setUnlocalizedName(new BlockSludgyBedrock().getUnlocalizedName());
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemSludgyBedrock().setRegistryName(LoveCraft.MOD_ID, "sludgyBedrock"));
    }
}
