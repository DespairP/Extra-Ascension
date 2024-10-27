package org.teamHTBP.extraascension.common.items;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import org.teamHTBP.extraascension.common.capabilities.IEOAPlayerCapability;
import org.teamHTBP.extraascension.common.events.EOACapabilityRegistryHandler;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class ThermallyInsulatedScale extends EOAExItem implements ICurioItem {
    public ThermallyInsulatedScale(Properties properties) {
        super(properties);
    }


    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        if(slotContext.entity() instanceof ServerPlayer serverPlayer){
            IEOAPlayerCapability capability = serverPlayer.getCapability(EOACapabilityRegistryHandler.EOA_ENTITY);
            // 在岩浆里,则增加计时
            if(serverPlayer.isInLava() && capability != null){
                capability.increaseLavaTick(1);
            }
            // 不在岩浆里，则减少计时
            if(!serverPlayer.isInLava() && capability != null){
                capability.resetLavaTicks();
            }
        }
    }
}
