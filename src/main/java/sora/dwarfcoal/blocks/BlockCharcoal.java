package sora.dwarfcoal.blocks;

import com.google.common.collect.Lists;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.loot.context.LootContext;

import java.util.List;

public class BlockCharcoal extends Block {
    public BlockCharcoal() {
        super(FabricBlockSettings.of(Material.STONE).build().strength(5.0F, 6.0F));
    }

    @Override
    public List<ItemStack> getDroppedStacks(BlockState blockState, LootContext.Builder builder) {
        return Lists.newArrayList(new ItemStack(Item.getItemFromBlock(this)));
    }
}

