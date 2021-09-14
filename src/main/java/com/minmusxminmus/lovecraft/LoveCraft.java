package com.minmusxminmus.lovecraft;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = LoveCraft.MOD_ID, name = LoveCraft.NAME, version = LoveCraft.VERSION)
public class LoveCraft
{
    public static final String MOD_ID = "lovecraft";
    public static final String NAME = "LoveCraft";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @Mod.Instance(MOD_ID)
    public static LoveCraft INSTANCE;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) { }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) { }
}
