/**
 * 
 */
package akkamaddi.plugins.hadite;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import akkamaddi.api.core.ASettings;
import alexndr.api.core.LogHelper;

/**
 * @author cyhiggin
 *
 */
public class Settings extends ASettings
{
    /** 
     * umbrella config loading routine. must be instantiated by child classes.
     * @param event
     */
    public static void createOrLoadSettings(FMLPreInitializationEvent event) 
    {
        config = GetConfig(event, "akkamaddi", "hadite.cfg");

        try {
            LogHelper.verboseInfo(ModInfo.ID, "Loading Settings...");
            config.load();
            genericSettings(ModInfo.ID, ModInfo.NAME);
            
            MakeOreFlame = config.get(Configuration.CATEGORY_GENERAL,
                    "Hadite Ore spits fire", true).getBoolean(true);
            MakeBlockFlame = config.get(Configuration.CATEGORY_GENERAL,
                    "Hadite Block emits flames", true).getBoolean(true);

            haditeCoalBurnTime = config.getInt("Hadite Coal Burn Time", 
                    Configuration.CATEGORY_GENERAL, 13000, 0, 999999, 
                    "How long hadite coal burns as furnace fuel (Coal = 1600)");
            
            // Adjustable Ore Spawn Rates
            adjustOreSpawnRates();

             // Block Stat Modification
            blockStatDefaults();
            if (enableBlockStatModification) {
                LogHelper.verboseInfo(ModInfo.ID,
                        "Block Stat Modification enabled!");
                customizeBlockStats();
            }

            toolStatDefaults();
            if (enableToolStatModification) {
                LogHelper.verboseInfo(ModInfo.ID,
                        "Tool Stat Modification enabled!");
                customizeToolStats();
            }
        } // end-try
        catch (Exception e) {
            LogHelper
                    .severe(ModInfo.ID,
                            "Settings failed to load correctly. The plugin may not function correctly");
        }

        finally {
            config.save();
            LogHelper.verboseInfo(ModInfo.ID, "Settings loaded successfully");
        }
        
    } // end createOrLoadSettings()

   /** 
     * loads/sets the ore generation variables.
     */
    public static void adjustOreSpawnRates() 
    {
        haditeSpawnRate = config.getInt("Hadite Coal Worldgen",
                "Hadite Coal Spawn Rate", Settings.haditeSpawnRate, 0, 5000,
                "Controls the spawn rate of Hadite Coal.");
        haditeVeinSize = config.getInt("Hadite Coal Worldgen",
                "Hadite Coal Vein Size", Settings.haditeVeinSize, 0, 5000,
                "Controls the max vein size of Hadite Coal.");
        haditeMaxSpawnHeight = config.getInt("Hadite Coal Worldgen",
                "Hadite Coal Maximum Spawn Height", Settings.haditeMaxSpawnHeight, 0, 255,
                "Controls the max spawn height of Hadite Coal.");
        haditeMinSpawnHeight = config.getInt("Hadite Coal Worldgen",
                "Hadite Coal Minimum Spawn Height", Settings.haditeMinSpawnHeight, 0, 255,
                "Controls the min spawn height of Hadite Coal.");
        
    } // end adjustOreSpawnRates()

     /**
     * Sets the default block stats.
     */
    public static void blockStatDefaults() 
    {
        haditeCoalHardness = 4.0F;
        haditeCoalResistance = 6.0F;
        haditeCoalHarvestLevel = 0;
        haditeCoalOreHardness = 4.0F;
        haditeCoalOreResistance = 6.0F;
        haditeCoalOreHarvestLevel = 1;
        haditeSteelHardness = 14.0F;
        haditeSteelResistance = 22.0F;
        haditeSteelHarvestLevel = 0;
        gestankenzinnHardness = 12.0F;
        gestankenzinnResistance = 20.0F;
        gestankenzinnHarvestLevel = 0;
    }

    /**
     * sets customized block stats.
     */
    public static void customizeBlockStats() 
    {
        haditeCoalHardness = config.getFloat("Hadite Coal Hardness",
                "Block Stat Modification", haditeCoalHardness, 0.0F, 32000.0F,
                "How many hits to break a block");
        haditeCoalResistance = config.getFloat("Hadite Coal Resistance",
                "Block Stat Modification", haditeCoalResistance, 0.0F, 32000.0F,
                "Explosion Resistance");
        haditeCoalHarvestLevel = config.getInt("Hadite Coal Harvest Level",
                "Block Stat Modification", haditeCoalHarvestLevel, 0, 255,
                "Tool level required to harvest this block");

        haditeCoalOreHardness = config.getFloat("Hadite Coal Ore Hardness",
                "Block Stat Modification", haditeCoalOreHardness, 0.0F, 32000.0F,
                "How many hits to break a block");
        haditeCoalOreResistance = config.getFloat("Hadite Coal Ore Resistance",
                "Block Stat Modification", haditeCoalOreResistance, 0.0F, 32000.0F,
                "Explosion Resistance");
        haditeCoalOreHarvestLevel = config.getInt("Hadite Coal Ore Harvest Level",
                "Block Stat Modification", haditeCoalOreHarvestLevel, 0, 255,
                "Tool level required to harvest this block");

        haditeSteelHardness = config.getFloat("Hadite Steel Hardness",
                "Block Stat Modification", haditeSteelHardness, 0.0F, 32000.0F,
                "How many hits to break a block");
        haditeSteelResistance = config.getFloat("Hadite Steel Resistance",
                "Block Stat Modification", haditeSteelResistance, 0.0F, 32000.0F,
                "Explosion Resistance");
        haditeSteelHarvestLevel = config.getInt("Hadite Steel Harvest Level",
                "Block Stat Modification", haditeSteelHarvestLevel, 0, 255,
                "Tool level required to harvest this block");

        gestankenzinnHardness = config.getFloat("Gestankenzinn Hardness",
                "Block Stat Modification", gestankenzinnHardness, 0.0F, 32000.0F,
                "How many hits to break a block");
        gestankenzinnResistance = config.getFloat("Gestankenzinn Resistance",
                "Block Stat Modification", gestankenzinnResistance, 0.0F, 32000.0F,
                "Explosion Resistance");
        gestankenzinnHarvestLevel = config.getInt("Gestankenzinn Harvest Level",
                "Block Stat Modification", gestankenzinnHarvestLevel, 0, 255,
                "Tool level required to harvest this block");

    } // end customizeBlockStats()
    
