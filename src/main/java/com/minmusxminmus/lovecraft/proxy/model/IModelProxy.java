package com.minmusxminmus.lovecraft.proxy.model;

import net.minecraft.item.Item;

public interface IModelProxy {
    void register(Item item, int metadata);
}
