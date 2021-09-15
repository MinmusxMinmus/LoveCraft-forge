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

import static com.minmusxminmus.lovecraft.util.StringFormatter.registryName;
import static com.minmusxminmus.lovecraft.util.StringFormatter.unlocalize;

public class ItemOldBook extends Item implements ItemModel {

    private static final String name = "old_book";

    @ObjectHolder("lovecraft:old_book")
    public static final Item INSTANCE = null;

    public ItemOldBook() {
        super();
        setCreativeTab(CreativeTabs.TRANSPORTATION);
        setUnlocalizedName(unlocalize(name));
        setRegistryName(registryName(name));
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        player.sendStatusMessage(new TextComponentString("You understood nothing..."), true);
        return EnumActionResult.SUCCESS;
    }
}
