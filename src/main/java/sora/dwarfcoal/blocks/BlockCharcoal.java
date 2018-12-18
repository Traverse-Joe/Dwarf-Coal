package sora.dwarfcoal.blocks;

import net.fabricmc.fabric.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class BlockCharcoal extends Block {
    public BlockCharcoal() {
        super(FabricBlockSettings.of(Material.STONE).build().strength(5.0F, 6.0F));
    }

    @Override
    public void onBroken(IWorld var1, BlockPos var2, BlockState var3) {
        super.onBroken(var1, var2, var3);
    }
}
