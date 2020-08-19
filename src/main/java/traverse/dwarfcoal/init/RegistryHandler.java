package traverse.dwarfcoal.init;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.WallStandingBlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import traverse.dwarfcoal.DwarfCoal;
import traverse.dwarfcoal.blocks.BlockBase;
import traverse.dwarfcoal.blocks.BlockDwarfTorch;
import traverse.dwarfcoal.blocks.BlockDwarfWallTorch;
import traverse.dwarfcoal.items.ItemBase;

public class RegistryHandler {

    public static void init(){
        registerBlocks(Registry.BLOCK);
        registerItems(Registry.ITEM);
    }

    //Items
    public static Item DWARF_COAL = new ItemBase();
    public static Item DWARF_CHARCOAL = new ItemBase();
    public static BlockItem CHARCOAL_BLOCK_ITEM = new BlockItem(RegistryHandler.CHARCOAL_BLOCK, new Item.Settings().group(DwarfCoal.TAB));
    public static BlockItem DWARF_TORCH_ITEM = new WallStandingBlockItem(RegistryHandler.DWARF_TORCH, RegistryHandler.DWARF_WALL_TORCH, new Item.Settings().group(DwarfCoal.TAB));

    //Blocks
    public static Block CHARCOAL_BLOCK = new BlockBase(Material.STONE,5.0F, 6.0F);
    public static Block DWARF_TORCH = new BlockDwarfTorch();
    public static Block DWARF_WALL_TORCH = new BlockDwarfWallTorch();

    public static void registerItems(Registry<Item> registry){
        Registry.register(registry, new Identifier(DwarfCoal.MODID, "dwarf_coal"), DWARF_COAL);
        Registry.register(registry, new Identifier(DwarfCoal.MODID, "dwarf_charcoal"), DWARF_CHARCOAL);
        Registry.register(registry, new Identifier(DwarfCoal.MODID, "charcoal_block"), CHARCOAL_BLOCK_ITEM);
        Registry.register(registry, new Identifier(DwarfCoal.MODID, "dwarf_torch"), DWARF_TORCH_ITEM);
    }

    public static void registerBlocks(Registry<Block> registry){
        Registry.register(registry, new Identifier(DwarfCoal.MODID, "charcoal_block"), CHARCOAL_BLOCK);
        Registry.register(registry, new Identifier(DwarfCoal.MODID, "dwarf_torch"), DWARF_TORCH);
        Registry.register(registry, new Identifier(DwarfCoal.MODID, "dwarf_wall_torch"), DWARF_WALL_TORCH);
    }
}
