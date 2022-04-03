package mod.akkamaddi.haditecoal.datagen;

import java.util.function.Consumer;

import mod.akkamaddi.haditecoal.HaditeCoal;
import mod.akkamaddi.haditecoal.config.HaditeConfig;
import mod.akkamaddi.haditecoal.init.ModBlocks;
import mod.akkamaddi.haditecoal.init.ModItems;
import mod.alexndr.simplecorelib.datagen.ISimpleConditionBuilder;
import mod.alexndr.simplecorelib.datagen.RecipeSetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
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
    protected void buildShapelessRecipes(Consumer<FinishedRecipe> consumer)
    {
        registerStorageRecipes(consumer);
        registerMiscRecipes(consumer);
        registerToolRecipes(consumer);
        registerFurnaceRecipes(consumer);
        registerVanillaRecyclingRecipes(consumer);
    } // end registerRecipes()

    protected void registerVanillaRecyclingRecipes(Consumer<FinishedRecipe> consumer)
    {
        setbuilder.buildVanillaRecyclingRecipes(consumer, Ingredient.of(ModItems.gestankenzinn_axe.get(), 
                ModItems.gestankenzinn_hoe.get(), ModItems.gestankenzinn_pickaxe.get(), ModItems.gestankenzinn_shears.get(),
                ModItems.gestankenzinn_shovel.get(), ModItems.gestankenzinn_sword.get()), 
                ModItems.gestankenzinn_nugget.get(), has(ModItems.gestankenzinn_axe.get()), 
                0.2F, 200);   
        setbuilder.buildVanillaRecyclingRecipes(consumer, Ingredient.of(ModItems.hadite_steel_axe.get(), 
                ModItems.hadite_steel_hoe.get(), ModItems.hadite_steel_pickaxe.get(), ModItems.hadite_steel_shears.get(),
                ModItems.hadite_steel_shovel.get(), ModItems.hadite_steel_sword.get()), 
                ModItems.hadite_steel_nugget.get(), has(ModItems.hadite_steel_axe.get()), 
                0.2F, 200);   
        
    } // end registerVanillaRecyclingRecipes()
    
    
    protected void registerToolRecipes(Consumer<FinishedRecipe> consumer)
    {
        setbuilder.buildSimpleToolSet(consumer, Ingredient.of(ModItems.gestankenzinn_ingot.get()), "gestankenzinn", 
                has(ModItems.gestankenzinn_ingot.get()), flag("gestankenzinn_tools_enabled"), true);
        setbuilder.buildSimpleToolSet(consumer, Ingredient.of(ModItems.hadite_steel_ingot.get()), "hadite_steel", 
                has(ModItems.hadite_steel_ingot.get()), flag("hadite_steel_tools_enabled"), true);
    } // end registerToolRecipes()

    protected void registerStorageRecipes(Consumer<FinishedRecipe> consumer)
    {
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.gestankenzinn_ingot.get(),
                ModBlocks.gestankenzinn_block.get().asItem(), ModItems.gestankenzinn_nugget.get(),
                has(ModItems.gestankenzinn_ingot.get()));
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.hadite_steel_ingot.get(),
                ModBlocks.hadite_steel_block.get().asItem(), ModItems.hadite_steel_nugget.get(),
                has(ModItems.hadite_steel_ingot.get()));
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.hadite_coal.get(),
                ModBlocks.hadite_coal_block.get().asItem(), null, has(ModItems.hadite_coal.get()));
        setbuilder.buildChunkConversionRecipes(consumer, ModItems.gestankenzinn_nugget.get(), null, 
                ModItems.large_gestankenzinn_chunk.get(), has(ModItems.gestankenzinn_nugget.get()));
        setbuilder.buildChunkConversionRecipes(consumer, ModItems.hadite_steel_nugget.get(), null, 
                ModItems.large_hadite_steel_chunk.get(), has(ModItems.hadite_steel_nugget.get()));
    } // end registerStorageRecipes()

    protected void registerMiscRecipes(Consumer<FinishedRecipe> consumer)
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

    protected void registerFurnaceRecipes(Consumer<FinishedRecipe> consumer)
    {
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModItems.large_gestankenzinn_chunk.get()), 
                ModItems.gestankenzinn_ingot.get(), has(ModItems.large_gestankenzinn_chunk.get()), 
                0.7F, 200);
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModItems.large_hadite_steel_chunk.get()), 
                ModItems.hadite_steel_ingot.get(), has(ModItems.large_hadite_steel_chunk.get()), 
                0.7F, 200);
       
    } // end registerFurnaceRecipes()

    @Override
    public ICondition flag(String name)
    {
        return impl_flag(HaditeCoal.MODID, HaditeConfig.INSTANCE, name);
    }

} // end subclass Recipes