package com.minmusxminmus.lovecraft.content.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

public class ItemOldBook extends LoveCraftItem implements ItemModel {

    @ObjectHolder("lovecraft:old_book")
    public static final Item INSTANCE = null;

    public ItemOldBook() {
        super("old_book", CreativeTabs.TRANSPORTATION);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        player.sendStatusMessage(new TextComponentString("You understood nothing..."), true);
        return EnumActionResult.SUCCESS;
    }
}
