package mod.akkamaddi.haditecoal.generation;

import java.util.List;

import mod.akkamaddi.haditecoal.config.HaditeConfig;
import mod.akkamaddi.haditecoal.init.ModBlocks;
import mod.alexndr.simplecorelib.world.OreGenUtils;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

/**
 * Ore generation masterclass for HaditeCoal.
 * @author Sinhika
 *
 */
public class OreGeneration
{
    public static final List<OreConfiguration.TargetBlockState> ORE_HADITE_TARGET = 
            OreGenUtils.BuildNetherOreTargetList(ModBlocks.hadite_coal_ore.get(), true);
    
    public static ConfiguredFeature<OreConfiguration, ?> ORE_HADITE_COAL;
    public static PlacedFeature HADITE_DEPOSIT;
    
     /**
     * initialize nether Features.
     * 
     * @param evt
     */
    public static void initNetherFeatures()
    {
        ORE_HADITE_COAL = FeatureUtils.register("ore_hadite_coal", 
                OreGenUtils.ConfigureOreFeature(ORE_HADITE_TARGET, HaditeConfig.hadite_cfg.getVein_size(), 0.0F)); 
        HADITE_DEPOSIT = PlacementUtils.register("hadite_deposit", 
                OreGenUtils.ConfigurePlacedFeature(HaditeConfig.hadite_cfg, ORE_HADITE_COAL));
    } // end-initNetherFeatures()

    /** 
     * generate nether ores.
     */
    public static void generateNetherOres(BiomeLoadingEvent evt)
    {
        evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.HADITE_DEPOSIT);
    } // end generateNetherOres()
    
} // end-class
