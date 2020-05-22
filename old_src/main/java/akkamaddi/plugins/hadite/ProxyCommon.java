package akkamaddi.plugins.hadite;

import alexndr.api.registry.Plugin;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ProxyCommon 
{
	public void PreInit(FMLPreInitializationEvent event)
	{	
	} // end PreInit

	public void Init(FMLInitializationEvent event)
	{
	} // end Init()

	public void PostInit(FMLPostInitializationEvent event)
	{
	} // end PostInit()
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) 
	{
   	 	//Registers
		ModBlocks.register(event.getRegistry());
	} // end registerBlocks()

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) 
	{
    	ModItems.register(event.getRegistry());
    	ModBlocks.registerItemBlocks(event.getRegistry());
        ModItems.registerOreDictionary();
        ModBlocks.registerOreDictionary();
	}

	public void registerItemRenderer(Plugin plugin, Item item, int meta, String id) {
	}

} // end class
