package sora.dwarfcoal.items;

import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import sora.dwarfcoal.init.ModBlocks;
import sora.dwarfcoal.init.ModItemGroup;
import sora.dwarfcoal.init.ModItems;

public class BlockItemBase extends BlockItem {
  public BlockItemBase() {
    super(ModBlocks.CHARCOAL_BLOCK, new Properties().group(ModItemGroup.getInstance()).maxStackSize(64));
    setRegistryName(ModBlocks.CHARCOAL_BLOCK.getRegistryName());
  }

  @Override
  public int getBurnTime(ItemStack itemStack) {
    if(itemStack.isEmpty()) return 0;
    return itemStack.getItem() == ModItems.CHARCOAL_BLOCK ? 1600 : 0;
  }
}
