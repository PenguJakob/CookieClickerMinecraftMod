package me.penguj.cookieclicker.item;

import me.penguj.cookieclicker.CookieClicker;
import net.minecraft.client.item.TooltipData;
import net.minecraft.client.item.TooltipType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.Slot;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ClickType;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;
import java.util.Optional;

public class CookieClickerItem extends Item {
    public CookieClickerItem(Settings settings) {
        super(settings.maxCount(1).rarity(Rarity.EPIC));
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        CookieClicker.LOGGER.info("Cookie Clicker clicked");
        //now for the meat and potatos
        //lets create a cookie everytime its clicked
        ItemStack cookie = new ItemStack(Items.COOKIE);
        user.giveItemStack(cookie);
        //play a sound
        user.playSound(SoundEvents.ENTITY_ITEM_PICKUP);

        return TypedActionResult.pass(user.getStackInHand(hand));
    }
    @Override
    public void appendTooltip(ItemStack itemStack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("item.cookieclicker.cookieclickeritem.tooltip"));
    }
}
