package com.github.franciscovenned.farminglite;

import com.github.franciscovenned.farminglite.commands.God;
import com.github.franciscovenned.farminglite.commands.Time;
import com.github.franciscovenned.farminglite.events.PlayerJoinInventory;
import com.github.franciscovenned.farminglite.events.PlayerJoinTime;
import com.github.franciscovenned.farminglite.events.SeedInventory;
import com.github.franciscovenned.farminglite.listener.MenuListener;
import com.github.franciscovenned.farminglite.menu.PlayerMenuUtility;
import com.github.franciscovenned.farminglite.utils.PlayerMap;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class FarmingLite extends JavaPlugin {

    private static FarmingLite plugin;

    private static FarmingLite instance;

    private static final HashMap<Player, PlayerMenuUtility> playerMenuUtilityMap = new HashMap<>();


    @Override
    public void onEnable() {
        plugin = this;
        instance = this;
        registerConfig();
        registerCommands();
        registerEvents();
            new BukkitRunnable() {
                @Override
                public void run() {

                    for (Player player1 : PlayerJoinInventory.playerList) {

                        ItemStack itemStack = new ItemStack(Material.valueOf(FarmingLite.getPlugin().getConfig().getString("REWARD-JOIN")));
                        ItemMeta itemMeta = itemStack.getItemMeta();
                        player1.getInventory().addItem(itemStack);

                        player1.sendMessage("Obtuviste recompensa!");

                    }


                }
            }.runTaskTimer(FarmingLite.getInstance(), 1, 20 * FarmingLite.getPlugin().getConfig().getInt("SECONDS-REWARD"));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerConfig() {

        File config = new File(getDataFolder(), "config.yml");
        if (!config.exists()) {
            saveDefaultConfig();
        }
    }

    public void saveConfig() {
        try {
            getConfig().save(new File(getDataFolder(), "config.yml")); //Guardo el item en el yml
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void registerCommands() {
        this.getCommand("god").setExecutor(new God(this));
        this.getCommand("tiempo").setExecutor(new Time());
    }

    private void registerEvents() {
        PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(new PlayerJoinInventory(this), this);
        pm.registerEvents(new SeedInventory(this), this);
        pm.registerEvents(new PlayerJoinTime(), this);
        pm.registerEvents(new Time(), this);
        pm.registerEvents(new God(this), this);
        pm.registerEvents(new MenuListener(), this);
    }

    public static PlayerMenuUtility getPlayerMenuUtility(Player p) {
        PlayerMenuUtility playerMenuUtility;
        if (!(playerMenuUtilityMap.containsKey(p))) { //Ver si el jugador tiene una utilidad de menú del jugador "guardada" para ellos

            //Este jugador no lo hace. Haz uno para ellos, agrega, agrégalo al mapa de hash
            playerMenuUtility = new PlayerMenuUtility(p);
            playerMenuUtilityMap.put(p, playerMenuUtility);

            return playerMenuUtility;
        } else {
            return playerMenuUtilityMap.get(p); //Return the object by using the provided player
        }
    }




    public static FarmingLite getPlugin() {
        return plugin;
    }

    public static FarmingLite getInstance() {
        return instance;
    }

}
