package sora.dwarfcoal.items;

import net.minecraft.block.Block;
import net.minecraft.item.WallOrFloorItem;
import net.minecraft.util.ResourceLocation;
import sora.dwarfcoal.DwarfCoal;

public class BaseWallOrFloorItem extends WallOrFloorItem {

  public BaseWallOrFloorItem(String name,Block block1, Block block2, Properties properties) {
    super(block1,block2,properties);
    this.setRegistryName(new ResourceLocation(DwarfCoal.MODID, name));
  }
}
