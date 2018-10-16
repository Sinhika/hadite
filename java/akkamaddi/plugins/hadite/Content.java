/**
 * 
 */
package akkamaddi.plugins.hadite;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import akkamaddi.plugins.hadite.blocks.HaditeOreBlock;
import akkamaddi.plugins.hadite.blocks.HaditeStorageBlock;
import alexndr.api.content.blocks.SimpleBlock;
import alexndr.api.content.items.SimpleAxe;
import alexndr.api.content.items.SimpleItem;
import alexndr.api.content.items.SimplePickaxe;
import alexndr.api.content.items.SimpleShovel;
import alexndr.api.content.items.SimpleSword;
import alexndr.api.logger.LogHelper;

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
            doItems();
            LogHelper.verbose(ModInfo.ID, "All items were added successfully");
        } 
        catch (Exception e) {
            LogHelper.severe(ModInfo.ID,
                            "Items were not added successfully. This is a serious problem!");
            e.printStackTrace();
        }
        try {
            doBlocks();
            LogHelper.verbose(ModInfo.ID,
                    "All blocks were added successfully");
        } 
        catch (Exception e) {
            LogHelper.severe(ModInfo.ID,
                            "Blocks were not added successfully. This is a serious problem!");
            e.printStackTrace();
        }
        try {
            doTools();
            LogHelper.verbose(ModInfo.ID,
                    "All tools were added successfully");
        } 
        catch (Exception e) {
            LogHelper.severe(ModInfo.ID,
                            "Tools were not added successfully. This is a serious problem!");
            e.printStackTrace();
        }
        //      try{doAchievements(); LogHelper.verboseInfo(ModInfo.ID, "All achievements were added successfully");}
