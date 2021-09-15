package com.minmusxminmus.lovecraft.content.collections;

import com.minmusxminmus.lovecraft.content.items.ItemModel;
import com.minmusxminmus.lovecraft.content.items.ItemOldBook;
import com.minmusxminmus.lovecraft.content.items.ItemSludgyBedrock;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum Items {
    INSTANCE;

    private static final List<Item> items = new ArrayList<>();

    static {
        items.add(new ItemOldBook());
        items.add(new ItemSludgyBedrock());
    }

    public List<Item> getAll() {
        return Collections.unmodifiableList(items);
    }

    public List<Item> getAllHasModel() {
        return Collections.unmodifiableList(
                items.stream()
                        .filter(i -> i instanceof ItemModel)
                        .collect(Collectors.toList()));
    }
}
