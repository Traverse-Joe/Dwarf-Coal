package sora.dwarfcoal.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import sora.dwarfcoal.DwarfCoal;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

@Mod.EventBusSubscriber(bus = MOD ,modid = DwarfCoal.MODID)
public class ModEvents {

  @SubscribeEvent
  public static void onBlockRegistry(RegistryEvent.Register<Block> event) {
    event.getRegistry().register(ModBlocks.CHARCOAL_BLOCK);
    event.getRegistry().register(ModBlocks.DWARF_TORCH);
    event.getRegistry().register(ModBlocks.DWARF_WALL_TORCH);
  }

  @SubscribeEvent
  public static void registerItems(RegistryEvent.Register<Item> event) {
    event.getRegistry().register(ModItems.DWARF_COAL);
    event.getRegistry().register(ModItems.DWARF_TORCH);
    event.getRegistry().register(ModItems.DWARF_CHARCOAL);
    event.getRegistry().register(ModItems.CHARCOAL_BLOCK);
  }
}
