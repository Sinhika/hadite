package mod.akkamaddi.haditecoal.datagen;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import mod.akkamaddi.haditecoal.HaditeCoal;
import mod.akkamaddi.haditecoal.config.HaditeConfig;
import mod.akkamaddi.haditecoal.init.ModItems;
import mod.akkamaddi.haditecoal.init.ModTags;
import mod.alexndr.fusion.api.datagen.FusionRecipeSetBuilder;
import mod.alexndr.fusion.api.recipe.AbstractFusionRecipeProvider;
import mod.alexndr.simplecorelib.api.datagen.ISimpleConditionBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

/**
 * Fusion RecipeProvider for HaditeCoal
 */
public class FusionRecipes extends AbstractFusionRecipeProvider
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
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer)
    {
        registerGestankenzinnRecipes(consumer);
        registerHaditeSteelRecipes(consumer);
        registerImprovedOnyxRecyclingRecipes(consumer);
        
        // and one misc recipe for gunpowder:
        consumer.accept(new AbstractFusionRecipeProvider.FinishedFusionRecipe(
                fusionbuilder.make_resource("fusion_furnace/gunpowder"),
                new ItemStack(Items.GUNPOWDER), 600, 6.0F, Ingredient.of(ItemTags.COALS),
                Ingredient.of(ModItems.hadite_coal.get()), Ingredient.of(Items.FLINT)));  
    }
    
    /**
     * Gestankenzinn alloy recipes and recycling recipes.
     * @param consumer
     */
    protected void registerGestankenzinnRecipes(Consumer<FinishedRecipe> consumer)
    {
        // Gestankenzinn alloy recipes
        List<Ingredient> primary_inputs = new ArrayList<Ingredient>(2);
        Ingredient[] catalysts = new Ingredient[3];

        primary_inputs.add(Ingredient.of(ModItems.hadite_coal.get()));
        primary_inputs.add(Ingredient.of(ModTags.Items.INGOTS_TIN));
        catalysts[0] = null;
        catalysts[1] = null;
        catalysts[2] = Ingredient.of(ItemTags.COALS);

        fusionbuilder.buildBasicAlloyRecipes(consumer, primary_inputs, catalysts, null,
                null, ModItems.large_gestankenzinn_chunk.get(), 1.25F, 600,
                flag("gestankenzinn_making_enabled"));
        
        // Gestankenzinn recycling recipes
        fusionbuilder.buildFusionRecyclingRecipes(consumer, 
                Ingredient.of(ModItems.gestankenzinn_axe.get(), 
                        ModItems.gestankenzinn_pickaxe.get(), ModItems.gestankenzinn_shears.get(),
                        ModItems.gestankenzinn_shovel.get(), ModItems.gestankenzinn_sword.get()),
                null, Ingredient.of(Items.GRAVEL), Ingredient.of(ItemTags.COALS), 
                ModItems.large_gestankenzinn_chunk.get(), 20.0F, 600, flag("recycling_enabled"),
                "recycle_gestankenzinn_items");
    } // end registerGestankenzinnRecipes

    
    /**
     * Hadite Steel alloy recipes and recycling recipes.
     * @param consumer
     */
    protected void registerHaditeSteelRecipes(Consumer<FinishedRecipe> consumer)
    {
        // hadite steel alloy recipes
        List<Ingredient> primary_inputs = new ArrayList<Ingredient>(2);
        Ingredient[] catalysts = new Ingredient[3];
        
        primary_inputs.add(Ingredient.of(ModItems.hadite_coal.get()));
        primary_inputs.add(Ingredient.of(Items.IRON_INGOT));
        catalysts[0] = null;
        catalysts[1] = null;
        catalysts[2] = Ingredient.of(Items.GUNPOWDER);
        fusionbuilder.buildBasicAlloyRecipes(consumer, primary_inputs, catalysts, null,
                null, ModItems.large_hadite_steel_chunk.get(), 1.5F, 600,
                flag("hadite_steel_making_enabled"));
       
        // hadite steel recycling recipes
        fusionbuilder.buildFusionRecyclingRecipes(consumer, 
                Ingredient.of(ModItems.hadite_steel_axe.get(), 
                        ModItems.hadite_steel_pickaxe.get(), ModItems.hadite_steel_shears.get(),
                        ModItems.hadite_steel_shovel.get(), ModItems.hadite_steel_sword.get()),
                null, Ingredient.of(Items.GRAVEL), Ingredient.of(ItemTags.COALS), 
                ModItems.large_hadite_steel_chunk.get(), 15.0F, 600, flag("recycling_enabled"),
                "recycle_hadite_steel_items");
        
    } // end registerHaditeSteelRecipes()
    
    /**
     * Improved onyx recycling with hadite coal.
     * @param consumer
     */
    protected void registerImprovedOnyxRecyclingRecipes(Consumer<FinishedRecipe> consumer)
    {
        fusionbuilder.buildFusionRecyclingRecipes(consumer, 
                Ingredient.of(mod.alexndr.simpleores.init.ModItems.onyx_axe.get(),
                        mod.alexndr.simpleores.init.ModItems.onyx_boots.get(),
                        mod.alexndr.simpleores.init.ModItems.onyx_bow.get(),
                        mod.alexndr.simpleores.init.ModItems.onyx_helmet.get(),
                        mod.alexndr.simpleores.init.ModItems.onyx_hoe.get(),
                        mod.alexndr.simpleores.init.ModItems.onyx_pickaxe.get(),
                        mod.alexndr.simpleores.init.ModItems.onyx_rod.get(),
                        mod.alexndr.simpleores.init.ModItems.onyx_shears.get(),
                        mod.alexndr.simpleores.init.ModItems.onyx_shovel.get(),
                        mod.alexndr.simpleores.init.ModItems.onyx_sword.get()),
                Ingredient.of(mod.alexndr.simpleores.init.ModItems.onyx_chestplate.get(),
                        mod.alexndr.simpleores.init.ModItems.onyx_leggings.get()),
                Ingredient.of(Items.NETHERRACK), Ingredient.of(ModItems.hadite_coal.get()),
                mod.alexndr.simpleores.init.ModItems.onyx_gem.get(), 20.0F, 600, 
                and(flag("recycling_enabled"),modLoaded("simpleores")),
                "better_onyx_recycling");
        
        fusionbuilder.buildFusionRecyclingRecipes(consumer, null,
                Ingredient.of(mod.alexndr.simpleores.init.ModBlocks.onyx_door.get().asItem()),
                Ingredient.of(Items.NETHERRACK), Ingredient.of(ModItems.hadite_coal.get()),
                mod.alexndr.simpleores.init.ModItems.onyx_gem.get(), 20.0F, 600, 
                and(flag("recycling_enabled"),modLoaded("aesthetics"),modLoaded("simpleores")),
                "aesthetics_onyx_recycling");
        
        fusionbuilder.buildFusionRecyclingRecipes(consumer, null, 
                Ingredient.of(mod.alexndr.machines.init.ModBlocks.onyx_furnace.get().asItem(),
                        mod.alexndr.machines.init.ModBlocks.onyx_blast_furnace.get().asItem(),
                        mod.alexndr.machines.init.ModBlocks.onyx_smoker.get().asItem()),
                Ingredient.of(Items.NETHERRACK), Ingredient.of(ModItems.hadite_coal.get()),
                mod.alexndr.simpleores.init.ModItems.onyx_gem.get(), 20.0F, 600, 
                and(flag("recycling_enabled"),modLoaded("simple_machines"),modLoaded("simpleores")),
                "onyx_machine_recycling");
                        
    } // end registerImprovedOnyxRecyclingRecipes()
    
    
    /**
     * Builds an ICondition representing FlagCondition...
     *
     */
    @Override
    public ICondition flag(String name)
    {
        return impl_flag(HaditeCoal.MODID, HaditeConfig.INSTANCE, name);
    }

} // end-class FusionRecipes