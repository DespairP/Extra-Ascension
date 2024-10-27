package org.teamHTBP.extraascension.common.events;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import org.teamHTBP.extraascension.common.capabilities.EOAPlayerCapability;
import org.teamHTBP.extraascension.common.capabilities.IEOAPlayerCapability;
import org.teamHTBP.extraascension.common.helper.EOACuriosHelper;
import org.teamHTBP.extraascension.common.items.EOAExItemLoader;

import java.util.List;

@EventBusSubscriber()
public class NethengeicCoreEventHandler {

    @SubscribeEvent
    public static void onPlayerHurtAfterEvent(LivingDamageEvent.Post event){
        if(event.getEntity() instanceof Player player
                && EOACuriosHelper.isPlayerEquipped(player, EOAExItemLoader.NETHENGEIC_CORE.get())
                && player.isHurt()
                && player.getCommandSenderWorld() instanceof ServerLevel){
            IEOAPlayerCapability capability = player.getCapability(EOACapabilityRegistryHandler.EOA_ENTITY);
            // 增加受伤次数
            if(capability != null){
                capability.addDamageCount(1);
            }
            // 如果到达最高次数，则开始范围攻击+恢复生命
            if(capability != null && capability.getDamageCount() >= EOAPlayerCapability.MAX_PREVENT_HURTS){
                List<Monster> entityList = player.getCommandSenderWorld().getNearbyEntities(Monster.class, TargetingConditions.DEFAULT, player, player.getBoundingBox().inflate(12.0, 6.0, 12.0));
                for(Monster monster : entityList) {
                    monster.hurt(player.damageSources().magic(), 27);
                }
                player.heal(player.getHealth() * 0.3f);
                capability.resetDamageCount();
                ((ServerLevel)player.getCommandSenderWorld()).sendParticles(ParticleTypes.FLAME, player.getX(), player.getY(), player.getZ(), 30, 12, 6, 12, 0.01f);
            }
        }
    }
}
