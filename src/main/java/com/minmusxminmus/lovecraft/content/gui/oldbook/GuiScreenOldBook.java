package com.minmusxminmus.lovecraft.content.gui.oldbook;

import com.minmusxminmus.lovecraft.util.StringFormatter;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class GuiScreenOldBook extends GuiScreen {

    private static class Absolutes {
        public static final int IMG_W = 255;
        public static final int IMG_H = 255;

        public static final int BOOK_W = 255;
        public static final int BOOK_H = 255 - 48 - 48; // Space above and below

        public static final int LTEXT_W = 100;
        public static final int LTEXT_H = 130;

        public static final int RTEXT_W = 100;
        public static final int RTEXT_H = 130;

    }

    private static class Relatives {
        // These represent the top left of the whole PNG
        public static int IMG_X = 0;
        public static int IMG_Y = 0;

        // These represent the top left of the visible book
        public static int BOOK_X = 0;
        public static int BOOK_Y = 0;

        // All of these are measured relative to the visible book PNG
        // They were obtained by measuring pixels on the PNG, don't look for any hidden meaning
        public static final int LTEXT_X = 21;
        public static final int LTEXT_Y = 16;

        public static final int RTEXT_X = 137;
        public static final int RTEXT_Y = 16;
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
        // Set variables
        Relatives.BOOK_X = (width - Absolutes.BOOK_W) / 2;
        Relatives.BOOK_Y = (height - Absolutes.BOOK_H) / 2;
        Relatives.IMG_X = (width - Absolutes.IMG_W) / 2;
        Relatives.IMG_Y = (width - Absolutes.IMG_H) / 2;

        this.drawDefaultBackground();

        mc.getTextureManager().bindTexture(texture);
        drawTexturedModalRect(Relatives.BOOK_X, Relatives.BOOK_Y,
                (Absolutes.IMG_W - Absolutes.BOOK_W) / 2,
                (Absolutes.IMG_H - Absolutes.BOOK_H) / 2,
                Absolutes.BOOK_W,
                Absolutes.BOOK_H);

        int text_x = Relatives.BOOK_X + Relatives.LTEXT_X;
        int text_y = Relatives.BOOK_Y + Relatives.LTEXT_Y;
        fontRenderer.drawString("Pues se ha quedado", text_x, text_y, 0X0);

        text_x = Relatives.BOOK_X + Relatives.RTEXT_X;
        text_y = Relatives.BOOK_Y + Relatives.RTEXT_Y;
        fontRenderer.drawString("un buen dia", text_x, text_y, 0X0);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    private void buttonInit() {
        int xLeftGui = (width - Absolutes.BOOK_W) / 2;
        int yBottomGui = (height + Absolutes.BOOK_H) / 2;

        int buttonX = (Absolutes.BOOK_W / 2) - 5;
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
