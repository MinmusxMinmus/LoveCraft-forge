package com.minmusxminmus.lovecraft.content.madness;

import com.minmusxminmus.lovecraft.util.NumberUtils;
import com.minmusxminmus.lovecraft.util.events.MadnessEvents;

import java.util.Observable;

import static com.minmusxminmus.lovecraft.LoveCraft.Configuration.madnessConfig;

public class Madness extends Observable implements IMadness {

    private double level;

    public Madness(double level) {
        this.level = level;
    }

    public Madness() {
        this(madnessConfig.MIN_MADNESS);
    }

    @Override
    public double getLevel() {
        return level;
    }

    @Override
    public boolean increase(double amount) {
        // Check correct parameter
        if (amount < 0.0D) return false;

        // Check bad value
        if (level + amount > madnessConfig.MAX_MADNESS) return false;

        level = level + amount;
        if (level > madnessConfig.MAX_MADNESS) level = madnessConfig.MAX_MADNESS;
        if (level < madnessConfig.MIN_MADNESS) level = madnessConfig.MIN_MADNESS; // ??????

        setChanged();
        notifyObservers(MadnessEvents.MADNESS_INCREASE);
        return true;
    }

    @Override
    public boolean increase(float percentage) {
        // Check correct parameter
        if (percentage < 0.0f || percentage > 1.0d) return false;

        // Check necessary
        if (NumberUtils.doubleEqual(percentage, 0.0f)) return false;

        // Check max value
        if (NumberUtils.doubleEqual(level, madnessConfig.MAX_MADNESS)) return false;

        double range = madnessConfig.MAX_MADNESS - madnessConfig.MIN_MADNESS;
        double amount = range * percentage;
        level = level + amount;

        if (level > madnessConfig.MAX_MADNESS) level = madnessConfig.MAX_MADNESS;
        if (level < madnessConfig.MIN_MADNESS) level = madnessConfig.MIN_MADNESS; // ??????

        setChanged();
        notifyObservers(MadnessEvents.MADNESS_INCREASE);
        return true;
    }

    @Override
    public boolean setLevel(float percentage) {
        // Check correct parameter
        if (percentage < 0.0f || percentage > 1.0d) return false;

        // Check max value
        if (NumberUtils.doubleEqual(level, madnessConfig.MAX_MADNESS)) return false;

        double range = madnessConfig.MAX_MADNESS - madnessConfig.MIN_MADNESS;
        double newLevel = range * percentage;
        // Check if necessary
        if (NumberUtils.doubleEqual(level, newLevel)) return false;

        // Previous percentage level
        double oldLevel = range / level;

        level = newLevel;

        if (level > madnessConfig.MAX_MADNESS) level = madnessConfig.MAX_MADNESS;
        if (level < madnessConfig.MIN_MADNESS) level = madnessConfig.MIN_MADNESS; // ??????

        setChanged();
        if (oldLevel > newLevel) notifyObservers(MadnessEvents.MADNESS_DECREASE);
        else notifyObservers(MadnessEvents.MADNESS_INCREASE);
        return true;
    }

    @Override
    public boolean setLevel(double amount) {
        // Check correct parameter
        if (amount < 0.0D) return false;

        // Check correct value
        if (amount > madnessConfig.MAX_MADNESS || amount < madnessConfig.MIN_MADNESS) return false;

        // Previous amount
        double oldAmount = level;

        level = amount;

        if (level > madnessConfig.MAX_MADNESS) level = madnessConfig.MAX_MADNESS;
        if (level < madnessConfig.MIN_MADNESS) level = madnessConfig.MIN_MADNESS; // ??????

        setChanged();
        if (oldAmount > amount) notifyObservers(MadnessEvents.MADNESS_DECREASE);
        else notifyObservers(MadnessEvents.MADNESS_INCREASE);
        return true;
    }

    @Override
    public boolean setMax() {
        if (!NumberUtils.doubleEqual(level, madnessConfig.MAX_MADNESS)) setChanged();
        level = madnessConfig.MAX_MADNESS;
        notifyObservers(MadnessEvents.MADNESS_INCREASE);
        return hasChanged();
    }

    @Override
    public boolean setMin() {
        if (!NumberUtils.doubleEqual(level, madnessConfig.MIN_MADNESS)) setChanged();
        level = madnessConfig.MIN_MADNESS;
        notifyObservers(MadnessEvents.MADNESS_DECREASE);
        return hasChanged();
    }

    @Override
    public boolean refresh() {
        return false;
    }


}