package com.minmusxminmus.lovecraft.content.capabilities;

import com.minmusxminmus.lovecraft.content.madness.IMadness;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class MadnessStorage implements Capability.IStorage<IMadness> {

    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IMadness> capability, IMadness instance, EnumFacing side) {
        return new NBTTagDouble(instance.getLevel());
    }

    @Override
    public void readNBT(Capability<IMadness> capability, IMadness instance, EnumFacing side, NBTBase nbt) {
        if (!(nbt instanceof NBTTagDouble))
            throw new RuntimeException("Invalid NBT tag type: expected '" + NBTTagDouble.class.getName() + "', got '" + nbt.getClass().getName() + "'");
        NBTTagDouble doub = (NBTTagDouble) nbt;
        instance.setLevel(doub.getDouble());
        instance.refresh();
    }
}
