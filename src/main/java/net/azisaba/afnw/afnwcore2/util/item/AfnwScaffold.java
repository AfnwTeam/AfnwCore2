package net.azisaba.afnw.afnwcore2.util.item;

import java.util.ArrayList;
import java.util.List;
import net.azisaba.afnw.afnwcore2.AfnwCore2;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * 足場ブロックを生成します。
 *
 * @param plugin メインクラス
 * @author m2en
 */
public record AfnwScaffold(AfnwCore2 plugin) {

  public static ItemStack afnwScaffold = new ItemStack(Material.SCAFFOLDING);

  static {
    ItemMeta metaData = afnwScaffold.getItemMeta();
    metaData.displayName(Component.text("AfnwScaffold").color(NamedTextColor.LIGHT_PURPLE));
    List<String> lore = new ArrayList<>();
    lore.add("Afnw投票特典の足場です。配置すると普通の足場に変化しますが、アイテムとしての効果に違いはありません。");
    metaData.setLore(lore);
    afnwScaffold.setItemMeta(metaData);
  }
}
