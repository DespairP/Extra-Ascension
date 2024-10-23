package org.teamHTBP.extraascension.common.items;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.teamHTBP.extraascension.EasyOfAscensionExtra;

import java.util.function.Supplier;

public class EOAExItemLoader {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(EasyOfAscensionExtra.MOD_ID);

    public static final Supplier<Item> ANCIENT_STAVE = ITEMS.register("ancient_stave",  () -> new Item(new Item.Properties()));
    public static final Supplier<Item> BAM_HORN = ITEMS.register("bam_horn",  () -> new BamHorn(new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> CHARGER_BOXING_GLOVE = ITEMS.register("charger_boxing_glove",  () -> new ChargerBoxingGlove(new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> NECKLACE_OF_SWAMP = ITEMS.register("necklace_of_swamp",  () -> new NecklaceSwamp(new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> NETHENGEIC_CORE = ITEMS.register("nethengeic_core",  () -> new Item(new Item.Properties()));
    public static final Supplier<Item> STEEL_HAMMER = ITEMS.register("steel_hammer",  () -> new Item(new Item.Properties()));
    public static final Supplier<Item> STICKY_SAND_BALL = ITEMS.register("sticky_sand_ball",  () -> new Item(new Item.Properties()));
    public static final Supplier<Item> THERMALLY_INSULATED_SCALE = ITEMS.register("thermally_insulated_scale",  () -> new Item(new Item.Properties()));
    public static final Supplier<Item> VOID_AMETHYST = ITEMS.register("void_amethyst",  () -> new Item(new Item.Properties()));



}
