package com.example.nobuild;

/*
 * The NoBuild plugin is a minimal example of a Spigot plugin.
 * It blocks players from placing blocks unless they are an
 * operator (OP) or have a special permission node.  This class
 * is heavily commented so you can learn how a simple plugin is
 * structured and works internally.
 *
 * Future ideas (purely optional) that you might want to explore:
 *   - Read a configuration file to toggle building in certain worlds.
 *   - Allow building in specific regions (perhaps integrate with
 *     another protection plugin such as WorldGuard).
 *   - Customise the warning message when a block placement is denied.
 */

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.java.JavaPlugin;

public class NoBuild extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        // The onEnable method is called by Spigot when the plugin is first loaded.
        // Here we simply register this class as a listener so that our
        // onBlockPlace method will receive events whenever a player tries to
        // place a block.
        getServer().getPluginManager().registerEvents(this, this);

        // If you want to add more setup logic later (such as reading a
        // configuration file), this is a good place to do so.
        // Example:
        // saveDefaultConfig(); // Uncomment to create a config.yml on first run
    }

    // Helper method to decide if a player is allowed to place blocks.
    // The plugin keeps things simple and only lets server operators build.
    // WorldGuard or other protection plugins can still intervene at higher
    // priorities if desired.
    private boolean canBuild(org.bukkit.entity.Player player) {
        return player.isOp();
    }

    // Event handler that fires every time a player attempts to place a block.
    // We run at a relatively HIGH priority so we can override other plugins,
    // but still let even higher priority plugins take control if necessary.
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onBlockPlace(BlockPlaceEvent event) {
        // Only take action if the player doesn't have permission to build.
        if (!canBuild(event.getPlayer())) {
            // Prevent the block from being placed.
            event.setCancelled(true);

            // Inform the player so they know why the block disappeared.
            // You can customize this message in the future or even pull it from
            // a configuration file.
            event.getPlayer().sendMessage(ChatColor.RED + "You are not allowed to build.");
        }
    }

}
