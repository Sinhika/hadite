package akkamaddi.plugins.hadite;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import alexndr.api.core.LogHelper;
import alexndr.plugins.Fusion.FusionFurnaceRecipes;
import alexndr.plugins.Fusion.FusionMaterial;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes 
{
    // wildcard
    private final static int WILDCARD_VALUE = OreDictionary.WILDCARD_VALUE;

    public static void preInitialize()
    {
        try {
            addOreDictEntries();
            LogHelper.verboseInfo(ModInfo.ID,
                    "All OreDictionary entries were added successfully.");
        } 
        catch (Exception e) {
            LogHelper.severe(ModInfo.ID,
             "OreDictionary entries were not added successfully. This is a serious problem!");
            e.printStackTrace();
        }
    } // end preInitialize()

    public static void initialize()
    {
        try {
            addRecipes();
            addFurnaceRecipes();
            addFusionFurnaceRecipes();
            if (Settings.enableRecycling)
            {
                addRecyclingRecipes();
            } // end if recycling
            LogHelper.verboseInfo(ModInfo.ID,
                    "All recipes were added successfully.");
        } catch (Exception e) {
            LogHelper.severe(ModInfo.ID,
                            "Recipes were not added successfully. This is a serious problem!");
            e.printStackTrace();
        }
    } // end initialize()
    
    public static void addOreDictEntries()
    {
        // Ore Dictionary registry
        OreDictionary.registerOre("haditeCoal", new ItemStack(
                Content.haditeCoalIngot));
        OreDictionary.registerOre("oreHaditeCoal", new ItemStack(
                Content.blockHaditeCoalOre));
        OreDictionary.registerOre("ingotHaditeSteel", new ItemStack(
                Content.haditeSteelIngot));
        OreDictionary.registerOre("ingotGestankenzinn", new ItemStack(
                Content.gestankenzinnIngot));
     } // end addOreDictEntries()
    
    @SuppressWarnings("unchecked")
    private static void addRecipes()
    {
        // Storage Block
        GameRegistry.addRecipe(new ItemStack(
                Content.blockHaditeCoalBlock, 1), new Object[] { "AAA",
                "AAA", "AAA", 'A', Content.haditeCoalIngot });
        GameRegistry.addRecipe(
                new ItemStack(Content.blockHaditeSteel, 1),
                new Object[] { "AAA", "AAA", "AAA", 'A',
                        Content.haditeSteelIngot });
        GameRegistry.addRecipe(new ItemStack(Content.blockGestankenzinn,
                1), new Object[] { "AAA", "AAA", "AAA", 'A',
                Content.gestankenzinnIngot });
        
        // Item Recipe
        // Ingot Recipe
        GameRegistry.addShapelessRecipe(new ItemStack(
                Content.haditeCoalIngot, 9),
                new Object[] { Content.blockHaditeCoalBlock });
        GameRegistry.addShapelessRecipe(new ItemStack(
                Content.haditeSteelIngot, 9),
                new Object[] { Content.blockHaditeSteel });
        GameRegistry.addShapelessRecipe(new ItemStack(
                Content.gestankenzinnIngot, 9),
                new Object[] { Content.blockGestankenzinn });
        
        // Hadite Steel Tools
        CraftingManager
                .getInstance()
                .getRecipeList()
                .add(new ShapedOreRecipe(Content.haditeSteelPickaxe,
                        true, new Object[] { "XXX", " Y ", " Y ", 'X',
                                "ingotHaditeSteel", 'Y', "stickWood" }));
        CraftingManager
                .getInstance()
                .getRecipeList()
                .add(new ShapedOreRecipe(Content.haditeSteelAxe, true,
                        new Object[] { "XX ", "XY ", " Y ", 'X',
                                "ingotHaditeSteel", 'Y', "stickWood" }));
        CraftingManager
                .getInstance()
                .getRecipeList()
                .add(new ShapedOreRecipe(Content.haditeSteelShovel,
                        true, new Object[] { "X", "Y", "Y", 'X',
                                "ingotHaditeSteel", 'Y', "stickWood" }));
        CraftingManager
                .getInstance()
                .getRecipeList()
                .add(new ShapedOreRecipe(Content.haditeSteelSword, true,
                        new Object[] { "X", "X", "Y", 'X', "ingotHaditeSteel",
                                'Y', "stickWood" }));
        // Gestankenzinn Tools
        CraftingManager
                .getInstance()
                .getRecipeList()
                .add(new ShapedOreRecipe(Content.gestankenzinnPickaxe,
                        true, new Object[] { "XXX", " Y ", " Y ", 'X',
                                "ingotGestankenzinn", 'Y', "stickWood" }));
        CraftingManager
                .getInstance()
                .getRecipeList()
                .add(new ShapedOreRecipe(Content.gestankenzinnAxe, true,
                        new Object[] { "XX ", "XY ", " Y ", 'X',
                                "ingotGestankenzinn", 'Y', "stickWood" }));
        CraftingManager
                .getInstance()
                .getRecipeList()
                .add(new ShapedOreRecipe(Content.gestankenzinnShovel,
                        true, new Object[] { "X", "Y", "Y", 'X',
                                "ingotGestankenzinn", 'Y', "stickWood" }));
        CraftingManager
                .getInstance()
                .getRecipeList()
                .add(new ShapedOreRecipe(Content.gestankenzinnSword,
                        true, new Object[] { "X", "X", "Y", 'X',
                                "ingotGestankenzinn", 'Y', "stickWood" }));
        // torches
        CraftingManager
                .getInstance()
                .getRecipeList()
                .add(new ShapedOreRecipe(new ItemStack(Blocks.torch, 64),
                        true, new Object[] { "YYY", "YXY", "YYY", 'X',
                                "haditeCoal", 'Y', "stickWood" }));
    } // end addRecipes
    
   private static void addFurnaceRecipes()
   {
       // recipes: Smelting
       GameRegistry.addSmelting(
               Content.largeHaditeSteelChunkItem, new ItemStack(
                       Content.haditeSteelIngot), 4.0F);
       GameRegistry.addSmelting(
               Content.largeGestankenzinnChunkItem,
               new ItemStack(Content.gestankenzinnIngot), 3.0F);
       
   } // end addFurnaceRecipes
   
   private static void addFusionFurnaceRecipes()
   {
       // Fusion Furnace recipes
       FusionFurnaceRecipes.addSmelting(
               FusionMaterial.of(new ItemStack(Items.flint)),
               FusionMaterial.of(new ItemStack(Content.haditeCoalIngot)),
               FusionMaterial.of(new ItemStack(Items.coal, 1, WILDCARD_VALUE)),
               new ItemStack(Items.gunpowder), 6.0F);
       
       // alloys
       FusionFurnaceRecipes.addSmelting(
               FusionMaterial.of(new ItemStack(Items.iron_ingot)),
               FusionMaterial.of(new ItemStack(Content.haditeCoalIngot)),
               FusionMaterial.of(new ItemStack(Items.gunpowder)),
               new ItemStack(Content.largeHaditeSteelChunkItem), 6.0F);
       FusionFurnaceRecipes
               .addSmelting(
                       FusionMaterial.of("ingotTin"),
                       FusionMaterial.of(new ItemStack(Content.haditeCoalIngot)),
                       FusionMaterial.of(new ItemStack(Items.coal, 1, WILDCARD_VALUE)),
                       new ItemStack(
                               Content.largeGestankenzinnChunkItem),
                       5.0F);

   } // end addFusionFurnaceRecipes
   
   private static void addRecyclingRecipes()
   {
       // Hadite Steel
       FusionFurnaceRecipes.addSmelting(
               new ItemStack(Content.haditeSteelSword, 1,
                       WILDCARD_VALUE), new ItemStack(Blocks.gravel),
               new ItemStack(Items.coal, 1, WILDCARD_VALUE),
               new ItemStack(Content.largeHaditeSteelChunkItem),
               15.0F);
       FusionFurnaceRecipes.addSmelting(
               new ItemStack(Content.haditeSteelShovel, 1,
                       WILDCARD_VALUE), new ItemStack(Blocks.gravel),
               new ItemStack(Items.coal, 1, WILDCARD_VALUE),
               new ItemStack(Content.largeHaditeSteelChunkItem),
               15.0F);
       FusionFurnaceRecipes.addSmelting(
               new ItemStack(Content.haditeSteelAxe, 1,
                       WILDCARD_VALUE), new ItemStack(Blocks.gravel),
               new ItemStack(Items.coal, 1, WILDCARD_VALUE),
               new ItemStack(Content.largeHaditeSteelChunkItem),
               15.0F);
       FusionFurnaceRecipes.addSmelting(
               new ItemStack(Content.haditeSteelPickaxe, 1,
                       WILDCARD_VALUE), new ItemStack(Blocks.gravel),
               new ItemStack(Items.coal, 1, WILDCARD_VALUE),
               new ItemStack(Content.largeHaditeSteelChunkItem),
               15.0F);
       // Gestankenzinn
       FusionFurnaceRecipes.addSmelting(
               new ItemStack(Content.gestankenzinnSword, 1,
                       WILDCARD_VALUE), new ItemStack(Blocks.gravel),
               new ItemStack(Items.coal, 1, WILDCARD_VALUE),
               new ItemStack(Content.largeGestankenzinnChunkItem),
               20.0F);
       FusionFurnaceRecipes.addSmelting(
               new ItemStack(Content.gestankenzinnShovel, 1,
                       WILDCARD_VALUE), new ItemStack(Blocks.gravel),
               new ItemStack(Items.coal, 1, WILDCARD_VALUE),
               new ItemStack(Content.largeGestankenzinnChunkItem),
               20.0F);
       FusionFurnaceRecipes.addSmelting(
               new ItemStack(Content.gestankenzinnAxe, 1,
                       WILDCARD_VALUE), new ItemStack(Blocks.gravel),
               new ItemStack(Items.coal, 1, WILDCARD_VALUE),
               new ItemStack(Content.largeGestankenzinnChunkItem),
               20.0F);
       FusionFurnaceRecipes.addSmelting(
               new ItemStack(Content.gestankenzinnPickaxe, 1,
                       WILDCARD_VALUE), new ItemStack(Blocks.gravel),
               new ItemStack(Items.coal, 1, WILDCARD_VALUE),
               new ItemStack(Content.largeGestankenzinnChunkItem),
               20.0F);
       // recycle your Onyx
       FusionFurnaceRecipes.addSmelting(
               new ItemStack(alexndr.plugins.SimpleOres.Content.onyx_helmet, 1,
                       WILDCARD_VALUE), new ItemStack(Blocks.netherrack),
               new ItemStack(Content.haditeCoalIngot),
               new ItemStack(alexndr.plugins.SimpleOres.Content.onyx_ore), 20.0F);
       FusionFurnaceRecipes.addSmelting(
               new ItemStack(alexndr.plugins.SimpleOres.Content.onyx_chestplate, 1,
                       WILDCARD_VALUE),
               new ItemStack(Blocks.netherrack, 2, 0),
               new ItemStack(Content.haditeCoalIngot, 2, 0),
               new ItemStack(alexndr.plugins.SimpleOres.Content.onyx_ore, 2, 0), 40.0F);
       FusionFurnaceRecipes.addSmelting(
               new ItemStack(alexndr.plugins.SimpleOres.Content.onyx_leggings, 1,
                       WILDCARD_VALUE),
               new ItemStack(Blocks.netherrack, 2, 0),
               new ItemStack(Content.haditeCoalIngot, 2, 0),
               new ItemStack(alexndr.plugins.SimpleOres.Content.onyx_ore, 2, 0), 40.0F);
       FusionFurnaceRecipes.addSmelting(
               new ItemStack(alexndr.plugins.SimpleOres.Content.onyx_boots, 1,
                       WILDCARD_VALUE), new ItemStack(Blocks.netherrack),
               new ItemStack(Content.haditeCoalIngot),
               new ItemStack(alexndr.plugins.SimpleOres.Content.onyx_ore), 20.0F);
       FusionFurnaceRecipes.addSmelting(
               new ItemStack(alexndr.plugins.SimpleOres.Content.onyx_sword, 1,
                       WILDCARD_VALUE), new ItemStack(Blocks.netherrack),
               new ItemStack(Content.haditeCoalIngot),
               new ItemStack(alexndr.plugins.SimpleOres.Content.onyx_ore), 20.0F);
       FusionFurnaceRecipes.addSmelting(
               new ItemStack(alexndr.plugins.SimpleOres.Content.onyx_shovel, 1,
                       WILDCARD_VALUE), new ItemStack(Blocks.netherrack),
               new ItemStack(Content.haditeCoalIngot),
               new ItemStack(alexndr.plugins.SimpleOres.Content.onyx_ore), 20.0F);
       FusionFurnaceRecipes.addSmelting(
               new ItemStack(alexndr.plugins.SimpleOres.Content.onyx_pickaxe, 1,
                       WILDCARD_VALUE), new ItemStack(Blocks.netherrack),
               new ItemStack(Content.haditeCoalIngot),
               new ItemStack(alexndr.plugins.SimpleOres.Content.onyx_ore), 20.0F);
       FusionFurnaceRecipes.addSmelting(
               new ItemStack(alexndr.plugins.SimpleOres.Content.onyx_axe, 1,
                       WILDCARD_VALUE), new ItemStack(Blocks.netherrack),
               new ItemStack(Content.haditeCoalIngot),
               new ItemStack(alexndr.plugins.SimpleOres.Content.onyx_ore), 20.0F);
       FusionFurnaceRecipes.addSmelting(
               new ItemStack(alexndr.plugins.SimpleOres.Content.onyx_hoe, 1,
                       WILDCARD_VALUE), new ItemStack(Blocks.netherrack),
               new ItemStack(Content.haditeCoalIngot),
               new ItemStack(alexndr.plugins.SimpleOres.Content.onyx_ore), 20.0F);
       FusionFurnaceRecipes.addSmelting(
               new ItemStack(alexndr.plugins.SimpleOres.Content.onyx_bow, 1,
                       WILDCARD_VALUE), new ItemStack(Blocks.netherrack),
               new ItemStack(Content.haditeCoalIngot),
               new ItemStack(alexndr.plugins.SimpleOres.Content.onyx_ore), 20.0F);
       
       // extra Onyx recycling
       // TODO add back in when we have a check for Aesthetics plug-in.
//       FusionFurnaceRecipes.addSmelting(
//               new ItemStack(alexndr.plugins.Aesthetics.ContentSimpleOres.onyx_door, 1,
//                       WILDCARD_VALUE), new ItemStack(Blocks.netherrack),
//               new ItemStack(Content.haditeCoalIngot),
//               new ItemStack(alexndr.plugins.SimpleOres.Content.onyx_ore), 20.0F);
       FusionFurnaceRecipes.addSmelting(
               new ItemStack(alexndr.plugins.SimpleOres.Content.onyx_rod, 1,
                       WILDCARD_VALUE), new ItemStack(Blocks.netherrack),
               new ItemStack(Content.haditeCoalIngot),
               new ItemStack(alexndr.plugins.SimpleOres.Content.onyx_ore), 20.0F);
       FusionFurnaceRecipes.addSmelting(
               new ItemStack(alexndr.plugins.SimpleOres.Content.onyx_shears, 1,
                       WILDCARD_VALUE), new ItemStack(Blocks.netherrack),
               new ItemStack(Content.haditeCoalIngot),
               new ItemStack(alexndr.plugins.SimpleOres.Content.onyx_ore), 20.0F);
       // TODO comment back in when Alexndr replaces onyx furnaces.
//       FusionFurnaceRecipes.addSmelting(
//               new ItemStack(alexndr.plugins.SimpleOres.Content.onyx_furnace, 1,
//                       WILDCARD_VALUE), new ItemStack(Blocks.netherrack),
//               new ItemStack(Content.haditeCoalIngot),
//               new ItemStack(alexndr.plugins.SimpleOres.Content.onyx_ore, 2, 0), 40.0F);
   } // end addRecyclingRecipes
   
 } // end class Recipes
