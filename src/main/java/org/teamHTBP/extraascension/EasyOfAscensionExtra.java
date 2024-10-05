package org.teamHTBP.extraascension;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.teamHTBP.extraascension.common.items.EOAExItemGroup;
import org.teamHTBP.extraascension.common.items.EOAExItemLoader;

@Mod(EasyOfAscensionExtra.MOD_ID)
public class EasyOfAscensionExtra
{
    public static final String MOD_ID = "eoa_ex";

    public EasyOfAscensionExtra(IEventBus modBus){
        EOAExItemLoader.ITEMS.register(modBus);
        EOAExItemGroup.CREATIVE_TAB.register(modBus);
    }
}
