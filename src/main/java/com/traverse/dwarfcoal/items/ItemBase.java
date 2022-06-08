package com.traverse.dwarfcoal.items;

import com.traverse.dwarfcoal.DwarfCoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ItemBase extends Item {
    public ItemBase() {
        super(new Settings().group(DwarfCoal.TAB));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        return new TypedActionResult<>(ActionResult.SUCCESS, stack);
    }
}
