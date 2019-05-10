package sora.dwarfcoal;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.util.registry.Registry;
import sora.dwarfcoal.init.ModBlocks;
import sora.dwarfcoal.init.ModItems;

public class DwarfCoal implements ModInitializer {

    public static final String MODID = "dwarfcoal";

    @Override
    public void onInitialize() {
        ModItems.registerItems(Registry.ITEM);
        ModBlocks.registerBlocks(Registry.BLOCK);
        FuelRegistry.INSTANCE.add(ModItems.DWARF_COAL, 200);
        FuelRegistry.INSTANCE.add(ModItems.DWARF_CHARCOAL, 200);
        FuelRegistry.INSTANCE.add(ModBlocks.CHARCOAL_BLOCK, 1600);
    }
}
