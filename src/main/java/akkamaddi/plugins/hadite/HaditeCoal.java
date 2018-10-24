package akkamaddi.plugins.hadite;

import alexndr.api.content.inventory.SimpleTab;
import alexndr.api.core.SimpleCoreAPI;
import alexndr.api.helpers.game.OreGenerator;
import alexndr.api.helpers.game.TabHelper;
import alexndr.api.logger.LogHelper;
import alexndr.api.registry.ContentCategories;
import alexndr.api.registry.ContentRegistry;
import alexndr.api.registry.Plugin;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, 
	acceptedMinecraftVersions=ModInfo.ACCEPTED_VERSIONS, dependencies = ModInfo.DEPENDENCIES,
	 updateJSON=ModInfo.VERSIONURL)
public class HaditeCoal
{
	@Mod.Instance
	public static HaditeCoal INSTANCE;

	@SidedProxy(clientSide = "akkamaddi.plugins.hadite.ProxyClient", 
				serverSide = "akkamaddi.plugins.hadite.ProxyCommon")
	public static ProxyCommon proxy;

	public static Plugin plugin = new Plugin(ModInfo.ID, ModInfo.NAME);
	
    // tab
    public static SimpleTab tabAkkamaddiHadite;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        LogHelper.info(ModInfo.ID, "Loading...");
        
		//Configuration
		ContentRegistry.registerPlugin(HaditeCoal.plugin);
        Settings.createOrLoadSettings(event);
        
        // Tab
		if (! TabHelper.wereTabsInitialized()) {
			SimpleCoreAPI.tabPreInit();
		}
		tabAkkamaddiHadite = new SimpleTab(HaditeCoal.plugin, "tabAkkamaddiHadite", 
											ContentCategories.CreativeTab.GENERAL);
        Content.preInitialize();

        //Content
		proxy.PreInit(event);
    } // end preInit()

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        // run tab icon call
        setTabIcons();
        Content.setRepairMaterials();
        setOreGenSettings();
        Content.addSmeltingRecipes();
        Content.addFusionRecipes();
        if (Settings.enableRecycling) {
        	Content.addRecyclingRecipes();
        } // end if recycling
        proxy.Init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info("HaditeCoal loaded");
        proxy.PostInit(event);
    }
    
    /**
     * Creating the custom tabs using the API class "SimpleTab" and setting their icon.
     */
    private void setTabIcons()
    {
        tabAkkamaddiHadite.setIcon(Item.getItemFromBlock(ModBlocks.blockHaditeCoalOre));
    }

    /**
     * Registers each ore to be generated.
     */
    private static void setOreGenSettings()
    {
		LogHelper.verbose(ModInfo.ID, "Setting ore gen parameters");
		if (Settings.haditeCoalOre.isEnableOreGen())
		{
			OreGenerator.registerOreForGen(-1, ModBlocks.blockHaditeCoalOre, Blocks.NETHERRACK, 
											true, Settings.haditeCoalOre.getSpawnRate(), 
											Settings.haditeCoalOre.getVeinSize(), 
											Settings.haditeCoalOre.getMinHeight(), 
											Settings.haditeCoalOre.getMaxHeight());
		}
    } // end setOreGenSettings()
    

} // end class HaditeCoal
