package org.teamHTBP.extraascension.common.events;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.teamHTBP.extraascension.common.capabilities.EOAPlayerCapability;
import org.teamHTBP.extraascension.common.capabilities.IEOAPlayerCapability;
import org.teamHTBP.extraascension.common.helper.EOACuriosHelper;
import org.teamHTBP.extraascension.common.items.EOAExItemLoader;
@EventBusSubscriber()
public class ThermallyInsulatedScaleEventHandler {
    private static Logger LOGGER = LogManager.getLogger();

    /**玩家佩戴*/
    @SubscribeEvent
    public static void onPlayerLavaHurt(LivingIncomingDamageEvent event){
        DamageSource source = event.getSource();
        try {
            // 当玩家穿戴沼泽项链时，中毒效果不生效
            if(event.getEntity() instanceof Player player
                    && (source.is(DamageTypes.LAVA) || source.is(DamageTypes.ON_FIRE))
                    && EOACuriosHelper.isPlayerEquipped(player, EOAExItemLoader.THERMALLY_INSULATED_SCALE.get())
            ){
                IEOAPlayerCapability capability = player.getCapability(EOACapabilityRegistryHandler.EOA_ENTITY);
                // 当玩家岩浆内还在保护区间，则保护
                if(capability != null && player.isInLava() && capability.getLavaTicks() <= EOAPlayerCapability.MAX_PREVENT_LAVA_TICKS){
                    event.setAmount(0);
                    event.setCanceled(true);
                    player.fireImmune();
                }
                if(capability != null && player.isOnFire() && capability.getLavaTicks() > 0 && capability.getLavaTicks() <= EOAPlayerCapability.MAX_PREVENT_LAVA_TICKS){
                    event.setAmount(0);
                    event.setCanceled(true);
                }

            }
        } catch (Exception ex){
            LOGGER.error(ex);
        }
    }
}
