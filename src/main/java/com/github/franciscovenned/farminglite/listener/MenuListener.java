package com.github.franciscovenned.farminglite.listener;

import com.github.franciscovenned.farminglite.menu.Menu;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;

public class MenuListener implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){

        InventoryHolder holder = e.getInventory().getHolder();

        // Si el titular del inventario hizo clic en
        // es una instancia de Menu, luego gg. La razón que
        // un InventoryHolder puede ser un menú porque nuestro menú
        // ¡la clase implementa InventoryHolder!
        if (holder instanceof Menu) {
            e.setCancelled(true); //evitar que jodan con el inventario
            if (e.getCurrentItem() == null) { //lidiar con excepciones nulas
                return;
            }

            // Como sabemos que nuestro titular de inventario es un menú, obtenga el objeto de menú que representa
            // el menú en el que hicimos clic
            Menu menu = (Menu) holder;

            // Llamar al objeto handleMenu que toma el evento y lo procesa
            menu.handleMenu(e);
        }

    }

}
