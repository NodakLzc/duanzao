package com.github.nodak;

import org.bukkit.Effect;
import org.bukkit.EntityEffect;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class EventListener implements Listener {
    private Main main;

    public EventListener(Main main) {
        this.main = main;
    }

    @EventHandler
    public void PlayerInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (p.isSneaking()) {
                if (e.getClickedBlock().getType() == Material.FURNACE) {
                    if (e.getClickedBlock().getLocation().add(0, 1, 0).getBlock().getType() == Material.ANVIL) {
                        e.setCancelled(true);
                        Inventory inv = p.getServer().createInventory(p, 9, "§5-=§c锻造台§5=-");
                        ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE);
                        Short a = 15;
                        glass.setDurability(a);
                        ItemMeta im = glass.getItemMeta();
                        im.setDisplayName(" ");
                        glass.setItemMeta(im);
                        glass.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 0);
                        inv.setItem(0, glass);
                        inv.setItem(8, glass);
                        p.openInventory(inv);
                        p.playEffect(e.getClickedBlock().getLocation().add(0D, 3D, 0D), Effect.VILLAGER_THUNDERCLOUD, 10);
                    }
                }
            }
        }
    }


    @EventHandler
    public void InventoryClick(InventoryClickEvent e) {

        if (e.getInventory().getName().equalsIgnoreCase("§5-=§c锻造台§5=-")) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void InventoryPickUpItem(InventoryDragEvent e) {
        if (e.getInventory().getName().equalsIgnoreCase("§5-=§c锻造台§5=-")) {
            e.setCancelled(true);
        }

    }

    @EventHandler
    public void PlayerPlaceBlock(BlockPlaceEvent e) {
        Player p=e.getPlayer();
        if (e.getBlock().getType() == Material.FURNACE) {
            if (e.getBlock().getLocation().add(0, 1, 0).getBlock().getType() == Material.ANVIL) {
                p.sendMessage("§a你成功放置了一个锻造台!");
            }
        }else if(e.getBlock().getType() == Material.ANVIL){
            if (e.getBlock().getLocation().add(0, -1, 0).getBlock().getType() == Material.FURNACE) {
                p.sendMessage("§a你成功放置了一个锻造台!");
                p.sendMessage("§a你成功放置了一个锻造台!");
                p.sendMessage("§a你成功放置了一个锻造台!");
                p.sendMessage("§a你成功放置了一个锻造台!");
                p.sendMessage("§a你成功放置了一个锻造台!");
                p.sendMessage("§a你成功放置了一个锻造台!");
                p.sendMessage("§a你成功放置了一个锻造台!");
                p.sendMessage("§a你成功放置了一个锻造台!");
                p.sendMessage("§aaaaaa");

            }
        }
    }


}
