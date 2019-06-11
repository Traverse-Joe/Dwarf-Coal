package sora.dwarfcoal.items;

import net.minecraft.block.Block;
import net.minecraft.item.WallOrFloorItem;
import net.minecraft.util.ResourceLocation;
import sora.dwarfcoal.DwarfCoal;

public class BaseWallorFloorItem extends WallOrFloorItem {
  public BaseWallorFloorItem(String name,Block p_i48462_1_, Block p_i48462_2_, Properties p_i48462_3_) {
    super(p_i48462_1_, p_i48462_2_, p_i48462_3_);
    this.setRegistryName(new ResourceLocation(DwarfCoal.MODID, name));
  }
}
