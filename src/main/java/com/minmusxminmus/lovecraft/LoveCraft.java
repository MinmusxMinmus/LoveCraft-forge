package com.minmusxminmus.lovecraft;

import com.minmusxminmus.lovecraft.content.block.BlockSludgyBedrock;
import com.minmusxminmus.lovecraft.content.item.ItemOldBook;
import com.minmusxminmus.lovecraft.content.item.ItemSludgyBedrock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = LoveCraft.MODID, name = LoveCraft.NAME, version = LoveCraft.VERSION)
@Mod.EventBusSubscriber
public class LoveCraft
{
    public static final String MODID = "lovecraft";
    public static final String NAME = "LoveCraft";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) { }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                (new BlockSludgyBedrock()).setRegistryName(new ResourceLocation(MODID, "sludgy_bedrock"))
        );
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                (new ItemSludgyBedrock()).setRegistryName(new ResourceLocation(MODID, "sludgy_bedrock")),
                (new ItemOldBook()).setRegistryName(new ResourceLocation(MODID, "old_book"))
        );
    }
}
