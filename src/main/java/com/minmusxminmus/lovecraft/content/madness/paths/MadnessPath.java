package com.minmusxminmus.lovecraft.content.madness.paths;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public abstract class MadnessPath {
    public abstract String getIdentifier();

    /**
     * Convenience method to retrieve LoveCraft's default paths.
     */
    public Collection<MadnessPath> getDefaultPaths() {
        Collection<MadnessPath> paths = new HashSet<>();
        Collections.addAll(paths, new MadnessPathDeep(), new MadnessPathDream(), new MadnessPathLore(), new MadnessPathScience());
        return paths;
    }
}
