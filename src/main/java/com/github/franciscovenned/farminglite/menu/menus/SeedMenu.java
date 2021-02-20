package com.github.franciscovenned.farminglite.menu.menus;

import com.github.franciscovenned.farminglite.FarmingLite;
import com.github.franciscovenned.farminglite.events.SeedInventory;
import com.github.franciscovenned.farminglite.menu.PaginatedMenu;
import com.github.franciscovenned.farminglite.menu.PlayerMenuUtility;
import com.github.franciscovenned.farminglite.utils.PlayerMap;
import org.bukkit.ChatColor;
import org.bukkit.CropState;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Crops;
import org.bukkit.material.MaterialData;
import java.util.ArrayList;

public class SeedMenu extends PaginatedMenu {


    public SeedMenu(PlayerMenuUtility playerMenuUtility){
        super(playerMenuUtility);
    }


    @Override
    public String getMenuName() {
        return "¿Crecer o desaparece";
    }

    @Override
    public int getSlots() {
        return 9;
    }


    @Override
    public void handleMenu(InventoryClickEvent e) {

        switch (e.getCurrentItem().getType()){
            case EMERALD:
                if (e.getWhoClicked().getKiller() != null) return;
                if (PlayerMap.getLista().isEmpty()){
                    e.getWhoClicked().getKiller().sendMessage("None");
                    return;
                }
                    Location seed = PlayerMap.getLista().get(e.getWhoClicked().getKiller().getUniqueId());
                    BlockState blockState = seed.getBlock().getState();
                    MaterialData rawData = blockState.getData();

                    if (rawData instanceof Crops) {
                        Crops crops = (Crops) rawData;

                        crops.setState(CropState.MEDIUM);
                    }

                    PlayerMap.getLista().remove(e.getWhoClicked().getKiller().getUniqueId());


                break;

            case REDSTONE_BLOCK:
                Location seed2 = PlayerMap.getLista().get(e.getWhoClicked().getKiller().getUniqueId());
                BlockState blockState2 = seed2.getBlock().getState();
                MaterialData rawData2 = blockState2.getData();
                if (rawData2 instanceof Crops){
                    Crops crops = (Crops) rawData2;

                    crops.setState(CropState.GERMINATED);
                }
                e.getWhoClicked().closeInventory();

                break;


        }

    }

    @Override
    public void setMenuItems() {

        ItemStack yes = new ItemStack(Material.EMERALD, 1);
        ItemMeta yes_meta = yes.getItemMeta();
        yes_meta.setDisplayName(ChatColor.GREEN + "SI PAPI");
        ArrayList<String> yes_lore = new ArrayList<>();
        yes_lore.add("Te creceremos tu semilla papi");
        yes_meta.setLore(yes_lore);
        yes.setItemMeta(yes_meta);
        ItemStack no = new ItemStack(Material.REDSTONE_BLOCK, 1);
        ItemMeta no_meta = no.getItemMeta();
        no_meta.setDisplayName(ChatColor.RED + "NO POLFAVO");
        ArrayList<String> no_lore = new ArrayList<>();
        no_lore.add("Piensa en la huminidad");
        no_meta.setLore(no_lore);
        no.setItemMeta(no_meta);

        inventory.setItem(3, yes);
        inventory.setItem(5, no);

        setFillerGlass();

    }
}
