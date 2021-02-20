package com.github.franciscovenned.farminglite.menu;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerMenuUtility {

    private Player owner;
    //store the player that will be killed so we can access him in the next menu
    private Player playerToKill;

    public PlayerMenuUtility(Player p) {
        this.owner = p;
    }

    public Player getOwner() {
        return owner;
    }

    public Player getPlayerToKill() {
        return playerToKill;
    }

    public void setPlayerToKill(Player playerToKill) {
        this.playerToKill = playerToKill;
    }

}
