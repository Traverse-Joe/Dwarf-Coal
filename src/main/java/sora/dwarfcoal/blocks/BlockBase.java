package sora.dwarfcoal.blocks;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import sora.dwarfcoal.DwarfCoal;

public class BlockBase extends Block {
  public BlockBase(String name, Properties p_i48440_1_) {
    super(p_i48440_1_);
    this.setRegistryName(new ResourceLocation(DwarfCoal.MODID,name));
  }

}
