package me.penguj.cookieclicker.item;

import com.mojang.serialization.Codec;
import me.penguj.cookieclicker.CookieClicker;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipType;
import net.minecraft.component.DataComponentType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.text.Text;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;

import java.util.List;

public class CookieJarItem extends BlockItem {
        public static final DataComponentType<Integer> COOKIES_STORED =
                DataComponentType.<Integer>builder()
                        .codec(Codec.INT)
                        .packetCodec(PacketCodecs.VAR_INT)
                        .build();

    public CookieJarItem(Block block, Settings settings) {
        super(block, settings.maxCount(1).rarity(Rarity.EPIC).component(COOKIES_STORED, 0));
    }


    private static void writeCookiesStored(ItemStack item, int amn) {
        item.set(COOKIES_STORED, amn);
    }
    public static int readCookiesStored(ItemStack item) {
        return item.getComponents().getOrDefault(COOKIES_STORED, 0);
    }

    public static void addCookiesStored(ItemStack item, int amn) {
        writeCookiesStored(item, readCookiesStored(item)+amn);
    }
    @Override
    public void appendTooltip(ItemStack itemStack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("item.cookieclicker.cookie_jar.tooltip", Integer.toString(readCookiesStored(itemStack))));
    }
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        //TODO: probably shouldn't read the inventory every tick
        if (!(entity instanceof PlayerEntity) || world.isClient()) {
            super.inventoryTick(stack, world, entity, slot, selected);
            return;
        }
        PlayerEntity player = (PlayerEntity) entity;
        for (int i = 0; i < player.getInventory().size(); i++) {
            //bad name
            ItemStack cookieStack = player.getInventory().getStack(i);
            if (cookieStack.getItem().equals(Items.COOKIE)) {
                addCookiesStored(stack, cookieStack.getCount());
                player.getInventory().removeStack(i);
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
