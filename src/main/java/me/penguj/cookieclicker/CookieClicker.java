package me.penguj.cookieclicker;
import me.penguj.cookieclicker.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieClicker implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("cookieclicker");
    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        LOGGER.info("Cookie Clicker mod Loaded!");
    }
}
