package com.minmusxminmus.lovecraft.content.collections;

import com.minmusxminmus.lovecraft.content.blocks.BlockSludgyBedrock;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum Blocks {
    INSTANCE;

    private static final List<Block> blocks = new ArrayList<>();

    static {
        blocks.add(new BlockSludgyBedrock());
    }

    public List<Block> getAll() {
        return Collections.unmodifiableList(blocks);
    }
}
