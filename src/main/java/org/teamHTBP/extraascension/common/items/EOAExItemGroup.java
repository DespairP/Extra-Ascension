package org.teamHTBP.extraascension.common.items;

import net.minecraft.client.gui.components.tabs.Tab;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.teamHTBP.extraascension.EasyOfAscensionExtra;

import java.util.function.Supplier;

@EventBusSubscriber(modid = "eoa_ex", bus = EventBusSubscriber.Bus.MOD)
public class EOAExItemGroup {
    public final static DeferredRegister<CreativeModeTab> CREATIVE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EasyOfAscensionExtra.MOD_ID);

    /**EOA标签*/
    public static Supplier<CreativeModeTab> TAB = CREATIVE_TAB.register("vida_reforged", () ->CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .title(Component.translatable("itemGroup.eoa_ex"))
            .icon(() -> new ItemStack(EOAExItemLoader.ANCIENT_STAVE.get()))
            .build()
    );

    /**LOGGER*/
    public static final Logger LOGGER = LogManager.getLogger();

    @SubscribeEvent
    public static void buildContents(final BuildCreativeModeTabContentsEvent event) {
        if(event.getTab() != TAB.get()){
            return;
        }
        event.accept(EOAExItemLoader.ANCIENT_STAVE.get());
        event.accept(EOAExItemLoader.BAM_HORN.get());
        event.accept(EOAExItemLoader.CHARGER_BOXING_GLOVE.get());
        event.accept(EOAExItemLoader.STEEL_HAMMER.get());
        event.accept(EOAExItemLoader.NETHENGEIC_CORE.get());
        event.accept(EOAExItemLoader.NECKLACE_OF_SWAMP.get());
        event.accept(EOAExItemLoader.STICKY_SAND_BALL.get());
        event.accept(EOAExItemLoader.THERMALLY_INSULATED_SCALE.get());
        event.accept(EOAExItemLoader.VOID_AMETHYST.get());
    }
}
