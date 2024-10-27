package org.teamHTBP.extraascension.common.events;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.EntityCapability;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.items.IItemHandler;
import org.jetbrains.annotations.Nullable;
import org.teamHTBP.extraascension.EasyOfAscensionExtra;
import org.teamHTBP.extraascension.common.capabilities.EOAPlayerCapabilityProvider;
import org.teamHTBP.extraascension.common.capabilities.IEOAPlayerCapability;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class EOACapabilityRegistryHandler {
    public static final EntityCapability<IEOAPlayerCapability, @Nullable Void> EOA_ENTITY = EntityCapability.createVoid(ResourceLocation.fromNamespaceAndPath(EasyOfAscensionExtra.MOD_ID, "eoa_capability"), IEOAPlayerCapability.class);

    @SubscribeEvent
    private static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerEntity(EOA_ENTITY, EntityType.PLAYER, new EOAPlayerCapabilityProvider());
    }
}
