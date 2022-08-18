package mod.akkamaddi.haditecoal;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.akkamaddi.haditecoal.config.ConfigHelper;
import mod.akkamaddi.haditecoal.config.ConfigHolder;
import mod.akkamaddi.haditecoal.config.HaditeConfig;
import mod.akkamaddi.haditecoal.content.HaditeCoalBlock;
import mod.akkamaddi.haditecoal.init.ModBlocks;
import mod.akkamaddi.haditecoal.init.ModTabGroups;
import mod.alexndr.simplecorelib.api.config.FlagCondition;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;


@Mod.EventBusSubscriber(modid = HaditeCoal.MODID,  bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModEventSubscriber
{
    private static final Logger LOGGER = LogManager.getLogger(HaditeCoal.MODID + " Mod Event Subscriber");

    /**
     * For best inter-mod compatibility, run ore generation in a DeferredWorkQueue, per dieseiben07.
     * @param event
     */
    @SubscribeEvent
    public static void onCommonSetup(final FMLCommonSetupEvent event)
    {
    } // end onCommonSetup

    /**
     * This method will be called by Forge when it is time for the mod to register its Items.
     * This method will always be called after the Block registry method.
     */
    @SubscribeEvent
    public static void onRegisterItems(RegisterEvent event)
    {
        if (event.getRegistryKey() == Registry.ITEM_REGISTRY)
        {
            // We need to go over the entire registry so that we include any potential
            // Registry Overrides
            // Automatically register BlockItems for all our Blocks
            ModBlocks.BLOCKS.getEntries().stream()
                .map(RegistryObject::get)
                    // You can do extra filtering here if you don't want some blocks to have an
                    // BlockItem automatically registered for them
                     .filter(block -> needsItemBlock(block))
                    // Register the BlockItem for the block
                    .forEach(block ->
                    {
                        // Make the properties, and make it so that the item will be on our ItemGroup
                        // (CreativeTab)
                        Item.Properties properties = new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP);
                        // Create the new BlockItem with the block and it's properties
                        BlockItem blockItem = new BlockItem(block, properties);
                        // Register the BlockItem
                        event.register(Registry.ITEM_REGISTRY,  helper -> {
                            helper.register(ForgeRegistries.BLOCKS.getKey(block), blockItem);
                        });
                    });
            LOGGER.debug("Registered BlockItems");
        }
    } // end onRegisterItems()

    private static boolean needsItemBlock(Block block)
    {
        if (block instanceof HaditeCoalBlock) {
            return false;
        }
        return true;
    }

    @SubscribeEvent
    public static void onModConfigEvent(final ModConfigEvent event)
    {
        final ModConfig config = event.getConfig();

        // Rebake the configs when they change
        if (config.getSpec() == ConfigHolder.CLIENT_SPEC)
        {
            ConfigHelper.bakeClient(config);
        }
        else if (config.getSpec() == ConfigHolder.SERVER_SPEC)
        {
            ConfigHelper.bakeServer(config);
        }
    } // onModConfigEvent

    @SubscribeEvent
    public static void onRegisterRecipeSerializers(@Nonnull RegisterEvent event)
    {
        if (event.getRegistryKey() == Registry.RECIPE_SERIALIZER_REGISTRY)
        {
           CraftingHelper.register(new FlagCondition.Serializer(HaditeConfig.INSTANCE, 
                    new ResourceLocation(HaditeCoal.MODID, "flag")));
        }
    } // end registerRecipeSerializers

} // end-class
