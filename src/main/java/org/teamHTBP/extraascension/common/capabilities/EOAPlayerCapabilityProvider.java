package org.teamHTBP.extraascension.common.capabilities;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.capabilities.ICapabilityProvider;
import net.neoforged.neoforge.common.util.INBTSerializable;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnknownNullability;

public class EOAPlayerCapabilityProvider implements ICapabilityProvider<Player, Void, IEOAPlayerCapability>, INBTSerializable<CompoundTag> {
    EOAPlayerCapability cap = null;

    public EOAPlayerCapabilityProvider(){}

    @Override
    public @Nullable IEOAPlayerCapability getCapability(Player player, Void unused) {
        if(cap == null){
            cap = new EOAPlayerCapability(0,0);
        }
        return cap;
    }

    @Override
    public @UnknownNullability CompoundTag serializeNBT(HolderLookup.Provider provider) {
        return cap.serializeNBT(provider);
    }

    @Override
    public void deserializeNBT(HolderLookup.Provider provider, CompoundTag tag) {
        this.cap.deserializeNBT(provider, tag);
    }
}
