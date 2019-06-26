package sora.dwarfcoal;

import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sora.dwarfcoal.proxy.ClientProxy;
import sora.dwarfcoal.proxy.CommonProxy;
import sora.dwarfcoal.proxy.IProxy;

@Mod(DwarfCoal.MODID)
public class DwarfCoal {

  public DwarfCoal instance;
  private static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new CommonProxy());
  public static final String MODID = "dwarfcoal";
  public static final Logger LOGGER = LogManager.getLogger();

  public DwarfCoal getInstance() {
    return instance;
  }

  public static IProxy getProxy() {
    return proxy;
  }

}
