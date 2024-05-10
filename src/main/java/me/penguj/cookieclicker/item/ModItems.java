package me.penguj.cookieclicker.item;

import me.penguj.cookieclicker.CookieClicker;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;


public class ModItems {
    public static Item cookieclikeritem;
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier("cookieclicker", name), item);
    }
    private static void setItemGroup(Item item, RegistryKey<ItemGroup> itemGroup) {
        ItemGroupEvents.modifyEntriesEvent(itemGroup).register(content -> {
            content.add(item);
        });
    }
    public static void registerModItems() {
        CookieClicker.LOGGER.debug("Registering mod items!");
        cookieclikeritem = registerItem("cookieclickeritem", new CookieClickerItem(new Item.Settings()));
        setItemGroup(cookieclikeritem, ItemGroups.FOOD_AND_DRINK);
    }
}
