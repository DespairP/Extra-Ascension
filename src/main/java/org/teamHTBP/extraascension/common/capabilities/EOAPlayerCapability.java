package org.teamHTBP.extraascension.common.capabilities;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.UnknownNullability;

public class EOAPlayerCapability implements IEOAPlayerCapability {
    public static final Codec<EOAPlayerCapability> CODEC = RecordCodecBuilder.create(inst ->
            inst.group(
                    Codec.LONG.fieldOf("lavaTicks").forGetter(EOAPlayerCapability::getLavaTicks),
                    Codec.INT.fieldOf("damageCount").forGetter(EOAPlayerCapability::getDamageCount)).apply(inst, EOAPlayerCapability::new)
    );

    private static final Logger LOGGER = LogManager.getLogger();


    private long lavaTicks = 0;
    private int damageCount = 0;

    public static final int MAX_PREVENT_LAVA_TICKS = 200;
    public static final int MAX_PREVENT_HURTS = 15;

    public EOAPlayerCapability(long lavaTicks, int damageCount) {
        this.lavaTicks = lavaTicks;
        this.damageCount = damageCount;
    }

    @Override
    public void increaseLavaTick(int ticks) {
        this.lavaTicks += ticks;
    }

    @Override
    public long getLavaTicks() {
        return lavaTicks;
    }

    @Override
    public void resetLavaTicks() {
        this.lavaTicks = 0;
    }

    @Override
    public void addDamageCount(int amount) {
        this.damageCount += amount;
    }

    @Override
    public int getDamageCount() {
        return damageCount;
    }

    @Override
    public void resetDamageCount() {
        damageCount = 0;
    }

    @Override
    public @UnknownNullability CompoundTag serializeNBT(HolderLookup.Provider provider) {
        CompoundTag tag = new CompoundTag();
        try {
            tag = (CompoundTag) CODEC.encode(this, NbtOps.INSTANCE, tag).result().get();
        } catch (Exception ex){
            LOGGER.error(ex);
        }
        return tag;
    }

    @Override
    public void deserializeNBT(HolderLookup.Provider provider, CompoundTag tag) {
        try {
            EOAPlayerCapability cap = CODEC.parse(NbtOps.INSTANCE, tag).result().orElseThrow();
            this.damageCount = cap.damageCount;
            this.lavaTicks = cap.lavaTicks;;
        } catch (Exception ex){
            LOGGER.error(ex);
        }
    }
}
