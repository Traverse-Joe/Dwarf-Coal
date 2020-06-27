package sora.dwarfcoal.init;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import sora.dwarfcoal.items.BaseWallOrFloorItem;
import sora.dwarfcoal.items.BlockItemBase;
import sora.dwarfcoal.items.ItemBase;

public class ModItems {

  public static final Item DWARF_COAL = new ItemBase("dwarf_coal");
  public static final Item DWARF_CHARCOAL = new ItemBase("dwarf_charcoal");
  public static final Item STONE_ROD = new ItemBase("stone_rod");
  public static final BlockItem CHARCOAL_BLOCK = new BlockItemBase(ModBlocks.CHARCOAL_BLOCK);
  public static final BlockItem DWARF_TORCH = new BaseWallOrFloorItem("dwarf_torch",ModBlocks.DWARF_TORCH, ModBlocks.DWARF_WALL_TORCH, new Item.Properties().group(ModItemGroup.getInstance()));
  public static final BlockItem STONE_DWARF_TORCH = new BaseWallOrFloorItem("stone_dwarf_torch",ModBlocks.STONE_DWARF_TORCH, ModBlocks.STONE_DWARF_WALL_TORCH, new Item.Properties().group(ModItemGroup.getInstance()));
  public static final BlockItem STONE_TORCH = new BaseWallOrFloorItem("stone_torch",ModBlocks.STONE_TORCH, ModBlocks.STONE_WALL_TORCH, new Item.Properties().group(ModItemGroup.getInstance()));

  static{
    new ModItems();
  }

}
