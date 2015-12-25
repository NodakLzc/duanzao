package com.github.nodak;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;

public class EventListener implements Listener {
    private Main main;
    public HashMap<Block, Location> map = new HashMap<Block, Location>();

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
                        glass.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
                        inv.setItem(0, glass);
                        inv.setItem(8, glass);
                        inv.setItem(2, glass);
                        inv.setItem(3, glass);
                        inv.setItem(4, glass);
                        inv.setItem(5, glass);
                        p.openInventory(inv);
                        p.playEffect(e.getClickedBlock().getLocation().add(0D, 3D, 0D), Effect.VILLAGER_THUNDERCLOUD, 10);
                    }
                }
            }
        }
    }

    @EventHandler
    public void InventoryClick(InventoryClickEvent e) {
        if (e.getClickedInventory().getName().equalsIgnoreCase("§5-=§c锻造台§5=-")) {
            if (e.getSlot() == 0 || e.getSlot() == 8) {
                e.setCancelled(true);
            }

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
        Player p = e.getPlayer();
        if (e.getBlock().getType() == Material.FURNACE) {
            if (e.getBlock().getLocation().add(0, 1, 0).getBlock().getType() == Material.ANVIL) {
                p.sendMessage("§a你成功放置了一个锻造台!");
                map.put(e.getBlock(), e.getBlock().getLocation());

            }
        } else if (e.getBlock().getType() == Material.ANVIL) {
            if (e.getBlock().getLocation().add(0, -1, 0).getBlock().getType() == Material.FURNACE) {
                p.sendMessage("§a你成功放置了一个锻造台!");
                map.put(e.getBlock(), e.getBlock().getLocation().add(0.0D, 1.0D, 0.0D));
                p.sendMessage(map.keySet().toString());
                for(Block b:map.keySet()){
                    p.sendMessage(b.toString());
                }
            }
        }
    }


    public void Effect(Block b) {
        b.setType(Material.DIAMOND_BLOCK);
        b.setType(Material.GOLD_BLOCK,true);
        b.setType(Material.DIAMOND_BLOCK);

    }

    public void send(){
        for(Player p: Bukkit.getOnlinePlayers()){
            p.sendMessage("aaa");
        }
    }

}
