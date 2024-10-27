package org.teamHTBP.extraascension.common.events;

import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;
import org.teamHTBP.extraascension.common.helper.EOACuriosHelper;
import org.teamHTBP.extraascension.common.items.EOAExItemLoader;

@EventBusSubscriber()
public class BamHornEventHandler {
    /**清除Piglin仇恨*/
    @SubscribeEvent
    public static void hurtEntityEvent(LivingChangeTargetEvent event){
        if(event.getEntity() instanceof Piglin piglin
                && event.getOriginalAboutToBeSetTarget() == null
                && event.getNewAboutToBeSetTarget() instanceof Player attackPlayer
                && EOACuriosHelper.isPlayerEquipped(attackPlayer, EOAExItemLoader.BAM_HORN.get())
        ){
            event.setCanceled(true);
        }
    }
}
