package traverse.dwarfcoal;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import traverse.dwarfcoal.init.RegistryHandler;

public class DwarfCoal implements ModInitializer {

    public static final String MODID = "dwarfcoal";

    @Override
    public void onInitialize() {
        RegistryHandler.init();
        FuelRegistry.INSTANCE.add(RegistryHandler.DWARF_COAL,200);
        FuelRegistry.INSTANCE.add(RegistryHandler.DWARF_CHARCOAL,200);
        FuelRegistry.INSTANCE.add(RegistryHandler.CHARCOAL_BLOCK, 1600);
    }

    public static ItemGroup TAB = FabricItemGroupBuilder.build(
            new Identifier(DwarfCoal.MODID, "item_group"),
            () -> new ItemStack(RegistryHandler.DWARF_COAL));

}
