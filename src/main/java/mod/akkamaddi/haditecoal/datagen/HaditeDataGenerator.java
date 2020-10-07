package mod.akkamaddi.haditecoal.datagen;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

import java.util.function.Consumer;

import mod.akkamaddi.haditecoal.HaditeCoal;
import mod.akkamaddi.haditecoal.config.HaditeConfig;
import mod.alexndr.fusion.api.datagen.FusionRecipeSetBuilder;
import mod.alexndr.fusion.api.recipe.AbstractFusionRecipeProvider;
import mod.alexndr.simplecorelib.datagen.ISimpleConditionBuilder;
import mod.alexndr.simplecorelib.datagen.RecipeSetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
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
            gen.addProvider(new Recipes(gen));
            gen.addProvider(new FusionRecipes(gen));
        }
    } // end gatherData()

    /**
     * Fusion RecipeProvider for HaditeCoal
     */
    public static class FusionRecipes extends AbstractFusionRecipeProvider
            implements IConditionBuilder, ISimpleConditionBuilder
    {
        private FusionRecipeSetBuilder fusionbuilder;

        public FusionRecipes(DataGenerator generatorIn)
        {
            super(generatorIn);
            fusionbuilder = new FusionRecipeSetBuilder(HaditeCoal.MODID);
        }

        @Override
        protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
        {
        }
        
        /**
         * Builds an ICondition representing FlagCondition...
         *
         */
        public ICondition flag(String name)
        {
            return impl_flag(HaditeCoal.MODID, HaditeConfig.INSTANCE, name);
        }

    } // end-class FusionRecipes

    /**
     * Basic RecipeProvider for Fusion.
     * 
     * @author Sinhika
     *
     */
    public static class Recipes extends RecipeProvider implements IConditionBuilder, ISimpleConditionBuilder
    {
        private RecipeSetBuilder setbuilder;

        public Recipes(DataGenerator generatorIn)
        {
            super(generatorIn);
            setbuilder = new RecipeSetBuilder(HaditeCoal.MODID);
        }

        @Override
        protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
        {
            registerStorageRecipes(consumer);
            registerMiscRecipes(consumer);
            registerToolRecipes(consumer);
            registerArmorRecipes(consumer);
            registerFurnaceRecipes(consumer);
        } // end registerRecipes()

        protected void registerToolRecipes(Consumer<IFinishedRecipe> consumer)
        {} // end registerToolRecipes()

        protected void registerArmorRecipes(Consumer<IFinishedRecipe> consumer)
        {} // end registerArmorRecipes()

        protected void registerStorageRecipes(Consumer<IFinishedRecipe> consumer)
        {
        } // end registerStorageRecipes()

        protected void registerMiscRecipes(Consumer<IFinishedRecipe> consumer)
        {
        } // end registerMiscRecipes()

        protected void registerFurnaceRecipes(Consumer<IFinishedRecipe> consumer)
        {
        } // end registerFurnaceRecipes()

        @Override
        public ICondition flag(String name)
        {
            return impl_flag(HaditeCoal.MODID, HaditeConfig.INSTANCE, name);
        }

    } // end subclass Recipes


} // end-class
