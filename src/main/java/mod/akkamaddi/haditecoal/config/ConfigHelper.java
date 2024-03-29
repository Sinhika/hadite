package mod.akkamaddi.haditecoal.config;

import net.minecraftforge.fml.config.ModConfig;

public final class ConfigHelper
{
    public static void bakeClient(final ModConfig config) 
    {
        HaditeConfig.makeOreFlame = ConfigHolder.CLIENT.clientMakeOreFlame.get();
        HaditeConfig.makeBlockFlame = ConfigHolder.CLIENT.clientMakeBlockFlame.get();
    } // end bakeClient

    public static void bakeServer(final ModConfig config) 
    {
        // general stuff
        HaditeConfig.addChestLoot = ConfigHolder.SERVER.serverAddChestLoot.get();
        HaditeConfig.haditeCoalBurnTime = ConfigHolder.SERVER.serverHaditeCoalBurnTime.get();
        HaditeConfig.isHaditeCoalBlockFireSource = ConfigHolder.SERVER.serverHaditeCoalBlockFireSource.get();
        
        // recipe flags.
        HaditeConfig.INSTANCE.putFlag("recycling_enabled", 
                ConfigHolder.SERVER.serverEnableRecycling.get());
        
        HaditeConfig.INSTANCE.putFlag("gestankenzinn_making_enabled",
                ConfigHolder.SERVER.serverEnableGestankenzinnMaking.get());
        HaditeConfig.INSTANCE.putFlag("gestankenzinn_tools_enabled", 
                ConfigHolder.SERVER.serverEnableGestankenzinnTools.get());
        
        HaditeConfig.INSTANCE.putFlag("hadite_steel_making_enabled", 
                ConfigHolder.SERVER.serverEnableHaditeSteelMaking.get());
        HaditeConfig.INSTANCE.putFlag("hadite_steel_tools_enabled",
                ConfigHolder.SERVER.serverEnableHaditeSteelTools.get());
                       
    } // end bakeServer
} // end-class
