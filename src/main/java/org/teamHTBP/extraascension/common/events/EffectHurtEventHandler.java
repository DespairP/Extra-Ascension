package org.teamHTBP.extraascension.common.events;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.damagesource.DamageContainer;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.teamHTBP.extraascension.common.items.EOAExItemLoader;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;

/***/
@EventBusSubscriber()
public class EffectHurtEventHandler {
    private static Logger LOGGER = LogManager.getLogger();


    @SubscribeEvent
    public static void onEffectHurt(LivingIncomingDamageEvent event){
        DamageSource source = event.getSource();
        try {
            // 当玩家穿戴沼泽项链时，中毒效果不生效
            if(event.getEntity() instanceof Player player && source.is(Tags.DamageTypes.IS_POISON) && CuriosApi.getCuriosInventory(player).isPresent()){
                ICuriosItemHandler handler = CuriosApi.getCuriosInventory(player).get();
                if(handler.isEquipped(EOAExItemLoader.NECKLACE_OF_SWAMP.get())){
                    event.setAmount(0);
                    event.setCanceled(true);
                }
            }
        } catch (Exception ex){
            LOGGER.error(ex);
        }
    }
}
