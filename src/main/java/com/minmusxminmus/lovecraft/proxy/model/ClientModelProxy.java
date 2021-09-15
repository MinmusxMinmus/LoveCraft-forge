package com.minmusxminmus.lovecraft.proxy.model;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientModelProxy implements IModelProxy {

    @Override
    public void register(Item item, int metadata) {
        ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
