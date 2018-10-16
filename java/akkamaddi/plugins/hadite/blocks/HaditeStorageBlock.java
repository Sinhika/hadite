package akkamaddi.plugins.hadite.blocks;

import java.util.Random;

import akkamaddi.plugins.hadite.Settings;
import alexndr.api.content.blocks.SimpleBlock;

import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class HaditeStorageBlock extends SimpleBlock
{
    /**
     * The main constructor for the blocks.
     *
     * @param par1 = ID of the block.
     * @param material = The material of the block. This sets what tools are effective against it, the sounds it makes, etc.
     */
    public HaditeStorageBlock(Material material, String mod)
    {
        super(material);
        modId(mod);
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random)
    {
        if (Settings.MakeBlockFlame == true)
        {
            float f1 = (float)x - 0.5F;
            float f2 = (float)y - 0.5F;
            float f3 = (float)z - 0.5F;
            float f4 = random.nextFloat() * 2.0f;
            float f5 = random.nextFloat() * 2.0f;
            float f6 = random.nextFloat() * 2.0f;
            world.spawnParticle("flame", (double)(f1 + f4), (double)(f2 + f5) , (double)(f3 + f6), 0.0D, 0.0D, 0.0D);
        }
        else
        {
            return;
        }
    }
}
