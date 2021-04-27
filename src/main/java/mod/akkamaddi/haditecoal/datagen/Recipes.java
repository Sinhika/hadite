package mod.akkamaddi.haditecoal.datagen;

import java.util.function.Consumer;

import mod.akkamaddi.haditecoal.HaditeCoal;
import mod.akkamaddi.haditecoal.config.HaditeConfig;
import mod.alexndr.simplecorelib.datagen.ISimpleConditionBuilder;
import mod.alexndr.simplecorelib.datagen.RecipeSetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
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