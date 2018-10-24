package akkamaddi.plugins.hadite.handler;

import akkamaddi.plugins.hadite.ModBlocks;
import akkamaddi.plugins.hadite.ModItems;
import akkamaddi.plugins.hadite.Settings;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class HaditeFuel
{
	@SubscribeEvent
    public void setBurnTimes(FurnaceFuelBurnTimeEvent event)
    {
        if (event.getItemStack().isItemEqual(new ItemStack(ModItems.haditeCoalIngot)))
        {
        	event.setBurnTime(Settings.haditeCoalBurnTime);
        }
        else if (event.getItemStack().isItemEqual(new ItemStack(ModBlocks.blockHaditeCoalBlock)))
        {
        	event.setBurnTime(Settings.haditeCoalBurnTime * 10);
        }
    }
} // end class HaditeFuel
