package org.teamHTBP.extraascension.common.events;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.teamHTBP.extraascension.EasyOfAscensionExtra;
import org.teamHTBP.extraascension.common.items.EOAExItem;
import org.teamHTBP.extraascension.common.items.EOAExItemLoader;
import org.teamHTBP.extraascension.common.items.NecklaceSwamp;
import top.theillusivec4.curios.api.CuriosApi;

import java.util.function.Supplier;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class CuriosHandler {
    @SubscribeEvent
    public static void registerCurios(final FMLCommonSetupEvent event){
        CuriosApi.registerCurioPredicate(ResourceLocation.fromNamespaceAndPath(EasyOfAscensionExtra.MOD_ID, "eoa"), (slotResult) -> {
            return slotResult.stack().is( item -> item.value() instanceof EOAExItem);
        });
    }
}
