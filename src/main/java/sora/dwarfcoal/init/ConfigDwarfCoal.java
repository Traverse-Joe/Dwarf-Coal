package sora.dwarfcoal.init;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;
import sora.dwarfcoal.DwarfCoal;

@Mod.EventBusSubscriber(modid = DwarfCoal.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ConfigDwarfCoal {

  public static class General{
    public final ForgeConfigSpec.ConfigValue<Integer> dwarf_torch_light_value;

    General(ForgeConfigSpec.Builder builder){
      builder.push("General");
      dwarf_torch_light_value = builder
          .comment("set dwarf torch light value [default:10]")
          .defineInRange("dwarf_torch_light_value", 10,0,15);
      builder.pop();
    }
  }
  private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
  public static final General general = new General(BUILDER);
  public static final ForgeConfigSpec configSpec = BUILDER.build();
}
