package sora.dwarfcoal.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import sora.dwarfcoal.DwarfCoal;

public class ModItemGroup extends ItemGroup {

  private static final ModItemGroup INSTANCE = new ModItemGroup();

  public ModItemGroup() {
    super(DwarfCoal.MODID);
  }

  public static ModItemGroup getInstance() {
    return INSTANCE;
  }

  @Override
  public ItemStack createIcon() {
    return new ItemStack(ModItems.DWARF_COAL);
  }

}