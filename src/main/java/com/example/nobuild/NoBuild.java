package com.example.nobuild;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.java.JavaPlugin;

public class NoBuild extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    private boolean canBuild(org.bukkit.entity.Player player) {
        return player.isOp() || player.hasPermission("nobuild.bypass");
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onBlockPlace(BlockPlaceEvent event) {
        if (!canBuild(event.getPlayer())) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "You are not allowed to build.");
        }
    }

}
