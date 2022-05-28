package mod.akkamaddi.haditecoal.generation;

import mod.akkamaddi.haditecoal.init.ModFeatures;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraftforge.event.world.BiomeLoadingEvent;

/**
 * Ore generation masterclass for HaditeCoal.
 * @author Sinhika
 *
 */
public class OreGeneration
{
    /** 
     * generate nether ores.
     */
    public static void generateNetherOres(BiomeLoadingEvent evt)
    {
        evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, ModFeatures.HADITE_DEPOSIT.getHolder().get());
    } // end generateNetherOres()
    
} // end-class
