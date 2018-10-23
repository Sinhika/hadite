package akkamaddi.plugins.hadite;

import alexndr.api.logger.LogHelper;
import alexndr.plugins.Fusion.FusionFurnaceRecipes;
import alexndr.plugins.Fusion.FusionMaterial;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class Recipes 
{
    // wildcard
    private final static int WILDCARD_VALUE = OreDictionary.WILDCARD_VALUE;

    public static void initialize()
    {
        try {
        //    addRecipes();
            addFurnaceRecipes();
            addFusionFurnaceRecipes();
            if (Settings.enableRecycling)
            {
                addRecyclingRecipes();
            } // end if recycling
            LogHelper.verbose(ModInfo.ID,
                    "All recipes were added successfully.");
        } catch (Exception e) {
            LogHelper.severe(ModInfo.ID,
                            "Recipes were not added successfully. This is a serious problem!");
            e.printStackTrace();
        }
    } // end initialize()
    
//    @SuppressWarnings("unchecked")
//    private static void addRecipes()
//    {
//        // Storage Block
//        GameRegistry.addRecipe(new ItemStack(
//                Content.blockHaditeCoalBlock, 1), new Object[] { "AAA",
//                "AAA", "AAA", 'A', Content.haditeCoalIngot });
//        GameRegistry.addRecipe(
//                new ItemStack(Content.blockHaditeSteel, 1),
//                new Object[] { "AAA", "AAA", "AAA", 'A',
//                        Content.haditeSteelIngot });
//        GameRegistry.addRecipe(new ItemStack(Content.blockGestankenzinn,
//                1), new Object[] { "AAA", "AAA", "AAA", 'A',
//                Content.gestankenzinnIngot });
//        
//        // Item Recipe
//        // Ingot Recipe
//        GameRegistry.addShapelessRecipe(new ItemStack(
//                Content.haditeCoalIngot, 9),
//                new Object[] { Content.blockHaditeCoalBlock });
//        GameRegistry.addShapelessRecipe(new ItemStack(
//                Content.haditeSteelIngot, 9),
//                new Object[] { Content.blockHaditeSteel });
//        GameRegistry.addShapelessRecipe(new ItemStack(
//                Content.gestankenzinnIngot, 9),
//                new Object[] { Content.blockGestankenzinn });
//        
//        // Hadite Steel Tools
//        CraftingManager
//                .getInstance()
//                .getRecipeList()
//                .add(new ShapedOreRecipe(Content.haditeSteelPickaxe,
//                        true, new Object[] { "XXX", " Y ", " Y ", 'X',
//                                "ingotHaditeSteel", 'Y', "stickWood" }));
//        CraftingManager
//                .getInstance()
//                .getRecipeList()
//                .add(new ShapedOreRecipe(Content.haditeSteelAxe, true,
//                        new Object[] { "XX ", "XY ", " Y ", 'X',
//                                "ingotHaditeSteel", 'Y', "stickWood" }));
//        CraftingManager
//                .getInstance()
//                .getRecipeList()
//                .add(new ShapedOreRecipe(Content.haditeSteelShovel,
//                        true, new Object[] { "X", "Y", "Y", 'X',
//                                "ingotHaditeSteel", 'Y', "stickWood" }));
//        CraftingManager
//                .getInstance()
//                .getRecipeList()
//                .add(new ShapedOreRecipe(Content.haditeSteelSword, true,
//                        new Object[] { "X", "X", "Y", 'X', "ingotHaditeSteel",
//                                'Y', "stickWood" }));
//        // Gestankenzinn Tools
//        CraftingManager
//                .getInstance()
//                .getRecipeList()
//                .add(new ShapedOreRecipe(Content.gestankenzinnPickaxe,
//                        true, new Object[] { "XXX", " Y ", " Y ", 'X',
//                                "ingotGestankenzinn", 'Y', "stickWood" }));
//        CraftingManager
//                .getInstance()
//                .getRecipeList()
//                .add(new ShapedOreRecipe(Content.gestankenzinnAxe, true,
//                        new Object[] { "XX ", "XY ", " Y ", 'X',
//                                "ingotGestankenzinn", 'Y', "stickWood" }));
//        CraftingManager
//                .getInstance()
//                .getRecipeList()
//                .add(new ShapedOreRecipe(Content.gestankenzinnShovel,
//                        true, new Object[] { "X", "Y", "Y", 'X',
//                                "ingotGestankenzinn", 'Y', "stickWood" }));
//        CraftingManager
//                .getInstance()
//                .getRecipeList()
//                .add(new ShapedOreRecipe(Content.gestankenzinnSword,
//                        true, new Object[] { "X", "X", "Y", 'X',
//                                "ingotGestankenzinn", 'Y', "stickWood" }));
//        // torches
//        CraftingManager
//                .getInstance()
//                .getRecipeList()
//                .add(new ShapedOreRecipe(new ItemStack(Blocks.torch, 64),
//                        true, new Object[] { "YYY", "YXY", "YYY", 'X',
//                                "haditeCoal", 'Y', "stickWood" }));
//    } // end addRecipes
    
   
 } // end class Recipes
