package akkamaddi.plugins.hadite.blocks;

import java.util.Random;

import akkamaddi.plugins.hadite.HaditeCoal;
import akkamaddi.plugins.hadite.Settings;
import alexndr.api.content.blocks.SimpleBlock;
import alexndr.api.registry.ContentCategories;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class HaditeStorageBlock extends SimpleBlock
{
    /**
     * The main constructor for the blocks.
     *
     * @param par1 = ID of the block.
     * @param material = The material of the block. This sets what tools are effective against it, the sounds it makes, etc.
     */
    public HaditeStorageBlock(String name, Material material)
    {
        super(name, HaditeCoal.plugin, material, ContentCategories.Block.GENERAL);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World world, BlockPos pos, Random random)
    {
        super.randomDisplayTick(stateIn, world, pos, random);

        if (random.nextInt(5) == 0)
        {
        	if (Settings.MakeBlockFlame == true)
        	{
        		double f1 = (double) pos.getX() - 0.5F;
        		double f2 = (double) pos.getY() - 0.5F;
        		double f3 = (double) pos.getZ() - 0.5F;
        		double f4 = random.nextDouble() * 2.0f;
        		double f5 = random.nextDouble() * 2.0f;
        		double f6 = random.nextDouble() * 2.0f;
        		world.spawnParticle(EnumParticleTypes.FLAME, (double)(f1 + f4), (double)(f2 + f5) , (double)(f3 + f6), 0.0D, 0.0D, 0.0D);
        	}
        }
    } // end randomDisplayTick()
} // end class
