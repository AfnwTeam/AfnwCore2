package net.azisaba.afnw.afnwcore2.listeners.player.block;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockFromToEvent;

/**
 * bypass permission
 * - afnw.bypass.break.crops
 * - afnw.bypass.break.newCrops
 */
public class CropsBreakCanceller implements Listener {

    //TODO: bypassで通過した際にメッセージを送る

    /**
     * 農作物が植えられている耕地の保護をするメソッド
     */
    @EventHandler(priority = EventPriority.HIGH)
    public void onBreakCrops(BlockBreakEvent e) {
        Player p = e.getPlayer();
        Block b = e.getBlock();

        if(!Tag.CROPS.isTagged(b.getLocation().add(0, 1, 0).getBlock().getType())) return;
        if(p.hasPermission("afnw.bypass.break.crops")) return;
        e.setCancelled(true);
        p.sendMessage(Component.text("農作物が植えられている耕地を破壊することはできません。").color(NamedTextColor.RED));
    }

    /**
     * 成長しきっていない農作物を保護するメソッド
     */
    @EventHandler(priority = EventPriority.HIGH)
    public void onBreakNewAgeCrops(BlockBreakEvent e) {
        Player p = e.getPlayer();
        Block b = e.getBlock();
        if(!Tag.CROPS.isTagged(b.getType())) return;
        if(p.hasPermission("afnw.bypass.break.newCrops")) return;
        if(!(b.getBlockData() instanceof Ageable)) {
            Ageable crop = (Ageable) b.getBlockData();
            if(crop.getMaximumAge() == crop.getAge()) return;
        }

        e.setCancelled(true);
        p.sendMessage(Component.text("成長しきっていない農作物を破壊することはできません。").color(NamedTextColor.RED));
    }

    /**
     * 農作物に対する水流をブロックする阻害するメソッド
     */
    @EventHandler(priority = EventPriority.HIGH)
    public void onBreakByWater(BlockFromToEvent e) {
        Block b = e.getToBlock();
        if(!Tag.CROPS.isTagged(b.getType())) return;
        if (b.getBlockData() instanceof Ageable crop) {
            if (crop.getMaximumAge() == crop.getAge()) return;
        }
        e.setCancelled(true);
    }
}
