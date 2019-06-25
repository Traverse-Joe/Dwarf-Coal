package sora.dwarfcoal.blocks;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import sora.dwarfcoal.DwarfCoal;

public class BlockBase extends Block {
  public BlockBase(String name, Properties properties) {
    super(properties);
    this.setRegistryName(new ResourceLocation(DwarfCoal.MODID,name));
  }

 /* @Override
  public List<ItemStack> getDrops(BlockState p_220076_1_, LootContext.Builder p_220076_2_) {
    return Lists.newArrayList(new ItemStack(Item.getItemFromBlock(this)));
  }*/
}
