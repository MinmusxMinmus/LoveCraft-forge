package com.minmusxminmus.lovecraft.content.gui;

import com.minmusxminmus.lovecraft.LoveCraft;
import com.minmusxminmus.lovecraft.content.gui.oldbook.GuiScreenOldBook;
import com.minmusxminmus.lovecraft.content.items.ItemOldBook;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

public class LoveCraftGuiHandler implements IGuiHandler {
    public static class GUIs {
        public static final int OLD_BOOK_GUI = 1;
    }

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case GUIs.OLD_BOOK_GUI: // Nothing required from server-side
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case GUIs.OLD_BOOK_GUI:
                return getOldBookGUI(player);
            default:
                return null;
        }
    }

    private GuiScreenOldBook getOldBookGUI(EntityPlayer player) {
        ItemStack book_main = player.getHeldItem(EnumHand.MAIN_HAND);
        ItemStack book_off = player.getHeldItem(EnumHand.OFF_HAND);

        if (book_off.getItem() instanceof ItemOldBook) {
            LoveCraft.LOGGER.info("Found Old Book in offhand, prioritizing over main hand");
            return new GuiScreenOldBook(player, book_off);
        }

        if (book_main.getItem() instanceof ItemOldBook) {
            LoveCraft.LOGGER.info("No Old Book found in offhand, using main hand Old Book");
            return new GuiScreenOldBook(player, book_main);
        }

        LoveCraft.LOGGER.warn("Opening Old Book GUI without a book in any hand! Empty GUI");
        return new GuiScreenOldBook(player, null);
    }
}
