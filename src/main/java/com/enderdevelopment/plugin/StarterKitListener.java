package com.enderdevelopment.plugin;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.Registry;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.NamespacedKey;

public final class StarterKitListener implements Listener {
    private final Plugin plugin;

    public StarterKitListener(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPlayedBefore()) {
            return;
        }

        plugin.getServer().getScheduler().runTask(plugin, () -> giveStarterKit(player));
    }

    private void giveStarterKit(Player player) {
        player.getInventory().addItem(
                createTool(Material.IRON_SWORD, "Enhanced Iron Sword", "sharpness", 2),
                createTool(Material.IRON_PICKAXE, "Enhanced Iron Pickaxe", "efficiency", 2),
                createTool(Material.IRON_AXE, "Enhanced Iron Axe", "efficiency", 2),
                createTool(Material.IRON_SHOVEL, "Enhanced Iron Shovel", "efficiency", 2),
                createArmor(Material.IRON_HELMET, "Reinforced Iron Helmet"),
                createArmor(Material.IRON_CHESTPLATE, "Reinforced Iron Chestplate"),
                createArmor(Material.IRON_LEGGINGS, "Reinforced Iron Leggings"),
                createArmor(Material.IRON_BOOTS, "Reinforced Iron Boots")
        );
        player.sendMessage(Component.text("You received an enhanced iron starter kit!", NamedTextColor.GREEN));
    }

    private ItemStack createTool(Material material, String name, String enchantmentKey, int level) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        if (meta == null) {
            return item;
        }

        meta.displayName(Component.text(name, NamedTextColor.AQUA));
        addEnchantment(meta, enchantmentKey, level);
        addEnchantment(meta, "unbreaking", 2);
        item.setItemMeta(meta);
        return item;
    }

    private ItemStack createArmor(Material material, String name) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        if (meta == null) {
            return item;
        }

        meta.displayName(Component.text(name, NamedTextColor.AQUA));
        addEnchantment(meta, "protection", 2);
        addEnchantment(meta, "unbreaking", 2);
        item.setItemMeta(meta);
        return item;
    }

    private void addEnchantment(ItemMeta meta, String key, int level) {
        Enchantment enchantment = Registry.ENCHANTMENT.get(NamespacedKey.minecraft(key));
        if (enchantment != null) {
            meta.addEnchant(enchantment, level, true);
        }
    }
}
