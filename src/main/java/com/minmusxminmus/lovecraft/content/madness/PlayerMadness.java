package com.minmusxminmus.lovecraft.content.madness;

import com.minmusxminmus.lovecraft.content.madness.paths.MadnessPath;
import com.minmusxminmus.lovecraft.util.events.PlayerMadnessEvents;

import java.util.Collection;
import java.util.Collections;

public class PlayerMadness extends Madness {

    private MadnessPath currentPath = null;

    public PlayerMadness(double level) {
        super(level);
    }

    public PlayerMadness() {
        super();
    }

    public MadnessPath getPathCurrent() {
        return currentPath;
    }

    public Collection<MadnessPath> getPathAvailable() {
        if (currentPath != null) return Collections.emptySet();
        return MadnessPath.getAllPaths();
    }

    /**
     * Locks the player into a certain path. Will fail if the player is already locked in a path.
     * @param path The path
     * @return {@code true} if the path was succesfully locked, {@code false} if there is already a locked path.
     */
    public boolean lockPath(MadnessPath path) {
        if (currentPath != null) return false;
        currentPath = path;
        setChanged();
        notifyObservers(PlayerMadnessEvents.PATH_LOCKED);
        return true;
    }
}
