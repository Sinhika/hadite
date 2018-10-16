package akkamaddi.plugins.hadite;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ProxyClient extends akkamaddi.plugins.hadite.ProxyCommon 
{
	@Override
	public void PreInit(FMLPreInitializationEvent event) 
	{
		super.PreInit(event);
	} // end PreInit()

	@Override
	public void Init(FMLInitializationEvent event) {
		super.Init(event);
	} // end Init()

	@Override
	public void PostInit(FMLPostInitializationEvent event) {
		super.PostInit(event);
	}

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) 
	{
    	ModItems.registerModels();
    	ModBlocks.registerModels();
	}
} // end class
