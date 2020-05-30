package mod.akkamaddi.haditecoal.generation;

import mod.akkamaddi.haditecoal.config.HaditeConfig;
import mod.akkamaddi.haditecoal.init.ModBlocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Ore generation masterclass for HaditeCoal.
 * @author Sinhika
 *
 */
public class OreGeneration
{
    /**
     * called in setup to generate Nether ores.
     */
    public static void setupNetherOreGen()
    {
        for (Biome biome: ForgeRegistries.BIOMES.getValues())
        {
            // Nether Ore generation.
            if (biome.getCategory() != Biome.Category.NETHER) continue;
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE,
					new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK,
							ModBlocks.hadite_coal_ore.get().getDefaultState(), HaditeConfig.hadite_veinsize),
					Placement.COUNT_RANGE, HaditeConfig.hadite_cfg));

        } // end-for biome
    } // end setupNetherOreGen()
    
} // end-class
