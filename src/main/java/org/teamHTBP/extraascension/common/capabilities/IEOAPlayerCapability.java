package org.teamHTBP.extraascension.common.capabilities;

import net.minecraft.nbt.CompoundTag;
import net.neoforged.neoforge.common.util.INBTSerializable;

public interface IEOAPlayerCapability extends INBTSerializable<CompoundTag> {
    public void increaseLavaTick(int ticks);

    public long getLavaTicks();

    public void resetLavaTicks();

    public void addDamageCount(int amount);

    public int getDamageCount();

    public void resetDamageCount();
}
