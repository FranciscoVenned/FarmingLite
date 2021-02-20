package com.github.franciscovenned.farminglite.events;

import com.github.franciscovenned.farminglite.FarmingLite;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class PlayerJoinInventory implements Listener {


    public static List<Player> playerList = new ArrayList<Player>();

    public final FarmingLite plugin;

    public PlayerJoinInventory(FarmingLite plugin){
        this.plugin = plugin;
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){

        Player player = event.getPlayer();
        if (player.hasPermission("farminglite.join")){
            playerList.add(player);
        }
    }


}
