package com.github.franciscovenned.farminglite.utils;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerMap {


    private UUID player;
    private Location location;
    private static final Map<UUID, Location> lista = new HashMap<>();

    public PlayerMap(UUID player){
        this.player = player;
    }

    public UUID getPlayer() {
        return player;
    }

    public void setPlayer(UUID player) {
        this.player = player;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public static Map<UUID, Location> getLista() {
        return lista;
    }
}
