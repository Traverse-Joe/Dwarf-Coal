package sora.dwarfcoal.init;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigHandler {

  public static class General{
    public final ForgeConfigSpec.ConfigValue<Integer> burnTime;

    General(ForgeConfigSpec.Builder builder){
      builder.push("General");
      burnTime = builder
          .comment("Dwarf Coal Burn Time")
          .define("burnTime", 200);
      builder.pop();
    }
  }
  private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
  public static final General general = new General(BUILDER);
  public static final ForgeConfigSpec configSpec = BUILDER.build();
}
