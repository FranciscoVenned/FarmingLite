package com.github.franciscovenned.farminglite.events;

import com.github.franciscovenned.farminglite.commands.Time;
import com.sun.media.jfxmedia.events.PlayerTimeListener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinTime implements Listener {

    @EventHandler
    public void onTimePlayer(PlayerJoinEvent event){
        Player player = (Player) event.getPlayer();
        if (!Time.playertime.containsKey(player.getName())){
            Time.playertime.put(player.getName(), System.currentTimeMillis());
        }
    }

}
