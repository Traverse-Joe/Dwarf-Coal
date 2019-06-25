package sora.dwarfcoal;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sora.dwarfcoal.init.ConfigDwarfCoal;
import sora.dwarfcoal.proxy.ClientProxy;
import sora.dwarfcoal.proxy.CommonProxy;
import sora.dwarfcoal.proxy.IProxy;

import java.io.File;

@Mod(DwarfCoal.MODID)
public class DwarfCoal {

  private static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new CommonProxy());
  public static final String MODID = "dwarfcoal";
  public static final Logger LOGGER = LogManager.getLogger();
  public static File CONFIG_DIR = new File(FMLPaths.CONFIGDIR.get().toFile(), MODID);

  public DwarfCoal(){
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigDwarfCoal.configSpec);
    MinecraftForge.EVENT_BUS.register(this);
  }

  private void setup(final FMLCommonSetupEvent event) {
    if (!CONFIG_DIR.exists() && !CONFIG_DIR.mkdir()) {
      LOGGER.warn("Impossible to create the config folder");
    }
  }

  public static IProxy getProxy() {
    return proxy;
  }

}
