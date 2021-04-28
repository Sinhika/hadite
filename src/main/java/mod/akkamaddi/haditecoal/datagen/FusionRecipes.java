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
import mod.alexndr.simplecorelib.datagen.ISimpleConditionBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
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
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer)
    {
        registerGestankenzinnRecipes(consumer);
        registerHaditeSteelRecipes(consumer);
    }
    
    /**
     * Gestankenzinn alloy recipes and recycling recipes.
     * @param consumer
     */
    protected void registerGestankenzinnRecipes(Consumer<IFinishedRecipe> consumer)
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
                null, ModItems.large_gestankenzinn_chunk.get(), 5.0F, 600,
                flag("gestankenzinn_making_enabled"));
        
        // Gestankenzinn recycling recipes
        fusionbuilder.buildFusionRecyclingRecipes(consumer, 
                Ingredient.of(ModItems.gestankenzinn_axe.get(), ModItems.gestankenzinn_hoe.get(),
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
    protected void registerHaditeSteelRecipes(Consumer<IFinishedRecipe> consumer)
    {
    } // end registerHaditeSteelRecipes()
    
    
    /**
     * Builds an ICondition representing FlagCondition...
     *
     */
    public ICondition flag(String name)
    {
        return impl_flag(HaditeCoal.MODID, HaditeConfig.INSTANCE, name);
    }

} // end-class FusionRecipes