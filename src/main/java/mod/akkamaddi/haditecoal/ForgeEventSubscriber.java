package mod.akkamaddi.haditecoal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.akkamaddi.haditecoal.config.HaditeConfig;
import mod.akkamaddi.haditecoal.loot.HaditeInjectionLookup;
import mod.alexndr.simplecorelib.api.helpers.LootUtils;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HaditeCoal.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class ForgeEventSubscriber
{
    @SuppressWarnings("unused")
    private static final Logger LOGGER = LogManager.getLogger(HaditeCoal.MODID + " Forge Event Subscriber");
    private static final HaditeInjectionLookup lootLookupMap = new HaditeInjectionLookup();
    
    /**
     * add mod loot to loot tables. Code heavily based on Botania's LootHandler, which
     * neatly solves the problem when I couldn't figure it out.
     */
    @SubscribeEvent
    public static void LootLoad(final LootTableLoadEvent event)
    {
        if (HaditeConfig.addChestLoot)
        {
            LootUtils.LootLoadHandler(HaditeCoal.MODID, event, lootLookupMap);
        } // end-if config allows
    } // end LootLoad()
    
    

} // end class
