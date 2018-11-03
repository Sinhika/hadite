package akkamaddi.plugins.hadite.modsupport;

import akkamaddi.plugins.hadite.Content;
import akkamaddi.plugins.hadite.ModItems;
import alexndr.plugins.Fusion.FusionFurnaceRecipes;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class MachinesContent 
{
    public static void addRecyclingRecipes()
    {
        if (Content.use_machines && Content.use_simple_ores)
        {
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(alexndr.plugins.machines.ModBlocks.onyx_furnace, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.NETHERRACK), new ItemStack(ModItems.haditeCoalIngot),
					new ItemStack(alexndr.plugins.SimpleOres.ModBlocks.onyx_ore, 2, 0), 40.0F);
        }
    }
} // end class
