package com.github.nodak.Particles;

import com.github.nodak.EventListener;
import com.github.nodak.Main;
import org.bukkit.block.Block;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Set;

/**
 * Created by Administrator on 2015/12/25 0025.
 */
public class Particles extends BukkitRunnable  implements Listener{
    Main main;
    EventListener e=new EventListener(main);
    Set<Block> block=e.map.keySet();

    public void run() {
        System.out.print(block);
        for (Block b : block) {
            e.send();
            System.out.print(b.toString());
            e.Effect(b);
        }
    }
}
