package traverse.dwarfcoal.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;

public class BlockBase extends Block {
    public BlockBase(Material material, float hardness, float resistance) {
        super(FabricBlockSettings.of(material).strength(hardness,resistance));
    }

    public BlockBase(int lightLevel){
        super(FabricBlockSettings.copyOf(Blocks.TORCH).lightLevel(lightLevel));
    }
}
