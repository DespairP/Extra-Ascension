package org.teamHTBP.extraascension.common.helper;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import org.teamHTBP.extraascension.common.items.EOAExItemLoader;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;

import java.util.Optional;

public class EOACuriosHelper {
    public static boolean isPlayerEquipped(Player player, Item item){
        Optional<ICuriosItemHandler> handler = CuriosApi.getCuriosInventory(player);
        return handler.isPresent() && handler.get().isEquipped(item);
    }
}
