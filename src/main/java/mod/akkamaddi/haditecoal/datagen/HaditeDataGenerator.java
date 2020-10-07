package mod.akkamaddi.haditecoal.datagen;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import mod.akkamaddi.haditecoal.HaditeCoal;
import mod.akkamaddi.haditecoal.config.HaditeConfig;
import mod.akkamaddi.haditecoal.init.ModItems;
import mod.akkamaddi.haditecoal.init.ModTags;
import mod.alexndr.fusion.api.datagen.FusionRecipeSetBuilder;
import mod.alexndr.fusion.api.recipe.AbstractFusionRecipeProvider;
import mod.alexndr.simplecorelib.datagen.ISimpleConditionBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
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

    /**
     * Fusion RecipeProvider for HaditeCoal
     */
    public static class FusionRecipes extends AbstractFusionRecipeProvider
            implements IConditionBuilder, ISimpleConditionBuilder
    {
        @Override
        public String getName()
        {
            return "Hadite Coal fusion alloy recipes";
        }

        private FusionRecipeSetBuilder fusionbuilder;

        public FusionRecipes(DataGenerator generatorIn)
        {
            super(generatorIn);
            fusionbuilder = new FusionRecipeSetBuilder(HaditeCoal.MODID);
        }

        @Override
        protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
        {
            registerGestankenzinnRecipes(consumer);
        }
        
        /**
         * Gestankenzinn alloy recipes and bronze recycling recipes.
         * @param consumer
         */
        protected void registerGestankenzinnRecipes(Consumer<IFinishedRecipe> consumer)
        {
            // Gestankenzinn alloy recipes
            List<Ingredient> primary_inputs = new ArrayList<Ingredient>(2);
            Ingredient[] catalysts = new Ingredient[3];

            primary_inputs.add(Ingredient.fromItems(ModItems.hadite_coal.get()));
            primary_inputs.add(Ingredient.fromTag(ModTags.Items.INGOTS_TIN));
            catalysts[0] = null;
            catalysts[1] = null;
            catalysts[2] = Ingredient.fromTag(ItemTags.COALS);

            fusionbuilder.buildBasicAlloyRecipes(consumer, primary_inputs, catalysts, null,
                    null, ModItems.large_gestankenzinn_chunk.get(), 5.0F, 600,
                    flag("gestankenzinn_making_enabled"));
        } // end registerGestankenzinnRecipes
        
        /**
         * Builds an ICondition representing FlagCondition...
         *
         */
        public ICondition flag(String name)
        {
            return impl_flag(HaditeCoal.MODID, HaditeConfig.INSTANCE, name);
        }

    } // end-class FusionRecipes

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
