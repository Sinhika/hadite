/**
 * 
 */
package akkamaddi.plugins.hadite;

import alexndr.api.logger.LogHelper;
import alexndr.plugins.Fusion.FusionFurnaceRecipes;
import alexndr.plugins.Fusion.FusionMaterial;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

/**
 * @author cyhiggin
 *
 */
public class Content
{
	public static ToolMaterial toolHaditeSteel, toolGestankenzinn;
	public static boolean use_simple_ores = false;
	public static boolean use_fusion = false;
	
    /**
     * Loads all the mod content, by calling the methods below.
     */
    public static void preInitialize()
    {
        setToolAndArmorStats();
        try {
            ModItems.configureItems();
            LogHelper.verbose(ModInfo.ID, "All items were added successfully");
        } 
        catch (Exception e) {
            LogHelper.severe(ModInfo.ID,
                            "Items were not added successfully. This is a serious problem!");
            e.printStackTrace();
        }
        try {
            ModBlocks.configureBlocks();
            LogHelper.verbose(ModInfo.ID,
                    "All blocks were added successfully");
        } 
        catch (Exception e) {
            LogHelper.severe(ModInfo.ID,
                            "Blocks were not added successfully. This is a serious problem!");
            e.printStackTrace();
        }
        try {
            ModItems.configureTools();
            LogHelper.verbose(ModInfo.ID,
                    "All tools were added successfully");
        } 
        catch (Exception e) {
            LogHelper.severe(ModInfo.ID,
                            "Tools were not added successfully. This is a serious problem!");
            e.printStackTrace();
        }
    } // end preInitialize()

    /**
     * initialize various mod support values.
     */
    public static void configureModSupport()
    {
    	Content.use_simple_ores = Loader.isModLoaded("simpleores");
    	Content.use_fusion = Loader.isModLoaded("fusion");
    } // end configureModSupport()
    
    /**
     * Sets repair materials for the tools/armor of that type. ie. Copper Ingot to repair copper tools and armor.
     */
    public static void setRepairMaterials()
    {
        toolHaditeSteel.setRepairItem(new ItemStack(ModItems.haditeSteelIngot));
        toolGestankenzinn.setRepairItem(new ItemStack(ModItems.gestankenzinnIngot));
    } // end setRepairMaterials()


    /**
     * Sets the tool and armor stats from the Settings file.
     */
    public static void setToolAndArmorStats() 
    {
        // set tool properties
        // EnumToolMaterial. In form ("NAME", mining level, max uses, speed,
        // damage to entity, enchantability)
        toolHaditeSteel = EnumHelper.addToolMaterial("HADITESTEEL", 
        		Settings.haditeSteelTools.getHarvestLevel(), Settings.haditeSteelTools.getUses(),
        		Settings.haditeSteelTools.getHarvestSpeed(), Settings.haditeSteelTools.getDamageVsEntity(),
        		Settings.haditeSteelTools.getEnchantability());
        toolGestankenzinn = EnumHelper.addToolMaterial("GESTANKENZINN",
        		Settings.gestankenzinnTools.getHarvestLevel(), Settings.gestankenzinnTools.getUses(),
        		Settings.gestankenzinnTools.getHarvestSpeed(), Settings.gestankenzinnTools.getDamageVsEntity(),
        		Settings.gestankenzinnTools.getEnchantability());
    } // end setToolAndArmorStats()
    
    public static void addSmeltingRecipes()
    {
        // recipes: Smelting
		GameRegistry.addSmelting(ModItems.largeHaditeSteelChunkItem, new ItemStack(ModItems.haditeSteelIngot), 4.0F);
		GameRegistry.addSmelting(ModItems.largeGestankenzinnChunkItem, new ItemStack(ModItems.gestankenzinnIngot),
				3.0F);
    } // end addFurnaceRecipes
    
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
        
        // recycle your Onyx
        if (Content.use_simple_ores)
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
        
