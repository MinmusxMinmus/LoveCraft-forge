package com.minmusxminmus.lovecraft.content.items;

import com.minmusxminmus.lovecraft.content.blocks.BlockSludgyBedrock;
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

public class ItemOldBook extends LoveCraftItem {

    public static final String NAME = "old_book";

    @ObjectHolder("lovecraft:old_book")
    public static final Item INSTANCE = null;

    public ItemOldBook() {
        super(NAME, CreativeTabs.TRANSPORTATION);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        player.sendStatusMessage(new TextComponentString("You understood nothing..."), true);
        player.sendMessage(new TextComponentString("Sludgy bedrock block: " + BlockSludgyBedrock.INSTANCE_BLOCK));
        player.sendMessage(new TextComponentString("Sludgy bedrock item: " + BlockSludgyBedrock.INSTANCE_ITEM));
        player.sendMessage(new TextComponentString("Old book item: " + ItemOldBook.INSTANCE));
        return EnumActionResult.SUCCESS;
    }
}
