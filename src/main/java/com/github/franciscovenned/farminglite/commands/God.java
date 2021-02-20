package com.github.franciscovenned.farminglite.commands;

import com.github.franciscovenned.farminglite.FarmingLite;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.ArrayList;
import java.util.List;

public class God implements CommandExecutor, Listener {

    private ArrayList<String> god = new ArrayList<String>();

    private FarmingLite plugin;

    public God(FarmingLite plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("god")){
            if (args.length == 0){
                if (sender instanceof Player) {
                    Player player = (Player) sender;
                    if (player.hasPermission("farminglite.god")){
                        if (god.contains(player.getName())){
                            god.remove(player.getName());
                            player.sendMessage("Ya no eres inmortal");
                        } else {
                            god.add(player.getName());
                            player.sendMessage("Eres inmortal");
                        }
                    } else {
                        player.sendMessage("No tienes permisos");
                    }
                }
            }

        }


        return true;
    }

    @EventHandler
    public void inmortal(EntityDamageEvent event){
        if (event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();
            if (god.contains(player.getName())){
                event.setCancelled(true);
            }
        }
    }


}
