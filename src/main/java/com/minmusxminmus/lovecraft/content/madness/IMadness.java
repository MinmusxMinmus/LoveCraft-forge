package com.minmusxminmus.lovecraft.content.madness;

import com.minmusxminmus.lovecraft.content.capabilities.MadnessStorage;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

public interface IMadness {
    static void register() {
        CapabilityManager.INSTANCE.register(IMadness.class, new MadnessStorage(), Madness::new);
    }

    @CapabilityInject(IMadness.class)
    Capability<IMadness> MADNESS_CAPABILITY = null;

    /**
     * Returns the madness level as a double between the config values for max madness and min madness.
     */
    double getLevel();
    /**
     * Increases the Madness level by a fixed value. Will not increase past the maximum value set in the config.
     * @param value A value to add to the
     * @return {@code true} if the Madness level has changed.
     */
    boolean increase(double value);
    /**
     * Increases the Madness level by a percentage.
     * @param percentage Value between 0 and 1.
     * @return {@code true} if the Madness level has changed.
     */
    boolean increase(float percentage);
    /**
     * Sets the Madness level to a certain value. Can decrease madness level.
     * @param value The new madness value.
     * @return {@code true} if the Madness level changes.
     */
    boolean setLevel(double value);
    /**
     * Sets the Madness level to a certain percentage. Can decrease madness levels.
     * @param percentage Value between 0 and 1.
     * @return {@code true} if the Madness level changes.
     */
    boolean setLevel(float percentage);
    /**
     * Sets the madness level to the maximum value, according to the configuration file.
     */
    boolean setMax();
    /**
     * Sets the madness level to the minimum value, according to the configuration file. Can decrease madness levels.
     */
    boolean setMin();
    /**
     * Updates the madness values according to configuration changes.
     * @return {@code true} if there has been a change.
     */
    boolean refresh();


}