//          catch(Exception e){LogHelper.severe(ModInfo.ID, "Achievements were not added successfully. This is a serious problem!"); e.printStackTrace();}
    } // end preInitialize()

    public static void doBlocks()
    {
        // define blocks
        blockHaditeCoalOre = new HaditeOreBlock(Material.rock, "haditecoal")
                .setHardness(Settings.haditeCoalOreHardness)
                .setResistance(Settings.haditeCoalOreResistance)
                .setStepSound(Block.soundTypeStone)
                .setBlockName("blockHaditeCoalOre")
                .setCreativeTab(HaditeCoal.tabAkkamaddiHadite)
                .setLightLevel(0.6F);
        ((SimpleBlock) blockHaditeCoalOre).setStackToDrop(new ItemStack(haditeCoalIngot));

        blockHaditeCoalBlock = new HaditeStorageBlock(Material.rock,
                "haditecoal").setHardness(Settings.haditeCoalHardness)
                .setResistance(Settings.haditeCoalResistance)
                .setStepSound(Block.soundTypeStone)
                .setBlockName("blockHaditeCoalBlock")
                .setCreativeTab(HaditeCoal.tabAkkamaddiHadite)
                .setLightLevel(0.7F);
        blockHaditeSteel = new SimpleBlock(Material.iron).modId("haditecoal")
                .setBeaconBase(true)
                .setCreativeTab(HaditeCoal.tabAkkamaddiHadite)
                .setHardness(Settings.haditeSteelHardness)
                .setResistance(Settings.haditeSteelResistance)
                .setStepSound(Block.soundTypeMetal)
                .setBlockName("blockHaditeSteel")
                .setCreativeTab(HaditeCoal.tabAkkamaddiHadite);
        blockGestankenzinn = new SimpleBlock(Material.iron).modId("haditecoal")
                .setBeaconBase(true)
                .setCreativeTab(HaditeCoal.tabAkkamaddiHadite)
                .setHardness(Settings.gestankenzinnHardness)
                .setResistance(Settings.gestankenzinnResistance)
                .setStepSound(Block.soundTypeMetal)
                .setBlockName("blockGestankenzinn")
                .setCreativeTab(HaditeCoal.tabAkkamaddiHadite);
        
        blockHaditeCoalOre.setHarvestLevel( "pickaxe", Settings.haditeCoalOreHarvestLevel);
        blockHaditeCoalBlock.setHarvestLevel( "pickaxe", Settings.haditeCoalHarvestLevel);
        blockHaditeSteel.setHarvestLevel( "pickaxe", Settings.haditeSteelHarvestLevel);
        blockGestankenzinn.setHarvestLevel("pickaxe", Settings.gestankenzinnHarvestLevel);
        
    } // end doBlocks()

    public static void doItems()
    {
        // Define Items
        haditeCoalIngot = new SimpleItem().modId("haditecoal")
                .setCreativeTab(HaditeCoal.tabAkkamaddiHadite)
                .setUnlocalizedName("haditeCoalIngot");
        
        // Hadite Steel
        haditeSteelIngot = new SimpleItem().modId("haditecoal").isIngot()
                .setCreativeTab(HaditeCoal.tabAkkamaddiHadite)
                .setUnlocalizedName("haditeSteelIngot");
        largeHaditeSteelChunkItem = new SimpleItem().modId("haditecoal").isIngot()
                .setCreativeTab(HaditeCoal.tabAkkamaddiHadite)
                .setUnlocalizedName("largeHaditeSteelChunkItem");
        
        // Gestankenzinn
        gestankenzinnIngot = new SimpleItem().modId("haditecoal").isIngot()
                .setCreativeTab(HaditeCoal.tabAkkamaddiHadite)
                .setUnlocalizedName("gestankenzinnIngot");
        largeGestankenzinnChunkItem = new SimpleItem().modId("haditecoal").isIngot()
                .setCreativeTab(HaditeCoal.tabAkkamaddiHadite)
                .setUnlocalizedName("largeGestankenzinnChunkItem");
        
    } // end doItems()

    public static void doTools()
    {
        haditeSteelSword = new SimpleSword(HaditeCoal.toolHaditeSteel).modId("haditecoal")
                .setCreativeTab(HaditeCoal.tabAkkamaddiHadite)
                .setUnlocalizedName("haditeSteelSword");
        haditeSteelShovel = new SimpleShovel(HaditeCoal.toolHaditeSteel)
                .modId("haditecoal")
                .setCreativeTab(HaditeCoal.tabAkkamaddiHadite)
                .setUnlocalizedName("haditeSteelShovel");
        haditeSteelAxe = new SimpleAxe(HaditeCoal.toolHaditeSteel).modId("haditecoal")
                .setCreativeTab(HaditeCoal.tabAkkamaddiHadite)
                .setUnlocalizedName("haditeSteelAxe");
        haditeSteelPickaxe = new SimplePickaxe(HaditeCoal.toolHaditeSteel)
                .modId("haditecoal")
                .setCreativeTab(HaditeCoal.tabAkkamaddiHadite)
                .setUnlocalizedName("haditeSteelPickaxe");
        
        gestankenzinnSword = new SimpleSword(HaditeCoal.toolGestankenzinn)
                .modId("haditecoal")
                .setCreativeTab(HaditeCoal.tabAkkamaddiHadite)
                .setUnlocalizedName("gestankenzinnSword");
        gestankenzinnShovel = new SimpleShovel(HaditeCoal.toolGestankenzinn)
                .modId("haditecoal")
                .setCreativeTab(HaditeCoal.tabAkkamaddiHadite)
                .setUnlocalizedName("gestankenzinnShovel");
        gestankenzinnAxe = new SimpleAxe(HaditeCoal.toolGestankenzinn).modId("haditecoal")
                .setCreativeTab(HaditeCoal.tabAkkamaddiHadite)
                .setUnlocalizedName("gestankenzinnAxe");
        gestankenzinnPickaxe = new SimplePickaxe(HaditeCoal.toolGestankenzinn)
                .modId("haditecoal")
                .setCreativeTab(HaditeCoal.tabAkkamaddiHadite)
                .setUnlocalizedName("gestankenzinnPickaxe");

    } // end doTools()

    /**
     * Sets the tool and armor stats from the Settings file.
     */
    private static void setToolAndArmorStats() 
    {
        // set tool properties
        // EnumToolMaterial. In form ("NAME", mining level, max uses, speed,
        // damage to entity, enchantability)
        toolHaditeSteel = EnumHelper.addToolMaterial("HADITESTEEL",
                Settings.haditeSteelMiningLevel, Settings.haditeSteelUsesNum,
                Settings.haditeSteelMiningSpeed, Settings.haditeSteelDamageVsEntity,
                Settings.haditeSteelEnchantability);
        toolGestankenzinn = EnumHelper.addToolMaterial("GESTANKENZINN", 
                Settings.gestankenzinnMiningLevel, Settings.gestankenzinnUsesNum,
                Settings.gestankenzinnMiningSpeed, Settings.gestankenzinnDamageVsEntity,
                Settings.gestankenzinnEnchantability);
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

    // Hadite
    public static Item haditeCoalIngot;

    //Hadite Steel
    public static Item haditeSteelIngot;
    public static Item largeHaditeSteelChunkItem;

    public static Item haditeSteelSword;
    public static Item haditeSteelShovel;
    public static Item haditeSteelAxe;
    public static Item haditeSteelPickaxe;

    //Gestankenzinn
    public static Item gestankenzinnIngot;
    public static Item largeGestankenzinnChunkItem;

    public static Item gestankenzinnSword;
    public static Item gestankenzinnShovel;
    public static Item gestankenzinnAxe;
    public static Item gestankenzinnPickaxe;

    //blocks
    public static Block blockHaditeCoalOre;
    public static Block blockHaditeCoalBlock;
    public static Block blockHaditeSteel;
    public static Block blockGestankenzinn;

} // end class Content
