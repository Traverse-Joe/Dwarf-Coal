package sora.dwarfcoal;

import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import sora.dwarfcoal.proxy.ClientProxy;
import sora.dwarfcoal.proxy.CommonProxy;
import sora.dwarfcoal.proxy.IProxy;

@Mod(DwarfCoal.MODID)
public class DwarfCoal {

  private static DwarfCoal instance;
  private static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new CommonProxy());
  public static final String MODID = "dwarfcoal";
  public static final String MODNAME = "Dwarf Coal";

  public static DwarfCoal getInstance(){
    return instance;
  }

  public static IProxy getProxy() {
    return proxy;
  }

}
