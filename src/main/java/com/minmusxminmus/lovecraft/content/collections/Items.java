package com.minmusxminmus.lovecraft.content.collections;

import com.minmusxminmus.lovecraft.content.items.ItemOldBook;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum Items {
    INSTANCE;

    private static final List<Item> items = new ArrayList<>();

    static {
        items.add(new ItemOldBook());
    }

    public List<Item> getAll() {
        return Collections.unmodifiableList(items);
    }
}
