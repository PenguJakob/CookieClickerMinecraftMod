package me.penguj.cookieclicker;

import com.mojang.serialization.Codec;
import me.penguj.cookieclicker.block.ModBlocks;
import me.penguj.cookieclicker.item.CookieJarItem;
import me.penguj.cookieclicker.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.component.DataComponentType;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieClicker implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("cookieclicker");
    @Override
    public void onInitialize() {
        ModBlocks.registerModBlocks();
        ModItems.registerModItems();
        Registry.register(Registries.DATA_COMPONENT_TYPE, new Identifier("cookieclicker", "cookies_stored"), CookieJarItem.COOKIES_STORED);
        LOGGER.info("Cookie Clicker mod Loaded!");
    }
}
