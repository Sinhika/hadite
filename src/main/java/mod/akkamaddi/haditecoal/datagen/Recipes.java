package mod.akkamaddi.haditecoal.datagen;

import java.util.function.Consumer;

import mod.akkamaddi.haditecoal.HaditeCoal;
import mod.akkamaddi.haditecoal.config.HaditeConfig;
import mod.akkamaddi.haditecoal.init.ModBlocks;
import mod.akkamaddi.haditecoal.init.ModItems;
import mod.alexndr.simplecorelib.datagen.ISimpleConditionBuilder;
import mod.alexndr.simplecorelib.datagen.RecipeSetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

/**
 * Basic RecipeProvider for Fusion.
 * 
 * @author Sinhika
 *
 */
public class Recipes extends RecipeProvider implements IConditionBuilder, ISimpleConditionBuilder
{
    private RecipeSetBuilder setbuilder;

    public Recipes(DataGenerator generatorIn)
    {
        super(generatorIn);
        setbuilder = new RecipeSetBuilder(HaditeCoal.MODID);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer)
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
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.gestankenzinn_ingot.get(),
                ModBlocks.gestankenzinn_block.get().asItem(), ModItems.gestankenzinn_nugget.get(),
                has(ModItems.gestankenzinn_ingot.get()));
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.hadite_steel_ingot.get(),
                ModBlocks.hadite_steel_block.get().asItem(), ModItems.hadite_steel_nugget.get(),
                has(ModItems.hadite_steel_ingot.get()));
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.hadite_coal.get(),
                ModBlocks.hadite_coal_block.get().asItem(), null, has(ModItems.hadite_coal.get()));
    } // end registerStorageRecipes()

    protected void registerMiscRecipes(Consumer<IFinishedRecipe> consumer)
    {
        ShapedRecipeBuilder.shaped(Items.TORCH, 64)
            .define('Y', Ingredient.of(Tags.Items.RODS_WOODEN))
            .define('#', ModItems.hadite_coal.get())
            .pattern("YYY")
            .pattern("Y#Y")
            .pattern("YYY")
            .unlockedBy("has_item", has(ModItems.hadite_coal.get()))
            .save(consumer, setbuilder.make_resource("torch"));
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