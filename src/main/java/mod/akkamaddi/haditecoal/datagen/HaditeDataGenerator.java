package mod.akkamaddi.haditecoal.datagen;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

import mod.akkamaddi.haditecoal.HaditeCoal;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

/**
 * bundles up the GatherDataEvent handler and all the necessary data providers
 * for data generation.
 * 
 * @author Sinhika
 */
@EventBusSubscriber(modid = HaditeCoal.MODID, bus = MOD)
public class HaditeDataGenerator
{
    /**
     * GatherDataEvent handler.
     * 
     * @param event the GatherDataEvent.
     */
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator gen = event.getGenerator();
        if (event.includeServer())
        {
            // gen.addProvider(new Recipes(gen));
            gen.addProvider(new FusionRecipes(gen));
        }
    } // end gatherData()

//    /**
//     * Basic RecipeProvider for Fusion.
//     * 
//     * @author Sinhika
//     *
//     */
//    public static class Recipes extends RecipeProvider implements IConditionBuilder, ISimpleConditionBuilder
//    {
//        private RecipeSetBuilder setbuilder;
//
//        public Recipes(DataGenerator generatorIn)
//        {
//            super(generatorIn);
//            setbuilder = new RecipeSetBuilder(HaditeCoal.MODID);
//        }
//
//        @Override
//        protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
//        {
//            registerStorageRecipes(consumer);
//            registerMiscRecipes(consumer);
//            registerToolRecipes(consumer);
//            registerArmorRecipes(consumer);
//            registerFurnaceRecipes(consumer);
//        } // end registerRecipes()
//
//        protected void registerToolRecipes(Consumer<IFinishedRecipe> consumer)
//        {} // end registerToolRecipes()
//
//        protected void registerArmorRecipes(Consumer<IFinishedRecipe> consumer)
//        {} // end registerArmorRecipes()
//
//        protected void registerStorageRecipes(Consumer<IFinishedRecipe> consumer)
//        {
//        } // end registerStorageRecipes()
//
//        protected void registerMiscRecipes(Consumer<IFinishedRecipe> consumer)
//        {
//        } // end registerMiscRecipes()
//
//        protected void registerFurnaceRecipes(Consumer<IFinishedRecipe> consumer)
//        {
//        } // end registerFurnaceRecipes()
//
//        @Override
//        public ICondition flag(String name)
//        {
//            return impl_flag(HaditeCoal.MODID, HaditeConfig.INSTANCE, name);
//        }
//
//    } // end subclass Recipes


} // end-class
