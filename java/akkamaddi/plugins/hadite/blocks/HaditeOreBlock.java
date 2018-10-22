package akkamaddi.plugins.hadite.blocks;

import java.util.Random;

import akkamaddi.plugins.hadite.HaditeCoal;
import akkamaddi.plugins.hadite.ModItems;
import akkamaddi.plugins.hadite.Settings;
import alexndr.api.content.blocks.SimpleBlock;
import alexndr.api.registry.ContentCategories;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class HaditeOreBlock extends SimpleBlock
{
    /**
     * The main constructor for the blocks.
     *
     * @param par1 = ID of the block.
     * @param material = The material of the block. This sets what tools are effective against it, the sounds it makes, etc.
     */
    public HaditeOreBlock(String name, Material material)
    {
        super(name, HaditeCoal.plugin, material, ContentCategories.Block.ORE);
    }

 
    /* (non-Javadoc)
	 * @see alexndr.api.content.blocks.SimpleBlock#getItemDropped(net.minecraft.block.state.IBlockState, java.util.Random, int)
	 */
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) 
	{
		return ModItems.haditeCoalIngot;
	}


	/**
     * Sets whether or not Silk Touch has an effect on this block. Returns true so that Onyx Ore will drop itself rather than the gem item.
     */
    @Override
    protected boolean canSilkHarvest()
    {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random)
    {
        if (Settings.MakeOreFlame == true)
        {
            float f1 = (float)x - 0.5F;
            float f2 = (float)y - 0.5F;
            float f3 = (float)z - 0.5F;
            float f4 = random.nextFloat() * 2.0f;
            float f5 = random.nextFloat() * 2.0f;
            float f6 = random.nextFloat() * 2.0f;
            world.spawnParticle(EnumParticleTypes.LAVA, (double)(f1 + f4), (double)(f2 + f5) , (double)(f3 + f6), 0.0D, 0.0D, 0.0D);
        }
        else
        {
            return;
        }
    }
}
