package org.teamHTBP.extraascension.common.events;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LightLayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.tslat.aoa3.common.registration.AoATags;
import net.tslat.aoa3.common.registration.entity.AoADamageTypes;
import org.teamHTBP.extraascension.common.helper.EOACuriosHelper;
import org.teamHTBP.extraascension.common.items.EOAExItemLoader;

import java.util.Objects;

@EventBusSubscriber()
public class VoidAmethystEventHandler {

    @SubscribeEvent
    public static void onPlayerHurt(LivingDamageEvent.Pre event){
        DamageSource source = event.getSource();
        if(event.getEntity() instanceof Player player
                && EOACuriosHelper.isPlayerEquipped(player, EOAExItemLoader.VOID_AMETHYST.get())
        ){
            int lightIn = player.getCommandSenderWorld().getBrightness(LightLayer.BLOCK, player.blockPosition());
            boolean playerHasEffect = player.hasEffect(MobEffects.NIGHT_VISION);
            // 根据光照减免
            event.setNewDamage(event.getOriginalDamage() - event.getOriginalDamage() * (0.3F *  (15 - lightIn) / 15F));

            // 如果有夜视，减免40%
            if(playerHasEffect){
                event.setNewDamage(event.getOriginalDamage() - event.getOriginalDamage() * 0.4f );
            }

        }
    }

}
