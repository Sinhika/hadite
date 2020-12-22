package mod.akkamaddi.haditecoal.generation;

import mod.akkamaddi.haditecoal.HaditeCoal;
import mod.akkamaddi.haditecoal.config.HaditeConfig;
import mod.akkamaddi.haditecoal.init.ModBlocks;
import mod.alexndr.simplecorelib.world.OreGenUtils;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

/**
 * Ore generation masterclass for HaditeCoal.
 * @author Sinhika
 *
 */
public class OreGeneration
{
    public static ConfiguredFeature<?, ?> ORE_HADITE_COAL;

     /**
     * initialize nether Features.
     * 
     * @param evt
     */
    public static void initNetherFeatures()
    {
        ORE_HADITE_COAL = OreGenUtils.buildNetherOreFeature(Feature.ORE,
                ModBlocks.hadite_coal_ore.get().getDefaultState(), HaditeConfig.hadite_cfg);
        OreGenUtils.registerFeature(HaditeCoal.MODID, "hadite_coal_vein", ORE_HADITE_COAL);
    } // end-initNetherFeatures()

    /** 
     * generate nether ores.
     */
    public static void generateNetherOres(BiomeLoadingEvent evt)
    {
        evt.getGeneration().withFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.ORE_HADITE_COAL);
    } // end generateNetherOres()
    
} // end-class
