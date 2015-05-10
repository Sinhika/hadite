package akkamaddi.plugins.hadite;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import alexndr.api.content.inventory.SimpleTab;
import alexndr.api.core.ContentTypes;
import alexndr.api.core.LogHelper;
import alexndr.api.helpers.game.OreGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, 
	dependencies = "required-after:simplecore; required-after:simpleores ; required-after:fusion ; required-after:akkamaddicore")

public class HaditeCoal
{
    // tab
    public static SimpleTab tabAkkamaddiHadite;

	public static ToolMaterial toolHaditeSteel, toolGestankenzinn;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        // Tab
        LogHelper.info("Loading HaditeCoal...");
        tabAkkamaddiHadite = new SimpleTab("tabAkkamaddiHadite", ContentTypes.CreativeTab.GENERAL);
        
        //Configuration
        Settings.createOrLoadSettings(event);
        
        //Content
        setToolAndArmorStats();
        Content.preInitialize();
        Recipes.preInitialize();
        Content.setLoot();
    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        // run tab icon call
        setTabIcons();
        setRepairMaterials();
        Recipes.initialize();
        
        // Set fuel burntime
        GameRegistry.registerFuelHandler(new HaditeFuel());
        
        setOreGenSettings();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info("HaditeCoal loaded");
    }
    
    /**
     * Creating the custom tabs using the API class "SimpleTab" and setting their icon.
     */
    private void setTabIcons()
    {
        tabAkkamaddiHadite.setIcon(new ItemStack(Content.blockHaditeCoalOre));
    }

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
    
    /**
     * Sets repair materials for the tools/armor of that type. ie. Copper Ingot to repair copper tools and armor.
     */
    private static void setRepairMaterials()
    {
        toolHaditeSteel.setRepairItem(new ItemStack(Content.haditeSteelIngot));
        toolGestankenzinn.setRepairItem(new ItemStack(Content.gestankenzinnIngot));
    } // end setRepairMaterials()

    /**
     * Registers each ore to be generated.
     */
    private static void setOreGenSettings()
    {
        OreGenerator.INSTANCE.registerOreForGeneration(-1, Content.blockHaditeCoalOre,
                Blocks.netherrack, Settings.haditeVeinSize,
                Settings.haditeSpawnRate, Settings.haditeMaxSpawnHeight,
                Settings.haditeMinSpawnHeight);
    } // end setOreGenSettings()
    

} // end class HaditeCoal
