package sora.dwarfcoal.init;

import net.minecraft.block.Block;
import net.minecraft.item.block.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import sora.dwarfcoal.DwarfCoal;
import sora.dwarfcoal.blocks.BlockCharcoal;

public class ModBlocks {

    public static Block CHARCOAL_BLOCK = new BlockCharcoal();

    public static void registerBlocks(Registry<Block> registry){
        Registry.register(registry,new Identifier(DwarfCoal.MODID, "charcoal_block"),CHARCOAL_BLOCK);
    }
}
