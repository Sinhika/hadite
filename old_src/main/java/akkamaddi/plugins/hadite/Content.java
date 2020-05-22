/**
 * 
 */
package akkamaddi.plugins.hadite;

import alexndr.api.logger.LogHelper;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * @author cyhiggin
 *
 */
public class Content
{
	public static ToolMaterial toolHaditeSteel, toolGestankenzinn;
	public static boolean use_simple_ores = false;
	public static boolean use_fusion = false;
	public static boolean use_machines = false;
	public static boolean use_aesthetics = false;
	
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
    	Content.use_machines = Loader.isModLoaded("machines");
    	Content.use_aesthetics = Loader.isModLoaded("aesthetics");
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
