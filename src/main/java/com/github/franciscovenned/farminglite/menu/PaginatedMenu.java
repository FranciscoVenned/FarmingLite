package com.github.franciscovenned.farminglite.menu;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public abstract class PaginatedMenu extends Menu {

    //Realice un seguimiento de la página en la que se encuentra el menú
    protected int page = 0;

    // 28 es el máximo de elementos porque con el borde establecido a continuación,
    // Quedan 28 espacios vacíos.
    protected int maxItemsPerPage = 28;

    // el índice representa el índice de la ranura
    // que el bucle está encendido
    protected int index = 0;

    public PaginatedMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }


    // Establecer el borde y los botones del menú para el menú
    public void addMenuBorder(){
        inventory.setItem(48, makeItem(Material.WOOD_BUTTON, ChatColor.GREEN + "Atras"));

        inventory.setItem(49, makeItem(Material.BARRIER, ChatColor.DARK_RED + "Cerrar"));

        inventory.setItem(50, makeItem(Material.WOOD_BUTTON, ChatColor.GREEN + "Siguiente"));

        for (int i = 0; i < 10; i++) {
            if (inventory.getItem(i) == null) {
                inventory.setItem(i, super.FILLER_GLASS);
            }
        }

        inventory.setItem(17, super.FILLER_GLASS);
        inventory.setItem(18, super.FILLER_GLASS);
        inventory.setItem(26, super.FILLER_GLASS);
        inventory.setItem(27, super.FILLER_GLASS);
        inventory.setItem(35, super.FILLER_GLASS);
        inventory.setItem(36, super.FILLER_GLASS);

        for (int i = 44; i < 54; i++) {
            if (inventory.getItem(i) == null) {
                inventory.setItem(i, super.FILLER_GLASS);
            }
        }
    }

    public int getMaxItemsPerPage() {
        return maxItemsPerPage;
    }
}
