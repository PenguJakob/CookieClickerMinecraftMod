package me.penguj.cookieclicker.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.component.ComponentMap;
import net.minecraft.component.DataComponentType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

public class CookieJarEntity extends BlockEntity {
    private static int stored_cookies = 0;
    public CookieJarEntity(BlockPos pos, BlockState state) {
        super(ModBlocks.cookie_jar_entity, pos, state);
    }
}
