package com.traverse.dwarfcoal;

import com.traverse.dwarfcoal.config.ConfigHandler;
import com.traverse.dwarfcoal.init.ModBlocks;
import com.traverse.dwarfcoal.init.ModItems;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DwarfCoal implements ModInitializer {

    public static final String MODID = "dwarfcoal";
    public static ItemGroup TAB = FabricItemGroupBuilder.build(new Identifier(DwarfCoal.MODID, "item_group"), () -> new ItemStack(ModItems.DWARF_COAL));
    public static ConfigHandler CONFIG = new ConfigHandler();

    @Override
    public void onInitialize() {
        AutoConfig.register(ConfigHandler.class, JanksonConfigSerializer::new);
        CONFIG =AutoConfig.getConfigHolder(ConfigHandler.class).getConfig();
        ModBlocks.registerBlocks(Registry.BLOCK);
        ModItems.registerItems(Registry.ITEM);
        FuelRegistry.INSTANCE.add(ModItems.DWARF_COAL, CONFIG.dwarfCoalBurnTime);
        FuelRegistry.INSTANCE.add(ModItems.DWARF_CHARCOAL, CONFIG.dwarfCoalBurnTime);
        FuelRegistry.INSTANCE.add(ModItems.CHARCOAL_BLOCK_ITEM, CONFIG.charcoalBlockBurnTime);
    }
}
