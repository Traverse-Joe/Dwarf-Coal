package sora.dwarfcoal;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.registry.Registry;
import sora.dwarfcoal.init.ModBlocks;
import sora.dwarfcoal.init.ModItems;

public class DwarfCoal implements ModInitializer {

    public static final String MODID = "dwarfcoal";
    public static final String VERSION = "1.1.1";

    @Override
    public void onInitialize() {
        ModItems.registerItems(Registry.ITEM);
        ModBlocks.registerBlocks(Registry.BLOCK);
    }
}
