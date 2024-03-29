package mod.akkamaddi.haditecoal.config;

import mod.akkamaddi.haditecoal.HaditeCoal;
import net.minecraftforge.common.ForgeConfigSpec;

public final class ServerConfig
{
    // general
    final ForgeConfigSpec.BooleanValue serverAddChestLoot;
    
    final ForgeConfigSpec.BooleanValue serverEnableRecycling; // recipe flag
    final ForgeConfigSpec.BooleanValue serverEnableGestankenzinnMaking; // recipe flag
    final ForgeConfigSpec.BooleanValue serverEnableGestankenzinnTools; // recipe flag
    
    final ForgeConfigSpec.BooleanValue serverEnableHaditeSteelMaking; // recipe flag
    final ForgeConfigSpec.BooleanValue serverEnableHaditeSteelTools; // recipe flag
    
    final ForgeConfigSpec.IntValue serverHaditeCoalBurnTime;
    final ForgeConfigSpec.BooleanValue serverHaditeCoalBlockFireSource;
    
    
    ServerConfig(final ForgeConfigSpec.Builder builder)
    {
        builder.push("General");
        serverAddChestLoot = builder.comment("Allow Hadite Coal loot to be added to chests?")
                .translation(HaditeCoal.MODID + ".config.addChestLoot")
                .define("AddChestLoot", true);
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
        
        builder.push("Gestankenzinn");
        serverEnableGestankenzinnMaking = 
                builder.comment("Enable making Gestankenzinn alloy in fusion furnace")
                .translation(HaditeCoal.MODID + "config.EnableGestankenzinnMaking")
                .define("EnableGestankenzinnMaking", true);
        serverEnableGestankenzinnTools = builder.comment("Enable making Gestankenzinn tools")
                .translation(HaditeCoal.MODID + "config.EnableGestankenzinnTools")
                .define("EnableGestankenzinnTools", true);
        builder.pop();
        
        builder.push("Hadite Steel");
        serverEnableHaditeSteelMaking = 
                builder.comment("Enable making Hadite Steel alloy in fusion furnace")
                .translation(HaditeCoal.MODID + "config.EnableHaditeSteelMaking")
                .define("EnableHaditeSteelMaking", true);
        serverEnableHaditeSteelTools = builder.comment("Enable making Hadite Steel tools")
                .translation(HaditeCoal.MODID + "config.EnableHaditeSteelTools")
                .define("EnableHaditeSteelTools", true);
        builder.pop();
    } // end ctor

} // end-class
