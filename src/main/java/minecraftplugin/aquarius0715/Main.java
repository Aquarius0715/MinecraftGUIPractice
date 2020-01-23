package minecraftplugin.aquarius0715;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class Main extends JavaPlugin implements Listener {


    public Inventory inv;

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        //createInvメソッドを呼び出す
        createInv();
    }

    @Override
    public void onDisable() {

    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("changeteam")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("You cannot do this!");
            }
            Player player = (Player) sender;
            // open GUI
            player.openInventory(inv);
            return true;
        }
        return false;
    }

    @EventHandler()
    public void onClick(InventoryClickEvent event) {
        if (!event.getInventory().equals(inv)) return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;

        event.setCancelled(true);

        Player player = (Player) event.getWhoClicked();

        if (event.getSlot() == 0) {
            //プレーヤーに選択したチームの色のアーマーを着せる
            //青色のアーマーを着せる
            ItemStack[] armor = player.getEquipment().getArmorContents();
            armor = changeColor(armor, Color.BLUE);
            player.getEquipment().setArmorContents(armor);
            player.sendMessage(ChatColor.GOLD + "You changed your team");
        }

        if (event.getSlot() == 1) {
            //プレーヤーに選択したチームの色のアーマーを着せる
            //赤色のアーマーを着せる
            ItemStack[] armor = player.getEquipment().getArmorContents();
            armor = changeColor(armor, Color.RED);
            player.getEquipment().setArmorContents(armor);
            player.sendMessage(ChatColor.GOLD + "You changed your team");
        }

        if (event.getSlot() == 2) {
            //プレーヤーに選択したチームの色のアーマーを着せる
            //緑色のアーマーを着せる
            ItemStack[] armor = player.getEquipment().getArmorContents();
            armor = changeColor(armor, Color.GREEN);
            player.getEquipment().setArmorContents(armor);
            player.sendMessage(ChatColor.GOLD + "You changed your team");
        }

        if (event.getSlot() == 3) {
            //プレーヤーに選択したチームの色のアーマーを着せる
            //オレンジのアーマーを着せる
            ItemStack[] armor = player.getEquipment().getArmorContents();
            armor = changeColor(armor, Color.ORANGE);
            player.getEquipment().setArmorContents(armor);
            player.sendMessage(ChatColor.GOLD + "You changed your team");
        }

        if (event.getSlot() == 4) {
            //プレーヤーに選択したチームの色のアーマーを着せる
            //紫のアーマーを着せる
            ItemStack[] armor = player.getEquipment().getArmorContents();
            armor = changeColor(armor, Color.PURPLE);
            player.getEquipment().setArmorContents(armor);
            player.sendMessage(ChatColor.GOLD + "You changed your team");
        }

        if (event.getSlot() == 5) {
            //プレーヤーに選択したチームの色のアーマーを着せる
            //水色のアーマーを着せる
            ItemStack[] armor = player.getEquipment().getArmorContents();
            armor = changeColor(armor, Color.AQUA);
            player.getEquipment().setArmorContents(armor);
            player.sendMessage(ChatColor.GOLD + "You changed your team");
        }

        if (event.getSlot() == 6) {
            //プレーヤーに選択したチームの色のアーマーを着せる
            //黒色のアーマーを着せる
            ItemStack[] armor = player.getEquipment().getArmorContents();
            armor = changeColor(armor, Color.BLACK);
            player.getEquipment().setArmorContents(armor);
            player.sendMessage(ChatColor.GOLD + "You changed your team");
        }

        if (event.getSlot() == 8) {
            player.closeInventory();
        }

        return;
    }

    public ItemStack[] changeColor(ItemStack[] a, Color color) {
        for (ItemStack item : a) {
            try {
                if (item.getType() == Material.LEATHER_BOOTS || item.getType() == Material.LEATHER_CHESTPLATE ||
                        item.getType() == Material.LEATHER_LEGGINGS || item.getType() == Material.LEATHER_HELMET) {
                    LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
                    meta.setColor(color);
                    item.setItemMeta(meta);
                }
            } catch (Exception e) {
                //何もされない場合は
            }
        }

        return a;
    }

    public void createInv() {

        //新しいインベントリを作成
        inv = Bukkit.createInventory(null, 9, ChatColor.GOLD + "" + ChatColor.BOLD + "Select Team");

        //新しいアイテムを作成
        ItemStack item = new ItemStack(Material.LAPIS_BLOCK);
        //アイテムメタを作成
        ItemMeta meta = item.getItemMeta();
        //loreのリストを作成
        List<String> lore = new ArrayList<String>();
        //loreに説明を追加
        lore.add(ChatColor.GRAY + "Click to join team!");

        //ブルーチームを作成
        //アイテムメタに名前を設定
        meta.setDisplayName(ChatColor.DARK_BLUE + "BLUE TEAM");
        //アイテムメタにloreを設定
        meta.setLore(lore);
        //作ったアイテムを代入
        item.setItemMeta(meta);
        //インベントリに作ったアイテムを入れる
        //inv.setItem(インベントリの番号, 入れるアイテムの詳細);
        inv.setItem(0, item);

        //レッドチームの作成
        item.setType(Material.REDSTONE);
        meta.setDisplayName(ChatColor.DARK_RED + "RED TEAM");
        item.setItemMeta(meta);
        inv.setItem(1, item);

        //グリーンチームの作成
        item.setType(Material.SLIME_BALL);
        meta.setDisplayName(ChatColor.DARK_GREEN + "GREEN TEAM");
        item.setItemMeta(meta);
        inv.setItem(2, item);

        //オレンジチームの作成
        item.setType(Material.SPONGE);
        meta.setDisplayName(ChatColor.GOLD + "ORANGE TEAM");
        item.setItemMeta(meta);
        inv.setItem(3, item);

        //パープルチームの作成
        item.setType(Material.CHORUS_FRUIT);
        meta.setDisplayName(ChatColor.DARK_PURPLE + "PURPLE TEAM");
        item.setItemMeta(meta);
        inv.setItem(4, item);

        //ブルーチームの作成
        item.setType(Material.DIAMOND);
        meta.setDisplayName(ChatColor.BLUE + "CYAN TEAM");
        item.setItemMeta(meta);
        inv.setItem(5, item);

        //ブラックチームの作成
        item.setType(Material.OBSIDIAN);
        meta.setDisplayName(ChatColor.BLACK + "BLACK TEAM");
        item.setItemMeta(meta);
        inv.setItem(6, item);

        //close button
        item.setType(Material.BARRIER);
        meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Close Menu");
        lore.clear();
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(8, item);
    }
}
