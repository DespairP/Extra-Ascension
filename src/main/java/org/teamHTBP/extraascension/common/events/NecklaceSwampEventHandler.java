package org.teamHTBP.extraascension.common.events;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.tslat.aoa3.common.registration.AoATags;
import net.tslat.aoa3.common.registration.entity.AoADamageTypes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.teamHTBP.extraascension.common.helper.EOACuriosHelper;
import org.teamHTBP.extraascension.common.items.EOAExItemLoader;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;

import java.util.Objects;

/***/
@EventBusSubscriber()
public class NecklaceSwampEventHandler {
    private static Logger LOGGER = LogManager.getLogger();

    /**玩家中毒时，免疫中毒效果*/
    @SubscribeEvent
    public static void onPlayerEffectHurt(LivingIncomingDamageEvent event){
        DamageSource source = event.getSource();
        try {
            // 当玩家穿戴沼泽项链时，中毒效果不生效
            if(event.getEntity() instanceof Player player
                    && source.is(Tags.DamageTypes.IS_POISON)
                    && EOACuriosHelper.isPlayerEquipped(player, EOAExItemLoader.NECKLACE_OF_SWAMP.get())
            ){
                    event.setAmount(0);
                    event.setCanceled(true);
            }
        } catch (Exception ex){
            LOGGER.error(ex);
        }
    }

    /**弹射物远程伤害增益*/
    @SubscribeEvent
    public static void onAttackEntity(LivingDamageEvent.Pre event){
        DamageSource source = event.getSource();
        if(!source.isDirect()
                && source.getEntity() instanceof Player attackPlayer
                && EOACuriosHelper.isPlayerEquipped(attackPlayer, EOAExItemLoader.NECKLACE_OF_SWAMP.get())
                && attackPlayer.hasEffect(MobEffects.POISON)
                && (source.is(AoATags.DamageTypes.GUN) || source.is(DamageTypes.ARROW) || source.is(AoADamageTypes.RANGED_ATTACK))
        ){
            int level = Objects.requireNonNull(attackPlayer.getEffect(MobEffects.POISON)).getAmplifier();
            float damage = event.getOriginalDamage();
            event.setNewDamage(damage + (level * 0.5f) * damage);
        }
    }
}