        if (Loader.isModLoaded("aesthetics"))
        {
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(alexndr.plugins.Aesthetics.modsupport.SimpleOresModItems.onyx_door, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.NETHERRACK), new ItemStack(ModItems.haditeCoalIngot),
					new ItemStack(alexndr.plugins.SimpleOres.ModBlocks.onyx_ore), 20.0F);
        }
        if (Loader.isModLoaded("machines"))
        {
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(alexndr.plugins.machines.ModBlocks.onyx_furnace, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.NETHERRACK), new ItemStack(ModItems.haditeCoalIngot),
					new ItemStack(alexndr.plugins.SimpleOres.ModBlocks.onyx_ore, 2, 0), 40.0F);
        }
    } // end addRecyclingRecipes
    
//    public static void setLoot()
//    {
////        // loot
//        LootHelper.addLoot("villageBlacksmith", new ItemStack(haditeCoalIngot), 3, 5, 7);
//        LootHelper.addLoot("villageBlacksmith", new ItemStack(gestankenzinnIngot), 2, 3, 2);
//        LootHelper.addLoot("villageBlacksmith", new ItemStack(haditeSteelIngot), 2, 3, 2);
//        LootHelper.addLoot("villageBlacksmith", new ItemStack(gestankenzinnSword), 1, 1, 2);
//        LootHelper.addLoot("villageBlacksmith", new ItemStack(haditeSteelSword), 1, 1, 2);
//        LootHelper.addLoot("villageBlacksmith", new ItemStack(gestankenzinnPickaxe), 1, 1, 2);
//        LootHelper.addLoot("villageBlacksmith", new ItemStack(haditeSteelPickaxe), 1, 1, 2);
//        LootHelper.addLoot("villageBlacksmith", new ItemStack(gestankenzinnAxe), 1, 1, 1);
//        LootHelper.addLoot("villageBlacksmith", new ItemStack(haditeSteelAxe), 1, 1, 1);
//        LootHelper.addLoot("villageBlacksmith", new ItemStack(gestankenzinnShovel), 1, 1, 1);
//        LootHelper.addLoot("villageBlacksmith", new ItemStack(haditeSteelShovel), 1, 1, 1);
//        LootHelper.addLoot("strongholdCrossing", new ItemStack(haditeCoalIngot), 1, 2, 4);
//        LootHelper.addLoot("strongholdCorridor", new ItemStack(haditeCoalIngot), 1, 2, 2);
//        LootHelper.addLoot("pyramidDesertyChest", new ItemStack(haditeCoalIngot), 1, 4, 2);
//        LootHelper.addLoot("pyramidDesertyChest", new ItemStack(gestankenzinnSword), 1, 2, 1);
//        LootHelper.addLoot("pyramidDesertyChest", new ItemStack(haditeSteelSword), 1, 6, 1);
//        LootHelper.addLoot("dungeonChest", new ItemStack(gestankenzinnIngot), 1, 3, 5);
//        LootHelper.addLoot("dungeonChest", new ItemStack(haditeSteelIngot), 1, 3, 5);
//        LootHelper.addLoot("dungeonChest", new ItemStack(gestankenzinnSword), 1, 2, 2);
//        LootHelper.addLoot("dungeonChest", new ItemStack(haditeSteelSword), 1, 2, 2);
//        LootHelper.addLoot("dungeonChest", new ItemStack(gestankenzinnPickaxe), 1, 2, 2);
//        LootHelper.addLoot("dungeonChest", new ItemStack(haditeSteelPickaxe), 1, 2, 2);
//        LootHelper.addLoot("mineshaftCorridor", new ItemStack(gestankenzinnPickaxe), 1, 2, 1);
//        LootHelper.addLoot("mineshaftCorridor", new ItemStack(haditeSteelPickaxe), 1, 2, 1);
//        LootHelper.addLoot("mineshaftCorridor", new ItemStack(gestankenzinnShovel), 1, 2, 1);
//        LootHelper.addLoot("mineshaftCorridor", new ItemStack(haditeSteelShovel), 1, 2, 1);
//        
//    } // end setLoot


} // end class Content
