package org.teamHTBP.extraascension.common.events;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.teamHTBP.extraascension.EasyOfAscensionExtra;
import org.teamHTBP.extraascension.common.items.EOAExItemLoader;
import org.teamHTBP.extraascension.common.items.NecklaceSwamp;
import top.theillusivec4.curios.api.CuriosApi;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class CuriosHandler {

    @SubscribeEvent
    public static void registerCurios(final FMLCommonSetupEvent event){
        CuriosApi.registerCurioPredicate(ResourceLocation.fromNamespaceAndPath(EasyOfAscensionExtra.MOD_ID, "eoa"), (slotResult) -> {
            // contents of the predicate here - return true or false
            return slotResult.stack().is(EOAExItemLoader.NECKLACE_OF_SWAMP.get());
        });
    }
}
