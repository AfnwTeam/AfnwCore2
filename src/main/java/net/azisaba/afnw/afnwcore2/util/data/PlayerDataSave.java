package net.azisaba.afnw.afnwcore2.util.data;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public record PlayerDataSave(JavaPlugin plugin, PlayerData playerData) {

  public PlayerData playerData() {
    new BukkitRunnable() {
      @Override
      public void run() {
        Bukkit.getServer().broadcast(Component.text("プレイヤーデータをセーブ中.......", NamedTextColor.YELLOW));
        playerData.savePlayerData();
        playerData.reloadPlayerData();
        Bukkit.getServer().broadcast(Component.text("セーブ完了", NamedTextColor.YELLOW));
      }
    }.runTaskTimer(plugin, 0, 20L * 60);
    return playerData;
  }
}
