package com.traverse.dwarfcoal.config;

import com.traverse.dwarfcoal.DwarfCoal;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = DwarfCoal.MODID)
public class ConfigHandler implements ConfigData {
    @Comment("Dwarf Coal BurnTime")
    public int dwarfCoalBurnTime = 200;

    @Comment("Charcoal Block BurnTime")
    public int charcoalBlockBurnTime = 1600;

    @Comment("Dwarf Torch Light Level")
    public int lightLevel = 10;
}
