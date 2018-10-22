/**
 * 
 */
package akkamaddi.plugins.hadite;

import alexndr.api.config.ConfigHelper;
import alexndr.api.config.types.ConfigBlock;
import alexndr.api.config.types.ConfigItem;
import alexndr.api.config.types.ConfigOre;
import alexndr.api.config.types.ConfigTool;
import alexndr.api.logger.LogHelper;
import alexndr.plugins.Fusion.ModInfo;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author cyhiggin
 *
 */
public class Settings
{
    // Tool Stats
    private static final int haditeSteelMiningLevel = 3;
    private static final int haditeSteelUsesNum = 520;
    private static final float haditeSteelMiningSpeed = 6.5F;
    private static final float haditeSteelDamageVsEntity = 2.0F;
    private static final int haditeSteelEnchantability = 13;
    private static final int gestankenzinnMiningLevel = 2;
    private static final int gestankenzinnUsesNum = 400;
    private static final float gestankenzinnMiningSpeed = 4.0F;
    private static final float gestankenzinnDamageVsEntity = 1.0F;
    private static final int gestankenzinnEnchantability = 13;
    
    // Block stats
    private static final float haditeCoalHardness = 4.0F;
    private static final float haditeCoalResistance = 6.0F;
    private static final int haditeCoalHarvestLevel = 0;
    private static final float haditeCoalOreHardness = 4.0F;
    private static final float haditeCoalOreResistance = 6.0F;
    private static final int haditeCoalOreHarvestLevel = 1;
    private static final float haditeSteelHardness = 14.0F;
    private static final float haditeSteelResistance = 22.0F;
    private static final int haditeSteelHarvestLevel = 0;
    private static final float gestankenzinnHardness = 12.0F;
    private static final float gestankenzinnResistance = 20.0F;
    private static final int gestankenzinnHarvestLevel = 0;

    // spawning
    private static final int haditeSpawnRate = 5;
    private static final int haditeVeinSize = 17; 
    private static final int haditeMinSpawnHeight = 0;
    private static final int haditeMaxSpawnHeight = 255;

    // big configuration object
	private static Configuration settings;

    /** 
     * umbrella config loading routine. must be instantiated by child classes.
     * @param event
     */
    public static void createOrLoadSettings(FMLPreInitializationEvent event) 
    {
    	settings = ConfigHelper.GetConfig(event, "akkamaddi", ModInfo.ID + ".cfg");
    	LogHelper.verbose(ModInfo.ID, "Loading Settings...");

    	try {
    		settings.load();
    		ConfigHelper.createHelpEntry(settings, ModInfo.URL);

    		// toggles
    		configureGeneral();

    		// Block & Ore Stats
    		configureBlocks();
    		
    		configureItems();
    		configureTools();
    		
    	} // end-try
    	catch (Exception e) {
    		LogHelper
    		.severe(ModInfo.ID,
    				"Settings failed to load correctly. The plugin may not function correctly");
    	}
    	finally {
    		settings.save();
    		LogHelper.verbose(ModInfo.ID, "Settings loaded successfully");
    	}

    } // end createOrLoadSettings()

    /**
     * General toggles and values.
     */
    public static void configureGeneral()
    {
    	enableRecycling = settings.getBoolean("Enable Recycling", Configuration.CATEGORY_GENERAL, 
    			false, "Enable fusion furnace recycling of hadite and onyx items"); 
    	MakeOreFlame = settings.getBoolean("MakeOreFlame", Configuration.CATEGORY_GENERAL,
    			true, "Hadite Ore spits fire");
    	MakeBlockFlame = settings.getBoolean("MakeBlockFlame", Configuration.CATEGORY_GENERAL,
    			true, "Hadite Block emits flames");

    	haditeCoalBurnTime = settings.getInt("HaditeCoalBurnTime", 
    			Configuration.CATEGORY_GENERAL, 13000, 0, 999999, 
    			"How long hadite coal burns as furnace fuel (Coal = 1600)");
    	haditeCoalBlockFireSource = settings.getBoolean("HaditeCoalBlockFireSource", 
    			Configuration.CATEGORY_GENERAL, true, 
    			"Can use hadite coal block as a permanent fire source, like netherrack");
    } // end configureGeneral()
    
