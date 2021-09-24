package com.minmusxminmus.lovecraft.content.capabilities;

import com.minmusxminmus.lovecraft.content.madness.IMadness;
import com.minmusxminmus.lovecraft.content.madness.Madness;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class MadnessProvider implements ICapabilityProvider, ICapabilitySerializable<NBTTagDouble> {

    private final Madness madness;

    public MadnessProvider(Madness madness) {
        this.madness = madness;
    }

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == IMadness.MADNESS_CAPABILITY;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == IMadness.MADNESS_CAPABILITY ? (T) madness : null;
    }

    @Override
    public NBTTagDouble serializeNBT() {
        return new NBTTagDouble(madness.getLevel());
    }

    @Override
    public void deserializeNBT(NBTTagDouble nbt) {
        madness.setLevel(nbt.getDouble());
    }
}
