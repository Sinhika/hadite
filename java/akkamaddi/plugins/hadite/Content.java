/**
 * 
 */
package akkamaddi.plugins.hadite;

import alexndr.api.logger.LogHelper;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

/**
 * @author cyhiggin
 *
 */
public class Content
{
	public static ToolMaterial toolHaditeSteel, toolGestankenzinn;

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
     * Sets the tool and armor stats from the Settings file.
     */
    private static void setToolAndArmorStats() 
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
    
    
    public static void setLoot()
    {
//        // loot
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
    } // end setLoot


} // end class Content
