package mod.akkamaddi.haditecoal.generation;

import mod.akkamaddi.haditecoal.config.HaditeConfig;
import mod.akkamaddi.haditecoal.init.ModBlocks;
import mod.alexndr.simplecorelib.world.OreGenUtils;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

/**
 * Ore generation masterclass for HaditeCoal.
 * @author Sinhika
 *
 */
public class OreGeneration
{
    protected static ConfiguredFeature<?, ?> ORE_HADITE_COAL;

    /**
     * Do we care about this biome? Yes, if nether, no otherwise. Also
     * init relevant Features, if they are null.
     */
    public static boolean checkAndInitBiome(BiomeLoadingEvent evt)
    {
        if (evt.getCategory() == Biome.Category.NETHER)
        {
            initNetherFeatures();
            return true;
        }
        return false;
    } // end checkBiome

    /**
     * initialize nether Features.
     * 
     * @param evt
     */
    protected static void initNetherFeatures()
    {
        if (ORE_HADITE_COAL != null) return;
        
        ORE_HADITE_COAL = 
                OreGenUtils.buildNetherOreFeature(ModBlocks.hadite_coal_ore.get().getDefaultState(),
                HaditeConfig.hadite_cfg);
    } // end-initNetherFeatures()

    /** 
     * generate nether ores.
     */
    public static void generateNetherOres(BiomeLoadingEvent evt)
    {
        evt.getGeneration().withFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.ORE_HADITE_COAL);
    } // end generateNetherOres()
    
} // end-class
