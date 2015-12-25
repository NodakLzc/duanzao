package com.github.nodak;

import com.github.nodak.Particles.Particles;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Administrator on 2015/12/19 0019.
 */
public class Main extends JavaPlugin implements Listener {
    EventListener eventListener = new EventListener(this);
    Particles particles=new Particles();

    @Override
    public void onDisable() {

    }

    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_BLUE + "");
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "[BC-Time] " + ChatColor.GREEN + " 武 器 强 化 ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.MAGIC + "");
        Bukkit.getConsoleSender().sendMessage(ChatColor.BOLD + "      加 载 成 功!");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_BLUE + "");
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(eventListener, this);
        particles.runTaskTimer(this,5L,20L);

    }


}
