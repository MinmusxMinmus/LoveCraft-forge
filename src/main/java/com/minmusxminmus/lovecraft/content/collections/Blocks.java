package com.minmusxminmus.lovecraft.content.collections;

import com.minmusxminmus.lovecraft.content.blocks.BlockItem;
import com.minmusxminmus.lovecraft.content.blocks.BlockSludgyBedrock;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum Blocks {
    INSTANCE;

    private static final List<Block> blocks = new ArrayList<>();

    static {
        blocks.add(new BlockSludgyBedrock());
    }

    public List<Block> getAll() {
        return Collections.unmodifiableList(blocks);
    }

    public List<BlockItem> getAllHasItem() {
        return Collections.unmodifiableList(
                blocks.stream()
                        .filter(b -> b instanceof BlockItem)
                        .map(b -> (BlockItem)b)
                        .collect(Collectors.toList())
        );
    }
}