    /**
     * Sets the default tool stats.
     */
    public static void toolStatDefaults() 
    {
        haditeSteelMiningLevel = 3;
        haditeSteelUsesNum = 520;
        haditeSteelMiningSpeed = 6.5F;
        haditeSteelDamageVsEntity = 2;
        haditeSteelEnchantability = 13;
        gestankenzinnMiningLevel = 2;
        gestankenzinnUsesNum = 400;
        gestankenzinnMiningSpeed = 4.0F;
        gestankenzinnDamageVsEntity = 1;
        gestankenzinnEnchantability = 13;
    }

    /**
     * set customized tool stats.
     */
    public static void customizeToolStats() 
    {
        haditeSteelMiningLevel = config
                .getInt("Hadite Steel Mining Level",
                        "Tool Stat Modification",
                        haditeSteelMiningLevel,
                        0,
                        255,
                        "Controls the mining level of Hadite Steel Tools. 0 = wood, 1 = stone, 2 = iron, 3 = diamond.");
        haditeSteelUsesNum = config.getInt("Hadite Steel Tools Durability",
                "Tool Stat Modification", haditeSteelUsesNum, 0, 32000,
                "Controls the number of uses Hadite Steel Tools have.");
        haditeSteelMiningSpeed = config
                .getFloat(
                        "Hadite Steel Mining Speed",
                        "Tool Stat Modification",
                        haditeSteelMiningSpeed,
                        0,
                        32000,
                        "Controls the speed at which Hadite Steel Tools harvest their appropriate blocks.");
        haditeSteelDamageVsEntity = config
                .getFloat("Hadite Steel Damage Vs. Entities",
                        "Tool Stat Modification", haditeSteelDamageVsEntity, 0,
                        32000,
                        "Controls the amount of damage Hadite Steel Tools will do to entities.");
        haditeSteelEnchantability = config.getInt(
                "Hadite Steel Tools Enchantability", "Tool Stat Modification",
                haditeSteelEnchantability, 0, 32000,
                "Controls the enchantability of Hadite Steel Tools.");

        gestankenzinnMiningLevel = config
                .getInt("Gestankenzinn Mining Level",
                        "Tool Stat Modification",
                        gestankenzinnMiningLevel,
                        0,
                        255,
                        "Controls the mining level of Gestankenzinn Tools. 0 = wood, 1 = stone, 2 = iron, 3 = diamond.");
        gestankenzinnUsesNum = config.getInt("Gestankenzinn Tools Durability",
                "Tool Stat Modification", gestankenzinnUsesNum, 0, 32000,
                "Controls the number of uses Gestankenzinn Tools have.");
        gestankenzinnMiningSpeed = config
                .getFloat(
                        "Gestankenzinn Mining Speed",
                        "Tool Stat Modification",
                        gestankenzinnMiningSpeed,
                        0,
                        32000,
                        "Controls the speed at which Gestankenzinn Tools harvest their appropriate blocks.");
        gestankenzinnDamageVsEntity = config
                .getFloat("Gestankenzinn Damage Vs. Entities",
                        "Tool Stat Modification", gestankenzinnDamageVsEntity,
                        0, 32000,
                        "Controls the amount of damage Gestankenzinn Tools will do to entities.");
        gestankenzinnEnchantability = config.getInt(
                "Gestankenzinn Tools Enchantability", "Tool Stat Modification",
                gestankenzinnEnchantability, 0, 32000,
                "Controls the enchantability of Gestankenzinn Tools.");

    } // end customizeToolStats

    // spawning
    public static int haditeSpawnRate, haditeVeinSize, haditeMinSpawnHeight,
        haditeMaxSpawnHeight;

    // Booleans
    public static boolean MakeOreFlame, MakeBlockFlame;

    // Tool Stats
    public static int haditeSteelMiningLevel, gestankenzinnMiningLevel;
    public static int haditeSteelUsesNum, gestankenzinnUsesNum;
    public static float haditeSteelMiningSpeed, gestankenzinnMiningSpeed;
    public static float haditeSteelDamageVsEntity, gestankenzinnDamageVsEntity;
    public static int haditeSteelEnchantability, gestankenzinnEnchantability;

    // Block stats
    public static float haditeCoalHardness, haditeCoalOreHardness,
            haditeSteelHardness, gestankenzinnHardness;

    public static float haditeCoalResistance, haditeCoalOreResistance,
            haditeSteelResistance, gestankenzinnResistance;

    public static int haditeCoalHarvestLevel, haditeCoalOreHarvestLevel,
            haditeSteelHarvestLevel, gestankenzinnHarvestLevel;
    
    // fuel stats
    public static int haditeCoalBurnTime;
    
} // end class Settings
