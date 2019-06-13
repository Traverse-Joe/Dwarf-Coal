package sora.dwarfcoal.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import sora.dwarfcoal.DwarfCoal;
import sora.dwarfcoal.init.ModItemGroup;
import sora.dwarfcoal.init.ModItems;

public class ItemBase extends Item {

  //private static final Properties PROPS = new Properties().group(ModItemGroup.getInstance()).maxStackSize(64);

  public ItemBase(String name) {
    super(new Item.Properties().group(ModItemGroup.getInstance()));
    this.setRegistryName(new ResourceLocation(DwarfCoal.MODID, name));

  }

  @Override
  public int getBurnTime(ItemStack itemStack) {
    if(itemStack.isEmpty()) return 0;
    Item item = itemStack.getItem();
    if(item == ModItems.DWARF_CHARCOAL || item == ModItems.DWARF_COAL){
      return 200;
    }
    return 0;
  }
}
