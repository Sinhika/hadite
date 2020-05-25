package mod.akkamaddi.hadite.config;

import mod.akkamaddi.hadite.HaditeCoal;
import net.minecraftforge.common.ForgeConfigSpec;

public final class ClientConfig
{
    final ForgeConfigSpec.BooleanValue clientMakeOreFlame;
    final ForgeConfigSpec.BooleanValue clientMakeBlockFlame;
    
    ClientConfig(final ForgeConfigSpec.Builder builder) 
    {
        builder.push("General");
        clientMakeOreFlame = builder.comment("Hadite Ore spits fire")
                .translation(HaditeCoal.MODID + "config.MakeOreFlame")
                .define("MakeOreFlame", true);
        clientMakeBlockFlame = builder.comment("Hadite Block emits flames")
                .translation(HaditeCoal.MODID + "config.MakeBlockFlame")
                .define("MakeBlockFlame", true);
        builder.pop();
    }
} // end-class

