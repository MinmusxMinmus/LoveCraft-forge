package com.minmusxminmus.lovecraft.content.madness;

import com.minmusxminmus.lovecraft.util.NumberUtils;
import com.minmusxminmus.lovecraft.util.events.MadnessEvents;

import java.util.Observable;

import static com.minmusxminmus.lovecraft.LoveCraft.Configuration.MadnessConfig.MAX_MADNESS;
import static com.minmusxminmus.lovecraft.LoveCraft.Configuration.MadnessConfig.MIN_MADNESS;

public class Madness extends Observable {

    private double level;

    public Madness(double level) {
        this.level = level;
    }

    public Madness() {
        this(MIN_MADNESS);
    }

    protected double getLevel() {
        return level;
    }

    /**
     * Increases the Madness level by a fixed value. Will not increase past the maximum value set in the config.
     * @param amount A value to add to the
     * @return {@code true} if the Madness level has changed.
     */
    public boolean increase(double amount) {
        // Check correct parameter
        if (amount < 0.0D) return false;

        // Check max value
        if (NumberUtils.doubleEqual(level, MAX_MADNESS)) return false;

        // Check bad value
        if (level + amount > MAX_MADNESS) return false;

        level = level + amount;
        if (level > MAX_MADNESS) level = MAX_MADNESS;
        if (level < MIN_MADNESS) level = MIN_MADNESS; // ??????

        setChanged();
        notifyObservers(MadnessEvents.MADNESS_INCREASE);
        return true;
    }

    /**
     * Increases the Madness level by a percentage.
     * @param percentage Value between 0 and 1.
     * @return {@code true} if the Madness level has changed.
     */
    public boolean increase(float percentage) {
        // Check correct parameter
        if (percentage < 0.0f || percentage > 1.0d) return false;

        // Check necessary
        if (NumberUtils.doubleEqual(percentage, 0.0f)) return false;

        // Check max value
        if (NumberUtils.doubleEqual(level, MAX_MADNESS)) return false;

        double range = MAX_MADNESS - MIN_MADNESS;
        double amount = range * percentage;
        level = level + amount;

        if (level > MAX_MADNESS) level = MAX_MADNESS;
        if (level < MIN_MADNESS) level = MIN_MADNESS; // ??????

        setChanged();
        notifyObservers(MadnessEvents.MADNESS_INCREASE);
        return true;
    }

    /**
     * Sets the Madness level to a certain percentage. Can decrease madness levels.
     * @param percentage Value between 0 and 1.
     * @return {@code true} if the Madness level changes.
     */
    public boolean setLevel(float percentage) {
        // Check correct parameter
        if (percentage < 0.0f || percentage > 1.0d) return false;

        // Check max value
        if (NumberUtils.doubleEqual(level, MAX_MADNESS)) return false;

        double range = MAX_MADNESS - MIN_MADNESS;
        double newLevel = range * percentage;
        // Check if necessary
        if (NumberUtils.doubleEqual(level, newLevel)) return false;

        // Previous percentage level
        double oldLevel = range / level;

        level = newLevel;

        if (level > MAX_MADNESS) level = MAX_MADNESS;
        if (level < MIN_MADNESS) level = MIN_MADNESS; // ??????

        setChanged();
        if (oldLevel > newLevel) notifyObservers(MadnessEvents.MADNESS_DECREASE);
        else notifyObservers(MadnessEvents.MADNESS_INCREASE);
        return true;
    }

    /**
     * Sets the Madness level to a certain value. Can decrease madness level.
     * @param amount The new madness value.
     * @return {@code true} if the Madness level changes.
     */
    public boolean setLevel(double amount) {
        // Check correct parameter
        if (amount < 0.0D) return false;

        // Check correct value
        if (amount > MAX_MADNESS || amount < MIN_MADNESS) return false;

        // Previous amount
        double oldAmount = level;

        level = amount;

        if (level > MAX_MADNESS) level = MAX_MADNESS;
        if (level < MIN_MADNESS) level = MIN_MADNESS; // ??????

        setChanged();
        if (oldAmount > amount) notifyObservers(MadnessEvents.MADNESS_DECREASE);
        else notifyObservers(MadnessEvents.MADNESS_INCREASE);
        return true;
    }

    /**
     * Sets the madness level to the maximum value, according to the configuration file.
     */
    public void setMax() {
        if (!NumberUtils.doubleEqual(level, MAX_MADNESS)) setChanged();
        level = MAX_MADNESS;
        notifyObservers(MadnessEvents.MADNESS_INCREASE);
    }

    /**
     * Sets the madness level to the minimum value, according to the configuration file. Can decrease madness levels.
     */
    public void setMin() {
        if (!NumberUtils.doubleEqual(level, MIN_MADNESS)) setChanged();
        level = MIN_MADNESS;
        notifyObservers(MadnessEvents.MADNESS_DECREASE);
    }
}