package sora.dwarfcoal.init;

import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import sora.dwarfcoal.DwarfCoal;
import sora.dwarfcoal.blocks.BlockCharcoal;
import sora.dwarfcoal.blocks.BlockDwarfTorch;
import sora.dwarfcoal.blocks.BlockDwarfWallTorch;

public class ModBlocks {

    public static Block CHARCOAL_BLOCK = new BlockCharcoal();
    public static  Block DWARF_TORCH = new BlockDwarfTorch();
    public static Block DWARF_WALL_TORCH = new BlockDwarfWallTorch();


    public static void registerBlocks(Registry<Block> registry){
        Registry.register(registry,new Identifier(DwarfCoal.MODID, "charcoal_block"),CHARCOAL_BLOCK);
        Registry.register(registry,new Identifier(DwarfCoal.MODID, "dwarf_torch"), DWARF_TORCH);
        Registry.register(registry,new Identifier(DwarfCoal.MODID, "dwarf_wall_torch"), DWARF_WALL_TORCH);
    }
}
