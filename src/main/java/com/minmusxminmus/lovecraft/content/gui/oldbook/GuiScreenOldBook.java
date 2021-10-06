package com.minmusxminmus.lovecraft.content.gui.oldbook;

import com.minmusxminmus.lovecraft.LoveCraft;
import com.minmusxminmus.lovecraft.util.StringFormatter;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class GuiScreenOldBook extends GuiScreen {

    private static class Constants {
        public static final int IMG_W = 255;
        public static final int IMG_H = 255;

        public static final int BOOK_X = 0;
        public static final int BOOK_Y = 48;
        public static final int BOOK_W = IMG_W;
        public static final int BOOK_H = IMG_H - BOOK_Y - BOOK_Y;

        public static final int LTEXT_X = BOOK_X + 21;
        public static final int LTEXT_Y = BOOK_Y + 16;
        public static final int RTEXT_X = BOOK_X + 137;
        public static final int RTEXT_Y = LTEXT_Y;
        public static final int TEXT_W = 100;
        public static final int TEXT_H = 130;
    }

    private static final ResourceLocation texture = StringFormatter.asResourceLocation("textures/gui/old_book_gui.png");



    private final EntityPlayer playerReading;
    private final ItemStack oldBook;

    private GuiButton buttonTranslate;
    private GuiButton buttonClose;

    public GuiScreenOldBook(EntityPlayer player, @Nullable ItemStack oldBook) {
        this.playerReading = player;
        this.oldBook = oldBook;
    }

    @Override
    public void initGui() {
        super.initGui();

        buttonInit();
    }

    @Override
    protected void actionPerformed(@Nonnull GuiButton button) {
        if (button == buttonClose) {
            mc.player.closeScreen();
            return;
        }
        if (button == buttonTranslate) {
            mc.player.sendChatMessage("Pretend the book was translated");
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {

        // Useful variables
        int BOOK_XREL = (width - Constants.BOOK_W) / 2;
        int BOOK_YREL = (height - Constants.BOOK_H) / 2;

        this.drawDefaultBackground();
        mc.getTextureManager().bindTexture(texture);
        drawTexturedModalRect(BOOK_XREL, BOOK_YREL,
                (Constants.IMG_W - Constants.BOOK_W) / 2,
                (Constants.IMG_H - Constants.BOOK_H) / 2,
                Constants.BOOK_W,
                Constants.BOOK_H);
wrel
        int x = BOOK_XREL + Constants.LTEXT_X;
        int y = BOOK_YREL + Constants.LTEXT_Y;

        LoveCraft.LOGGER.info("width = " + width);
        LoveCraft.LOGGER.info("height = " + height);
        LoveCraft.LOGGER.info("xrel = " + BOOK_XREL);
        LoveCraft.LOGGER.info("yrel = " + BOOK_YREL);
        LoveCraft.LOGGER.info("Writing string at (" + x + ", " + y + ")");

        fontRenderer.drawString(
                "Pues se ha quedado un buen dia",
                x,
                y,
                0X0);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    private void buttonInit() {
        int xLeftGui = (width - Constants.BOOK_W) / 2;
        int yBottomGui = (height + Constants.BOOK_H) / 2;

        int buttonX = (Constants.BOOK_W / 2) - 5;
        int buttonY = 20;

        int closeX = xLeftGui;
        int closeY = yBottomGui + 10;

        int translateX = xLeftGui + buttonX + 10;
        int translateY = yBottomGui + 10;

        buttonTranslate = new GuiButton(0, translateX, translateY, buttonX, buttonY, "Translate");
        buttonClose = new GuiButton(0, closeX, closeY, buttonX, buttonY, "Close");

        this.buttonList.add(buttonClose);
        this.buttonList.add(buttonTranslate);
    }
}
