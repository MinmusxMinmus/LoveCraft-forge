package com.minmusxminmus.lovecraft.content.item;

import com.minmusxminmus.lovecraft.LoveCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = LoveCraft.MOD_ID)
public class ItemOldBook extends Item {

    public ItemOldBook() {
        super();
        setCreativeTab(CreativeTabs.TRANSPORTATION);
        setUnlocalizedName(LoveCraft.MODID + ".old_book");
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        MinecraftServer server = player.getServer();
        if (server != null) server.sendMessage(new TextComponentString("You understood nothing..."));
        return EnumActionResult.SUCCESS;
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemOldBook().setRegistryName(LoveCraft.MOD_ID, "old_book"));
    }
}
