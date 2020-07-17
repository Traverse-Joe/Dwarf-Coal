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
import sora.dwarfcoal.init.ConfigHandler;
import sora.dwarfcoal.proxy.ClientProxy;
import sora.dwarfcoal.proxy.CommonProxy;
import sora.dwarfcoal.proxy.IProxy;

import java.io.File;

@Mod(DwarfCoal.MODID)
public class DwarfCoal {

  public DwarfCoal instance;
  private static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new CommonProxy());
  public static final String MODID = "dwarfcoal";


  public DwarfCoal(){
    ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ConfigHandler.configSpec);
    MinecraftForge.EVENT_BUS.register(this);
  }
  public DwarfCoal getInstance() {
    return instance;
  }

  public static IProxy getProxy() {
    return proxy;
  }

}
