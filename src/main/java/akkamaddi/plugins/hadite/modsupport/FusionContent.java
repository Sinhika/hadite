package akkamaddi.plugins.hadite.modsupport;

import akkamaddi.plugins.hadite.ModItems;
import alexndr.plugins.Fusion.FusionFurnaceRecipes;
import alexndr.plugins.Fusion.FusionMaterial;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class FusionContent 
{
    public static void addFusionRecipes()
    {
        // Fusion Furnace recipes
        FusionFurnaceRecipes.addSmelting(
                FusionMaterial.of(new ItemStack(Items.FLINT)),
                FusionMaterial.of(new ItemStack(ModItems.haditeCoalIngot)),
                FusionMaterial.of(new ItemStack(Items.COAL, 1, OreDictionary.WILDCARD_VALUE)),
                new ItemStack(Items.GUNPOWDER), 6.0F);
        
        // alloys
        FusionFurnaceRecipes.addSmelting(
                FusionMaterial.of(new ItemStack(Items.IRON_INGOT)),
                FusionMaterial.of(new ItemStack(ModItems.haditeCoalIngot)),
                FusionMaterial.of(new ItemStack(Items.GUNPOWDER)),
                new ItemStack(ModItems.largeHaditeSteelChunkItem), 6.0F);
        
        if (OreDictionary.doesOreNameExist("ingotTin"))
        {
        	FusionFurnaceRecipes
        	.addSmelting(
        			FusionMaterial.of("ingotTin"),
        			FusionMaterial.of(new ItemStack(ModItems.haditeCoalIngot)),
        			FusionMaterial.of(new ItemStack(Items.COAL, 1, OreDictionary.WILDCARD_VALUE)),
        			new ItemStack(ModItems.largeGestankenzinnChunkItem), 5.0F);
        }
    } // end addFusionFurnaceRecipes
    
    public static void addRecyclingRecipes()
    {
        // Hadite Steel
        FusionFurnaceRecipes.addSmelting(
                new ItemStack(ModItems.haditeSteelSword, 1,
                        OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.GRAVEL),
                new ItemStack(Items.COAL, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(ModItems.largeHaditeSteelChunkItem),
                15.0F);
        FusionFurnaceRecipes.addSmelting(
                new ItemStack(ModItems.haditeSteelShovel, 1,
                		OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.GRAVEL),
                new ItemStack(Items.COAL, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(ModItems.largeHaditeSteelChunkItem),
                15.0F);
        FusionFurnaceRecipes.addSmelting(
                new ItemStack(ModItems.haditeSteelAxe, 1,
                		OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.GRAVEL),
                new ItemStack(Items.COAL, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(ModItems.largeHaditeSteelChunkItem),
                15.0F);
        FusionFurnaceRecipes.addSmelting(
                new ItemStack(ModItems.haditeSteelPickaxe, 1,
                		OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.GRAVEL),
                new ItemStack(Items.COAL, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(ModItems.largeHaditeSteelChunkItem),
                15.0F);
        
        // Gestankenzinn
        FusionFurnaceRecipes.addSmelting(
                new ItemStack(ModItems.gestankenzinnSword, 1,
                		OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.GRAVEL),
                new ItemStack(Items.COAL, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(ModItems.largeGestankenzinnChunkItem),
                20.0F);
        FusionFurnaceRecipes.addSmelting(
                new ItemStack(ModItems.gestankenzinnShovel, 1,
                		OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.GRAVEL),
                new ItemStack(Items.COAL, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(ModItems.largeGestankenzinnChunkItem),
                20.0F);
        FusionFurnaceRecipes.addSmelting(
                new ItemStack(ModItems.gestankenzinnAxe, 1,
                		OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.GRAVEL),
                new ItemStack(Items.COAL, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(ModItems.largeGestankenzinnChunkItem),
                20.0F);
        FusionFurnaceRecipes.addSmelting(
                new ItemStack(ModItems.gestankenzinnPickaxe, 1,
                		OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.GRAVEL),
                new ItemStack(Items.COAL, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(ModItems.largeGestankenzinnChunkItem),
                20.0F);
        
    } // end addRecyclingRecipes
} // end class
