package mod.akkamaddi.haditecoal.content;

import java.util.Random;

import mod.akkamaddi.haditecoal.config.HaditeConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HaditeOreBlock extends OreBlock
{

    public HaditeOreBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
        if (worldIn.isRemote && HaditeConfig.makeOreFlame)
        {
            super.animateTick(stateIn, worldIn, pos, rand);

            if (rand.nextInt(10) == 0)
            {
                double f1 = (double) pos.getX() - 0.5F;
                double f2 = (double) pos.getY() - 0.5F;
                double f3 = (double) pos.getZ() - 0.5F;
                double f4 = rand.nextDouble() * 2.0f;
                double f5 = rand.nextDouble() * 2.0f;
                double f6 = rand.nextDouble() * 2.0f;
                worldIn.addParticle(ParticleTypes.LAVA, (double) (f1 + f4), (double) (f2 + f5),
                        (double) (f3 + f6), 0.0D, 0.0D, 0.0D);
            }
        }
    } // end animateTick()
    
} // end class.
