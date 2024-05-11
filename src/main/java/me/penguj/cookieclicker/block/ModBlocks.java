package me.penguj.cookieclicker.block;

import me.penguj.cookieclicker.CookieClicker;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityType;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static Block cookie_jar = registerBlock("cookie_jar", new CookieJar(Block.Settings.create()));
    //TODO: Function to build block entities like block below
    public static final BlockEntityType<CookieJarEntity> cookie_jar_entity = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier("cookieclicker", "cookie_jar_entity"),
            FabricBlockEntityTypeBuilder.create(CookieJarEntity::new, cookie_jar).build()
    );
    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier("cookieclicker", name), block);
    }
    public static void registerModBlocks() {
        CookieClicker.LOGGER.debug("Registering blocks!");
    }
}
