package mod.akkamaddi.haditecoal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.akkamaddi.haditecoal.config.ConfigHolder;
import mod.akkamaddi.haditecoal.init.ModBlocks;
import mod.akkamaddi.haditecoal.init.ModFeatures;
import mod.akkamaddi.haditecoal.init.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(HaditeCoal.MODID)
public class HaditeCoal
{
    public static final String MODID = "haditecoal";
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    
    
    public HaditeCoal()
    {
        LOGGER.debug("Hello from akkamaddi's Hadite Coal!");
        final ModLoadingContext modLoadingContext = ModLoadingContext.get();
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModFeatures.CONFIGURED_FEATURES.register(modEventBus);
        ModFeatures.PLACED_FEATURES.register(modEventBus);
        
        // Register Configs
        modLoadingContext.registerConfig(ModConfig.Type.COMMON, ConfigHolder.SERVER_SPEC);
        modLoadingContext.registerConfig(ModConfig.Type.CLIENT, ConfigHolder.CLIENT_SPEC);
    } // end ctor()

} // end class
