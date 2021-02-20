package com.github.franciscovenned.farminglite.events;

import com.github.franciscovenned.farminglite.FarmingLite;
import com.github.franciscovenned.farminglite.menu.menus.SeedMenu;
import com.github.franciscovenned.farminglite.utils.PlayerMap;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;


public class SeedInventory implements Listener {

    private FarmingLite plugin;

    public SeedInventory(FarmingLite plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onInteraction(PlayerInteractEvent event) {

        Player player = (Player) event.getPlayer();

        if (event.getAction() != Action.LEFT_CLICK_BLOCK && event.getAction() != Action.RIGHT_CLICK_BLOCK) return;

        Material material = event.getClickedBlock().getType();

        player.sendMessage("item is" + material);

        if (event.getClickedBlock().getType() != Material.CROPS) return;

        PlayerMap.getLista().put(player.getUniqueId(), event.getClickedBlock().getLocation());

        new SeedMenu(FarmingLite.getPlayerMenuUtility(player)).open();



    }


//    @EventHandler
//    public void onPlayerLocation(PlayerEvent event){
//
//        Player player = event.getPlayer();
//
//        Location location = player.getLocation();
//
//        this.x = location.getBlockX();
//        this.y = location.getBlockZ();
//        this.z = location.getBlockZ();
//        this.world = location.getWorld();
//
//        Location location1 = new Location(world, x, y, z);
//
//        FileConfiguration fileConfiguration = FarmingLite.getPlugin().getConfig();
//        fileConfiguration.set("Location", location1);
//
//    }

//    public Location getLocation(){
//
//
//        FileConfiguration config = FarmingLite.getPlugin().getConfig();
//        config.getInt("Location");
//
//        return null;
//    }

}
