package com.traverse.dwarfcoal.init;

import com.traverse.dwarfcoal.DwarfCoal;
import com.traverse.dwarfcoal.items.ItemBase;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.WallStandingBlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static Item DWARF_COAL = new ItemBase();
    public static Item DWARF_CHARCOAL = new ItemBase();
    public static BlockItem CHARCOAL_BLOCK_ITEM = new BlockItem(ModBlocks.CHARCOAL_BLOCK, new Item.Settings().group(DwarfCoal.TAB));
    public static BlockItem DWARF_TORCH_ITEM = new WallStandingBlockItem(ModBlocks.DWARF_TORCH, ModBlocks.DWARF_WALL_TORCH, new Item.Settings().group(DwarfCoal.TAB));

    public static void registerItems(Registry<Item> registry){
        Registry.register(registry, new Identifier(DwarfCoal.MODID, "dwarf_coal"), DWARF_COAL);
        Registry.register(registry, new Identifier(DwarfCoal.MODID, "dwarf_charcoal"), DWARF_CHARCOAL);
        Registry.register(registry, new Identifier(DwarfCoal.MODID, "charcoal_block"), CHARCOAL_BLOCK_ITEM);
        Registry.register(registry, new Identifier(DwarfCoal.MODID, "dwarf_torch"), DWARF_TORCH_ITEM);
    }
}
