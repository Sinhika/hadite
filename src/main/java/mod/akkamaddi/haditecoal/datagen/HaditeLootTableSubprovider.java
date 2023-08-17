package mod.akkamaddi.haditecoal.datagen;

import mod.akkamaddi.haditecoal.init.ModBlocks;
import mod.akkamaddi.haditecoal.init.ModItems;
import mod.alexndr.simplecorelib.api.datagen.SimpleBlockLootSubProvider;

public class HaditeLootTableSubprovider extends SimpleBlockLootSubProvider
{

    @Override
    protected void generate()
    {
    	dropSelf(ModBlocks.gestankenzinn_block.get());
    	dropSelf(ModBlocks.hadite_coal_block.get());
    	dropSelf(ModBlocks.hadite_steel_block.get());
    	dropMultiItemsWithFortune(ModBlocks.hadite_coal_ore.get(), ModItems.hadite_coal.get(), 1, 1);
    }

} // end class
