package com.github.nodak;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;

/**
 * Created by Administrator on 2015/12/19 0019.
 */
public class Main extends JavaPlugin implements Listener {
    EventListener eventListener=new EventListener(this);
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA+"-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_BLUE+"");
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW+"[BC-Time] "+ChatColor.GREEN+" 武 器 强 化 ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.MAGIC+"");
        Bukkit.getConsoleSender().sendMessage(ChatColor.BOLD+"      加 载 成 功!");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_BLUE+"");
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA+"-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        getServer().getPluginManager().registerEvents(this,this);
        getServer().getPluginManager().registerEvents(eventListener,this);
    }



}
