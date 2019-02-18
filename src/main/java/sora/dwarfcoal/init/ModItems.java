package sora.dwarfcoal.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.block.BlockItem;
import net.minecraft.item.block.WallStandingBlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import sora.dwarfcoal.DwarfCoal;
import sora.dwarfcoal.items.ItemDwarfCoal;

import static net.minecraft.item.ItemGroup.*;

public class ModItems {
    public static Item DWARF_COAL = new ItemDwarfCoal();
    public static Item DWARF_CHARCOAL = new ItemDwarfCoal();
    public static BlockItem CHARCOAL_BLOCK = new BlockItem(ModBlocks.CHARCOAL_BLOCK, new Item.Settings().itemGroup(BUILDING_BLOCKS));
    public static BlockItem DWARF_TORCH = new WallStandingBlockItem(ModBlocks.DWARF_TORCH, ModBlocks.DWARF_WALL_TORCH, (new Item.Settings()).itemGroup(DECORATIONS));

    public static void registerItems(Registry<Item> registry){
        Registry.register(registry,new Identifier(DwarfCoal.MODID, "dwarf_coal"),DWARF_COAL);
        Registry.register(registry,new Identifier(DwarfCoal.MODID, "dwarf_charcoal"),DWARF_CHARCOAL);
        Registry.register(registry, new Identifier(DwarfCoal.MODID, "charcoal_block"),CHARCOAL_BLOCK);
        Registry.register(registry,new Identifier(DwarfCoal.MODID, "dwarf_torch"), DWARF_TORCH);

    }
}
