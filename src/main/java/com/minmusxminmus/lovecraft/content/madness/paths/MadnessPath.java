package com.minmusxminmus.lovecraft.content.madness.paths;

import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public abstract class MadnessPath extends IForgeRegistryEntry.Impl<MadnessPath> {
    public static IForgeRegistry<MadnessPath> MADNESS_REGISTRY = null;
    public abstract String getIdentifier();

    /**
     * Convenience method to retrieve LoveCraft's default paths.
     */
    public static Collection<MadnessPath> getDefaultPaths() {
        Collection<MadnessPath> paths = new HashSet<>();
        Collections.addAll(paths, new MadnessPathDeep(), new MadnessPathDream(), new MadnessPathLore(), new MadnessPathScience());
        return paths;
    }

    public static Collection<MadnessPath> getAllPaths() {
        if (MADNESS_REGISTRY == null) return null;
        return MADNESS_REGISTRY.getValuesCollection();
    }


}
