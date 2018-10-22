package akkamaddi.plugins.hadite;

import alexndr.api.content.items.SimpleAxe;
import alexndr.api.content.items.SimpleItem;
import alexndr.api.content.items.SimplePickaxe;
import alexndr.api.content.items.SimpleShovel;
import alexndr.api.content.items.SimpleSword;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems 
{
    // Hadite
    public static SimpleItem haditeCoalIngot = new SimpleItem("haditeCoalIngot", HaditeCoal.plugin);

    //Hadite Steel
    public static SimpleItem haditeSteelIngot = new SimpleItem("haditeSteelIngot", HaditeCoal.plugin);
    public static SimpleItem largeHaditeSteelChunkItem 
    	= new SimpleItem("largeHaditeSteelChunkItem", HaditeCoal.plugin);

    public static SimpleSword haditeSteelSword 
    	= new SimpleSword("haditeSteelSword", HaditeCoal.plugin, Content.toolHaditeSteel);
    public static SimpleShovel haditeSteelShovel 
    	= new SimpleShovel("haditeSteelShovel", HaditeCoal.plugin, Content.toolHaditeSteel);
    public static SimpleAxe haditeSteelAxe 
    	= new SimpleAxe("haditeSteelAxe", HaditeCoal.plugin, Content.toolHaditeSteel);
    public static SimplePickaxe haditeSteelPickaxe 
    	= new SimplePickaxe("haditeSteelPickaxe", HaditeCoal.plugin, Content.toolHaditeSteel);

    //Gestankenzinn
    public static SimpleItem gestankenzinnIngot 
    	= new SimpleItem("gestankenzinnIngot", HaditeCoal.plugin);
    public static SimpleItem largeGestankenzinnChunkItem 
    	= new SimpleItem("largeGestankenzinnChunkItem", HaditeCoal.plugin);

    public static SimpleSword gestankenzinnSword
    	= new SimpleSword("gestankenzinnSword", HaditeCoal.plugin, Content.toolGestankenzinn);
    public static SimpleShovel gestankenzinnShovel
    	= new SimpleShovel("gestankenzinnShovel", HaditeCoal.plugin, Content.toolGestankenzinn);
    public static SimpleAxe gestankenzinnAxe
    	= new SimpleAxe("gestankenzinnAxe", HaditeCoal.plugin, Content.toolGestankenzinn);
    public static SimplePickaxe gestankenzinnPickaxe
    	= new SimplePickaxe("gestankenzinnPickaxe", HaditeCoal.plugin, Content.toolGestankenzinn);

    
    public static void configureItems()
    {
        // Hadite Coal
    	if (Settings.haditeCoalIngot.isEnabled())
    		haditeCoalIngot.setConfigEntry(Settings.haditeCoalIngot)
    			.setCreativeTab(HaditeCoal.tabAkkamaddiHadite);
        
        // Hadite Steel
    	if (Settings.haditeSteelIngot.isEnabled())
    	{
    		haditeSteelIngot.setConfigEntry(Settings.haditeSteelIngot)
    			.setCreativeTab(HaditeCoal.tabAkkamaddiHadite);
    		largeHaditeSteelChunkItem.setConfigEntry(Settings.haditeSteelIngot)
    			.setCreativeTab(HaditeCoal.tabAkkamaddiHadite);
    	}
        // Gestankenzinn
    	if (Settings.gestankenzinnIngot.isEnabled())
    	{
    		gestankenzinnIngot.setConfigEntry(Settings.gestankenzinnIngot)
    			.setCreativeTab(HaditeCoal.tabAkkamaddiHadite);
    		largeGestankenzinnChunkItem.setConfigEntry(Settings.gestankenzinnIngot)
    			.setCreativeTab(HaditeCoal.tabAkkamaddiHadite);
    	}
    } // end configureItems()

    public static void configureTools()
    {
    	if (Settings.haditeSteelTools.isEnabled())
    	{
    		haditeSteelSword.setConfigEntry(Settings.haditeSteelTools)
    			.setCreativeTab(HaditeCoal.tabAkkamaddiHadite);
    		haditeSteelShovel.setConfigEntry(Settings.haditeSteelTools).setCreativeTab(HaditeCoal.tabAkkamaddiHadite);
    		haditeSteelAxe.setConfigEntry(Settings.haditeSteelTools).setCreativeTab(HaditeCoal.tabAkkamaddiHadite);
    		haditeSteelPickaxe.setConfigEntry(Settings.haditeSteelTools).setCreativeTab(HaditeCoal.tabAkkamaddiHadite);
    	}
    	if (Settings.gestankenzinnTools.isEnabled())
    	{
    		gestankenzinnSword.setConfigEntry(Settings.gestankenzinnTools).setCreativeTab(HaditeCoal.tabAkkamaddiHadite);
    		gestankenzinnShovel.setConfigEntry(Settings.gestankenzinnTools).setCreativeTab(HaditeCoal.tabAkkamaddiHadite);
    		gestankenzinnAxe.setConfigEntry(Settings.gestankenzinnTools).setCreativeTab(HaditeCoal.tabAkkamaddiHadite);
    		gestankenzinnPickaxe.setConfigEntry(Settings.gestankenzinnTools).setCreativeTab(HaditeCoal.tabAkkamaddiHadite);
    	}
    } // end configureTools()


	/**
	 * register Items with Forge.
	 * 
	 * @param registry Forge item registry interface.
	 */
	public static void register(IForgeRegistry<Item> registry) 
	{
	   	if (Settings.haditeCoalIngot.isEnabled()) registry.register(haditeCoalIngot);
    	if (Settings.haditeSteelIngot.isEnabled()) 
    	{
    		registry.registerAll(haditeSteelIngot, largeHaditeSteelChunkItem);
    	}
    	if (Settings.gestankenzinnIngot.isEnabled())
    	{
    		registry.registerAll(gestankenzinnIngot, largeGestankenzinnChunkItem);
    	}
    	if (Settings.haditeSteelTools.isEnabled())
    	{
    		registry.registerAll(haditeSteelSword, haditeSteelShovel, haditeSteelAxe, haditeSteelPickaxe);
    	}
    	if (Settings.gestankenzinnTools.isEnabled())
    	{
    		registry.registerAll(gestankenzinnSword, gestankenzinnShovel, gestankenzinnAxe, gestankenzinnPickaxe);
    	}    	
	} // end register()

	/**
	 * register Item models with Forge.
	 */
	public static void registerModels() 
	{
		if (Settings.haditeCoalIngot.isEnabled()) haditeCoalIngot.registerItemModel();
		if (Settings.haditeSteelIngot.isEnabled()) 
		{
			haditeSteelIngot.registerItemModel();
			largeHaditeSteelChunkItem.registerItemModel();
		}
    	if (Settings.gestankenzinnIngot.isEnabled())
    	{
    		gestankenzinnIngot.registerItemModel();
    		largeGestankenzinnChunkItem.registerItemModel();
    	}		
    	if (Settings.haditeSteelTools.isEnabled())
    	{
    		haditeSteelSword.registerItemModel();
    		haditeSteelShovel.registerItemModel();
    		haditeSteelAxe.registerItemModel();
    		haditeSteelPickaxe.registerItemModel();    		
    	}
    	if (Settings.gestankenzinnTools.isEnabled())
    	{
    		gestankenzinnSword.registerItemModel(); 
    		gestankenzinnShovel.registerItemModel(); 
    		gestankenzinnAxe.registerItemModel();
    		gestankenzinnPickaxe.registerItemModel();
    	}    	
	} // end registerModels()

	/**
	 * register ingots and suchlike with the ore dictionary.
	 */
	public static void registerOreDictionary()
	{
		if (Settings.haditeCoalIngot.isEnabled())
			OreDictionary.registerOre("haditeCoal", new ItemStack(ModItems.haditeCoalIngot));
		if (Settings.haditeSteelIngot.isEnabled())
			OreDictionary.registerOre("ingotHaditeSteel", new ItemStack(ModItems.haditeSteelIngot));
		if (Settings.gestankenzinnIngot.isEnabled())
			OreDictionary.registerOre("ingotGestankenzinn", new ItemStack(ModItems.gestankenzinnIngot));
	} // end registerOreDictionary()

} // end class
