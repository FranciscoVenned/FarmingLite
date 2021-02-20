package com.github.franciscovenned.farminglite.menu;

import com.github.franciscovenned.farminglite.FarmingLite;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public abstract class Menu implements InventoryHolder {

    //Valores protegidos a los que se puede acceder en los menús
    protected PlayerMenuUtility playerMenuUtility;
    protected Inventory inventory;
    protected ItemStack FILLER_GLASS = makeItem(Material.getMaterial(FarmingLite.getPlugin().getConfig().getString("GLASS")), " ");


    // Constructor para Menú. Pase un PlayerMenuUtility para que
    // tenemos información sobre quién es el menú y
    // qué información se va a transferir
    public Menu(PlayerMenuUtility playerMenuUtility) {
        this.playerMenuUtility = playerMenuUtility;
    }


    // deja que cada menú decida su nombre
    public abstract String getMenuName();


    // deja que cada menú decida su cantidad de espacio
    public abstract int getSlots();


    // dejar que cada menú decida cómo se manejarán los elementos del menú cuando se haga clic
    public abstract void handleMenu(InventoryClickEvent e);


    // deja que cada menú decida qué elementos se colocarán en el menú del inventario
    public abstract void setMenuItems();


    // Cuando se llama, se crea un inventario y se abre para el jugador
    public void open() {

        // El propietario del inventario creado es el propio menú,
        // así que podemos aplicar ingeniería inversa al objeto Menú desde el
        // InventoryHolder en la clase MenuListener al manejar los clics
        inventory = Bukkit.createInventory(this, getSlots(), getMenuName());


        // tomar todos los elementos especificados para ser usados ​​en este menú y agregarlos al inventario
        this.setMenuItems();

        // abre el inventario para el jugador
        playerMenuUtility.getOwner().openInventory(inventory);
    }

    //Overridden method from the InventoryHolder interface
    @Override
    public Inventory getInventory() {
        return inventory;
    }

    //Helpful utility method to fill all remaining slots with "filler glass"
    public void setFillerGlass(){
        for (int i = 0; i < getSlots(); i++) {
            if (inventory.getItem(i) == null){
                inventory.setItem(i, FILLER_GLASS);
            }
        }
    }

    public ItemStack makeItem(Material material, String displayName, String... lore) {

        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(displayName);

        itemMeta.setLore(Arrays.asList(lore));
        item.setItemMeta(itemMeta);

        return item;
    }

}
