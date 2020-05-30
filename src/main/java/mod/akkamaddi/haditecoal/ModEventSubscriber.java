package mod.akkamaddi.haditecoal;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.akkamaddi.haditecoal.config.ConfigHelper;
import mod.akkamaddi.haditecoal.config.ConfigHolder;
import mod.akkamaddi.haditecoal.config.HaditeConfig;
import mod.akkamaddi.haditecoal.generation.OreGeneration;
import mod.akkamaddi.haditecoal.init.ModBlocks;
import mod.akkamaddi.haditecoal.init.ModTabGroups;
import mod.alexndr.simpleores.api.config.FlagCondition;
import mod.alexndr.simpleores.api.loot.SimpleOresLootModifiers;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.IForgeRegistry;


@SuppressWarnings("deprecation")
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
        DeferredWorkQueue.runLater( () -> {
                OreGeneration.setupNetherOreGen();
        } );

        LOGGER.debug("Common setup done");
    } // end onCommonSetup

    /**
     * This method will be called by Forge when it is time for the mod to register its Items.
     * This method will always be called after the Block registry method.
     */
    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event)
    {
        final IForgeRegistry<Item> registry = event.getRegistry();
        // Automatically register BlockItems for all our Blocks
        ModBlocks.BLOCKS.getEntries().stream()
                .map(RegistryObject::get)
                // You can do extra filtering here if you don't want some blocks to have an BlockItem automatically registered for them
                // .filter(block -> needsItemBlock(block))
                // Register the BlockItem for the block
                .forEach(block -> {
                    // Make the properties, and make it so that the item will be on our ItemGroup (CreativeTab)
                    final Item.Properties properties = new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP);
                    // Create the new BlockItem with the block and it's properties
                    final BlockItem blockItem = new BlockItem(block, properties);
                    // Set the new BlockItem's registry name to the block's registry name
                    blockItem.setRegistryName(block.getRegistryName());
                    // Register the BlockItem
                    registry.register(blockItem);
                });
        LOGGER.debug("Registered BlockItems");
    }  // end onRegisterItems()

    @SubscribeEvent
    public static void onModConfigEvent(final ModConfig.ModConfigEvent event)
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

    /**
     * Register<GlobalLootModifierSerializer<?>> event handler.
     * @param event
     */
    @SubscribeEvent
    public static void onRegisterModifierSerializers(
            @Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event)
    {
        event.getRegistry().register(
                new SimpleOresLootModifiers.ShearsLootModifier.Serializer().setRegistryName(
                        new ResourceLocation(HaditeCoal.MODID, "mod_shears_harvest")) );
    } // end registerModifierSerializers

    @SubscribeEvent
    public static void onRegisterRecipeSerializers(
            @Nonnull final RegistryEvent.Register<IRecipeSerializer<?>> event)
    {
        CraftingHelper.register(new FlagCondition.Serializer(HaditeConfig.INSTANCE, 
                new ResourceLocation(HaditeCoal.MODID, "flag")));
    } // end registerRecipeSerializers

} // end-class