    /**
     * Needed to adapt old methods to new methods of configuring stuff
     */
    public static void configureBlocks()
    {
    	// ConfigBlock haditeSteelBlock, gestankenzinnBlock, haditeCoalBlock, haditeCoalOre
    	haditeSteelBlock = new ConfigBlock("Hadite Steel Block", ConfigHelper.CATEGORY_BLOCK)
    			.setHardness(haditeSteelHardness).setResistance(haditeSteelResistance)
    			.setLightValue(0.0F).setHarvestLevel(haditeSteelHarvestLevel).setHarvestTool("pickaxe")
    			.setBeaconBase(true);
    	haditeSteelBlock.GetConfig(settings);
    	
    	gestankenzinnBlock = new ConfigBlock("Gestankenzinn Block", ConfigHelper.CATEGORY_BLOCK)
    			.setHardness(gestankenzinnHardness).setResistance(gestankenzinnResistance)
    			.setLightValue(0.0F).setHarvestLevel(gestankenzinnHarvestLevel).setHarvestTool("pickaxe")
    			.setBeaconBase(true);
    	gestankenzinnBlock.GetConfig(settings);
    	
    	// the storage block, not the ore
    	haditeCoalBlock = new ConfigBlock("Hadite Coal Block", ConfigHelper.CATEGORY_BLOCK)
    			.setHardness(haditeCoalHardness).setResistance(haditeCoalResistance)
    			.setLightValue(0.0F).setHarvestLevel(haditeCoalHarvestLevel).setHarvestTool("pickaxe")
    			.setBeaconBase(true);
    	haditeCoalBlock.GetConfig(settings);
    	
    	// the only ore here.
    	haditeCoalOre = new ConfigOre("Hadite Coal Ore").setSpawnRate(haditeSpawnRate)
    			.setVeinSize(haditeVeinSize).setMinHeight(haditeMinSpawnHeight).setMaxHeight(haditeMaxSpawnHeight)
    		.setHardness(haditeCoalOreHardness).setResistance(haditeCoalOreResistance)
    		.setHarvestLevel(haditeCoalOreHarvestLevel).setHarvestTool("pickaxe");
    	haditeCoalOre.GetConfig(settings);

    } // end configureBlocks()
    
    /**
     * Need to adapt old methods to new methods of configuring stuff
     */
    public static void configureTools()
    {
    	// ConfigTool gestankenzinnTools, haditeSteelTools
    	haditeSteelTools = new ConfigTool("Hadite Steel Tools").setUses(haditeSteelUsesNum)
    			.setHarvestLevel(haditeSteelMiningLevel).setHarvestSpeed(haditeSteelMiningSpeed)
    			.setDamageVsEntity(haditeSteelDamageVsEntity).setEnchantability(haditeSteelEnchantability);
    	haditeSteelTools.GetConfig(settings);
    	
    	gestankenzinnTools = new ConfigTool("Gestankenzinn Tools").setUses(gestankenzinnUsesNum)
    			.setHarvestLevel(gestankenzinnMiningLevel).setHarvestSpeed(gestankenzinnMiningSpeed)
    			.setDamageVsEntity(gestankenzinnDamageVsEntity).setEnchantability(gestankenzinnEnchantability);
    	gestankenzinnTools.GetConfig(settings);
    } // end configureTools()
    
    /**
     * Needed to adapt old methods to new methods of configuring stuff
     */
    public static void configureItems()
    {
    	// ConfigItem haditeCoalIngot, haditeSteelIngot, gestankenzinnIngot
    	haditeCoalIngot = new ConfigItem("Hadite Coal Chunk", ConfigHelper.CATEGORY_ITEM);
    	haditeCoalIngot.GetConfig(settings);
    	
    	haditeSteelIngot = new ConfigItem("Hadite Steel Ingot", ConfigHelper.CATEGORY_ITEM)
    			.setSmeltingXP(0.7F);
    	haditeSteelIngot.GetConfig(settings);
    	
    	gestankenzinnIngot = new ConfigItem("Gestankenzinn Ingot", ConfigHelper.CATEGORY_ITEM)
    			.setSmeltingXP(0.7F);
    	gestankenzinnIngot.GetConfig(settings);
   	
    } // end configure items
    
    // Booleans
    public static boolean MakeOreFlame, MakeBlockFlame, enableBlockStatModification, 
    	enableToolStatModification, enableRecycling, haditeCoalBlockFireSource;

    // fuel stats
    public static int haditeCoalBurnTime;
    
    // Config objects
    public static ConfigBlock haditeSteelBlock, gestankenzinnBlock, haditeCoalBlock;
    public static ConfigOre haditeCoalOre;
    public static ConfigItem haditeCoalIngot, haditeSteelIngot, gestankenzinnIngot;
    public static ConfigTool gestankenzinnTools, haditeSteelTools;
    
} // end class Settings
