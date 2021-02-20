package com.github.franciscovenned.farminglite.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.HashMap;
import java.util.Map;

public class Time implements CommandExecutor, Listener {
                        // KEy // VALOR
    public static Map<String, Long> playertime = new HashMap<>();


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("tiempo")){
            if (args.length == 0){
                if (sender instanceof Player) {
                    Player player = (Player) sender;
                    if (player.hasPermission("farminglite.time")){
                        if (playertime.containsKey(player.getName())){                     // kEY y me devuelve el Valor
                            player.sendMessage("Las horas jugadas son de" + playertime.get(player.getName()));
                        } else {
                            player.sendMessage("No esta disponible");
                        }
                    } else {
                        player.sendMessage("No tienes permisos");
                    }
                }
            }

        }


        return true;
    }


}
