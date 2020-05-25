package mod.akkamaddi.hadite.config;

import net.minecraft.world.gen.placement.CountRangeConfig;
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
        HaditeConfig.hadite_veinsize = ConfigHolder.SERVER.serverHaditeCoalVeinSize.get();
        HaditeConfig.hadite_cfg = 
                new CountRangeConfig(ConfigHolder.SERVER.serverHaditeCoalVeinCount.get(),
                        ConfigHolder.SERVER.serverHaditeCoalBottomHeight.get(),
                        0, ConfigHolder.SERVER.serverHaditeCoalMaxHeight.get());

        HaditeConfig.haditeCoalBurnTime = ConfigHolder.SERVER.serverHaditeCoalBurnTime.get();
        HaditeConfig.isHaditeCoalBlockFireSource = ConfigHolder.SERVER.serverHaditeCoalBlockFireSource.get();
        
        // recipe flags.
        HaditeConfig.INSTANCE.putFlag("recycling_enabled", 
                ConfigHolder.SERVER.serverEnableRecycling.get());
        
        HaditeConfig.INSTANCE.putFlag("gestankenzinn_making",
                ConfigHolder.SERVER.serverEnableGestankenzinnMaking.get());
        HaditeConfig.INSTANCE.putFlag("gestankenzinn_armor", 
                ConfigHolder.SERVER.serverEnableGestankenzinnArmor.get());
        HaditeConfig.INSTANCE.putFlag("gestankenzinn_tools", 
                ConfigHolder.SERVER.serverEnableGestankenzinnTools.get());
        
        HaditeConfig.INSTANCE.putFlag("hadite_steel_making", 
                ConfigHolder.SERVER.serverEnableHaditeSteelMaking.get());
        HaditeConfig.INSTANCE.putFlag("hadite_steel_armor",
                ConfigHolder.SERVER.serverEnableHaditeSteelArmor.get());
        HaditeConfig.INSTANCE.putFlag("hadite_steel_tools",
                ConfigHolder.SERVER.serverEnableHaditeSteelTools.get());
    } // end bakeServer
} // end-class
