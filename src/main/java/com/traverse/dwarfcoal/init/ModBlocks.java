package com.traverse.dwarfcoal.init;

import com.traverse.dwarfcoal.DwarfCoal;
import com.traverse.dwarfcoal.blocks.BlockDwarfTorch;
import com.traverse.dwarfcoal.blocks.BlockDwarfWallTorch;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    //Blocks
    public static Block CHARCOAL_BLOCK;
    public static Block DWARF_TORCH;
    public static Block DWARF_WALL_TORCH;

    public static void registerBlocks(Registry<Block> registry) {
        CHARCOAL_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(1.0f, 6.0f)); // Should be (5.0f , 6.0f) however minecraft is bugged i guess
        DWARF_TORCH = new BlockDwarfTorch(DwarfCoal.CONFIG.lightLevel);
        DWARF_WALL_TORCH = new BlockDwarfWallTorch(DwarfCoal.CONFIG.lightLevel);
        Registry.register(registry, new Identifier(DwarfCoal.MODID, "charcoal_block"), CHARCOAL_BLOCK);
        Registry.register(registry, new Identifier(DwarfCoal.MODID, "dwarf_torch"), DWARF_TORCH);
        Registry.register(registry, new Identifier(DwarfCoal.MODID, "dwarf_wall_torch"), DWARF_WALL_TORCH);
    }
}
