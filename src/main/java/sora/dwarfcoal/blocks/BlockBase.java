package sora.dwarfcoal.blocks;

import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootContext;
import sora.dwarfcoal.DwarfCoal;

import java.util.List;

public class BlockBase extends Block {
  public BlockBase(String name, Properties p_i48440_1_) {
    super(p_i48440_1_);
    this.setRegistryName(new ResourceLocation(DwarfCoal.MODID,name));
  }

  @Override
  public List<ItemStack> getDrops(BlockState p_220076_1_, LootContext.Builder p_220076_2_) {
    return Lists.newArrayList(new ItemStack(Item.getItemFromBlock(this)));
  }
}
