package org.teamHTBP.extraascension.common.items;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.teamHTBP.extraascension.common.capabilities.IEOAPlayerCapability;
import org.teamHTBP.extraascension.common.events.EOACapabilityRegistryHandler;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class NethengeicCore extends EOAExItem implements ICurioItem {
    public NethengeicCore(Properties properties) {
        super(properties);
    }
}
