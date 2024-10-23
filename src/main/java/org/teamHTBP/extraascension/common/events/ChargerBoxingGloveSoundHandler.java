package org.teamHTBP.extraascension.common.events;

import net.minecraft.client.Minecraft;
import net.minecraft.sounds.*;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.sound.SoundEvent;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import net.tslat.aoa3.common.registration.AoASounds;
import org.teamHTBP.extraascension.common.helper.EOACuriosHelper;
import org.teamHTBP.extraascension.common.items.EOAExItemLoader;

@EventBusSubscriber()
public class ChargerBoxingGloveSoundHandler {
    /**播放袭击者声音*/
    @SubscribeEvent
    public static void onAttack(AttackEntityEvent event) {
        Player player = event.getEntity();
        if (EOACuriosHelper.isPlayerEquipped(player, EOAExItemLoader.CHARGER_BOXING_GLOVE.get())) {
            player.getCommandSenderWorld().playSound(event.getEntity(), player.getX(), player.getY(), player.getZ(), AoASounds.ENTITY_CHARGER_HURT.get(), player.getSoundSource(), 1, 1);
            player.getCommandSenderWorld().playSound(event.getEntity(), player.getX(), player.getY(), player.getZ(), AoASounds.ENTITY_CHARGER_HURT.get(), player.getSoundSource(), 1, 1);
            player.getCommandSenderWorld().playSound(event.getEntity(), player.getX(), player.getY(), player.getZ(), AoASounds.ENTITY_CHARGER_HURT.get(), player.getSoundSource(), 1, 1);
        }
    }
}