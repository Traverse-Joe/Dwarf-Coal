package sora.dwarfcoal.blocks;

import net.fabricmc.fabric.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;

public class BlockCharcoal extends Block {
    public BlockCharcoal() {
        super(FabricBlockSettings.of(Material.STONE).build().strength(5.0F, 6.0F));
    }
}
