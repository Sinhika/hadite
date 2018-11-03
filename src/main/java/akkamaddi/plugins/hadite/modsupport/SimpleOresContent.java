package akkamaddi.plugins.hadite.modsupport;

import akkamaddi.plugins.hadite.Content;
import akkamaddi.plugins.hadite.ModItems;
import alexndr.plugins.Fusion.FusionFurnaceRecipes;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class SimpleOresContent 
{
    public static void addRecyclingRecipes()
    {
        // recycle your Onyx
        if (Content.use_simple_ores && Content.use_fusion)
        {
        	FusionFurnaceRecipes.addSmelting(
        			new ItemStack(alexndr.plugins.SimpleOres.ModItems.onyx_helmet, 1,
        					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.NETHERRACK),
        			new ItemStack(ModItems.haditeCoalIngot),
        			new ItemStack(alexndr.plugins.SimpleOres.ModBlocks.onyx_ore), 20.0F);
        	FusionFurnaceRecipes.addSmelting(
        			new ItemStack(alexndr.plugins.SimpleOres.ModItems.onyx_chestplate, 1,
        					OreDictionary.WILDCARD_VALUE),
        			new ItemStack(Blocks.NETHERRACK, 2, 0),
        			new ItemStack(ModItems.haditeCoalIngot, 2, 0),
        			new ItemStack(alexndr.plugins.SimpleOres.ModBlocks.onyx_ore, 2, 0), 40.0F);
        	FusionFurnaceRecipes.addSmelting(
        			new ItemStack(alexndr.plugins.SimpleOres.ModItems.onyx_leggings, 1,
        					OreDictionary.WILDCARD_VALUE),
        			new ItemStack(Blocks.NETHERRACK, 2, 0),
        			new ItemStack(ModItems.haditeCoalIngot, 2, 0),
        			new ItemStack(alexndr.plugins.SimpleOres.ModBlocks.onyx_ore, 2, 0), 40.0F);
        	FusionFurnaceRecipes.addSmelting(
        			new ItemStack(alexndr.plugins.SimpleOres.ModItems.onyx_boots, 1,
        					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.NETHERRACK),
        			new ItemStack(ModItems.haditeCoalIngot),
        			new ItemStack(alexndr.plugins.SimpleOres.ModBlocks.onyx_ore), 20.0F);
        	FusionFurnaceRecipes.addSmelting(
        			new ItemStack(alexndr.plugins.SimpleOres.ModItems.onyx_sword, 1,
        					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.NETHERRACK),
        			new ItemStack(ModItems.haditeCoalIngot),
        			new ItemStack(alexndr.plugins.SimpleOres.ModBlocks.onyx_ore), 20.0F);
        	FusionFurnaceRecipes.addSmelting(
        			new ItemStack(alexndr.plugins.SimpleOres.ModItems.onyx_shovel, 1,
        					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.NETHERRACK),
        			new ItemStack(ModItems.haditeCoalIngot),
        			new ItemStack(alexndr.plugins.SimpleOres.ModBlocks.onyx_ore), 20.0F);
        	FusionFurnaceRecipes.addSmelting(
        			new ItemStack(alexndr.plugins.SimpleOres.ModItems.onyx_pickaxe, 1,
        					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.NETHERRACK),
        			new ItemStack(ModItems.haditeCoalIngot),
        			new ItemStack(alexndr.plugins.SimpleOres.ModBlocks.onyx_ore), 20.0F);
        	FusionFurnaceRecipes.addSmelting(
        			new ItemStack(alexndr.plugins.SimpleOres.ModItems.onyx_axe, 1,
        					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.NETHERRACK),
        			new ItemStack(ModItems.haditeCoalIngot),
        			new ItemStack(alexndr.plugins.SimpleOres.ModBlocks.onyx_ore), 20.0F);
        	FusionFurnaceRecipes.addSmelting(
        			new ItemStack(alexndr.plugins.SimpleOres.ModItems.onyx_hoe, 1,
        					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.NETHERRACK),
        			new ItemStack(ModItems.haditeCoalIngot),
        			new ItemStack(alexndr.plugins.SimpleOres.ModBlocks.onyx_ore), 20.0F);
        	FusionFurnaceRecipes.addSmelting(
        			new ItemStack(alexndr.plugins.SimpleOres.ModItems.onyx_bow, 1,
        					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.NETHERRACK),
        			new ItemStack(ModItems.haditeCoalIngot),
        			new ItemStack(alexndr.plugins.SimpleOres.ModBlocks.onyx_ore), 20.0F);
        	// extra Onyx recycling
        	FusionFurnaceRecipes.addSmelting(
        			new ItemStack(alexndr.plugins.SimpleOres.ModItems.onyx_rod, 1,
        					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.NETHERRACK),
        			new ItemStack(ModItems.haditeCoalIngot),
        			new ItemStack(alexndr.plugins.SimpleOres.ModBlocks.onyx_ore), 20.0F);
        	FusionFurnaceRecipes.addSmelting(
        			new ItemStack(alexndr.plugins.SimpleOres.ModItems.onyx_shears, 1,
        					OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.NETHERRACK),
        			new ItemStack(ModItems.haditeCoalIngot),
        			new ItemStack(alexndr.plugins.SimpleOres.ModBlocks.onyx_ore), 20.0F);
        } // end onyx recycling
    } // end addRecyclingRecipes()
	
} // end class
