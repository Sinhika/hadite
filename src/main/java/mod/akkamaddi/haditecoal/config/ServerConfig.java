package mod.akkamaddi.haditecoal.config;

import mod.akkamaddi.haditecoal.HaditeCoal;
import net.minecraftforge.common.ForgeConfigSpec;

public final class ServerConfig
{
    final ForgeConfigSpec.BooleanValue serverEnableRecycling; // recipe flag
    final ForgeConfigSpec.BooleanValue serverEnableGestankenzinnMaking; // recipe flag
    final ForgeConfigSpec.BooleanValue serverEnableGestankenzinnArmor; // recipe flag
    final ForgeConfigSpec.BooleanValue serverEnableGestankenzinnTools; // recipe flag
    
    final ForgeConfigSpec.BooleanValue serverEnableHaditeSteelMaking; // recipe flag
    final ForgeConfigSpec.BooleanValue serverEnableHaditeSteelArmor; // recipe flag
    final ForgeConfigSpec.BooleanValue serverEnableHaditeSteelTools; // recipe flag
    
    final ForgeConfigSpec.IntValue serverHaditeCoalBurnTime;
    final ForgeConfigSpec.BooleanValue serverHaditeCoalBlockFireSource;
    
    // ore generation
    final ForgeConfigSpec.IntValue serverHaditeCoalVeinSize;
    final ForgeConfigSpec.IntValue serverHaditeCoalVeinCount;
    final ForgeConfigSpec.IntValue serverHaditeCoalBottomHeight;
    final ForgeConfigSpec.IntValue serverHaditeCoalMaxHeight;

    
    ServerConfig(final ForgeConfigSpec.Builder builder)
    {
        builder.push("General");
        serverEnableRecycling = 
                builder.comment("Enable fusion furnace recycling of hadite and onyx items")
                .translation(HaditeCoal.MODID + "config.EnableRecycling")
                .define("EnableRecycling", true);
        serverHaditeCoalBurnTime = 
                builder.comment("How long hadite coal burns as furnace fuel (Coal = 1600)")
                .translation(HaditeCoal.MODID + "config.HaditeCoalBurnTime")
                .defineInRange("HaditeCoalBurnTime", 13000, 0, Integer.MAX_VALUE);
        serverHaditeCoalBlockFireSource =
                builder.comment("Can use hadite coal block as a permanent fire source, like netherrack")
                .translation(HaditeCoal.MODID + "config.HaditeCoalBlockFireSource")
                .define("HaditeCoalBlockFireSource", true);
        builder.pop();
        
        builder.push("Ore Generation");
        serverHaditeCoalVeinSize = builder.comment("Hadite Coal ore vein size")
                .translation(HaditeCoal.MODID + "config.HaditeCoalVeinSize")
                .defineInRange("HaditeCoalVeinSize",  17, 0, Integer.MAX_VALUE);
        serverHaditeCoalVeinCount = builder.comment("Hadite Coal ore vein count per chunk")
                .translation(HaditeCoal.MODID + "config.HaditeCoalVeinCount")
                .defineInRange("HaditeCoalVeinCount",  9, 0, Integer.MAX_VALUE);
        serverHaditeCoalBottomHeight = builder
                .comment("HaditeCoal ore minimum height")
                .translation(HaditeCoal.MODID + ".config.serverHaditeCoalBottomHeight")
                .defineInRange("HaditeCoalBottomHeight", 0, 1, 127);
        serverHaditeCoalMaxHeight = builder
                .comment("HaditeCoal ore maximum height")
                .translation(HaditeCoal.MODID + ".config.serverHaditeCoalMaxHeight")
                .defineInRange("HaditeCoalMaxHeight", 128, 1, 128);
        builder.pop();
        
        builder.push("Gestankenzinn");
        serverEnableGestankenzinnMaking = 
                builder.comment("Enable making Gestankenzinn alloy in fusion furnace")
                .translation(HaditeCoal.MODID + "config.EnableGestankenzinnMaking")
                .define("EnableGestankenzinnMaking", true);
        serverEnableGestankenzinnArmor = builder.comment("Enable making Gestankenzinn armor")
                .translation(HaditeCoal.MODID + "config.EnableGestankenzinnArmor")
                .define("EnableGestankenzinnArmor", true);
        serverEnableGestankenzinnTools = builder.comment("Enable making Gestankenzinn tools")
                .translation(HaditeCoal.MODID + "config.EnableGestankenzinnTools")
                .define("EnableGestankenzinnTools", true);
        builder.pop();
        
        builder.push("Hadite Steel");
        serverEnableHaditeSteelMaking = 
                builder.comment("Enable making Hadite Steel alloy in fusion furnace")
                .translation(HaditeCoal.MODID + "config.EnableHaditeSteelMaking")
                .define("EnableHaditeSteelMaking", true);
        serverEnableHaditeSteelArmor = builder.comment("Enable making Hadite Steel armor")
                .translation(HaditeCoal.MODID + "config.EnableHaditeSteelArmor")
                .define("EnableHaditeSteelArmor", true);
        serverEnableHaditeSteelTools = builder.comment("Enable making Hadite Steel tools")
                .translation(HaditeCoal.MODID + "config.EnableHaditeSteelTools")
                .define("EnableHaditeSteelTools", true);
        builder.pop();
    } // end ctor

} // end-class
