package mod.akkamaddi.haditecoal.datagen;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.mojang.datafixers.util.Pair;

import mod.akkamaddi.haditecoal.init.ModBlocks;
import mod.akkamaddi.haditecoal.init.ModItems;
import mod.alexndr.simplecorelib.datagen.BlockLootTableProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.resources.ResourceLocation;

public class HaditeLootTableProvider extends BlockLootTableProvider
{

    public HaditeLootTableProvider(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootContextParamSet>> getTables()
    {
        tables.clear();
        standardDropTable(ModBlocks.gestankenzinn_block.get());
        standardDropTable(ModBlocks.hadite_coal_block.get());
        standardDropTable(ModBlocks.hadite_steel_block.get());
        specialDropTable(ModBlocks.hadite_coal_ore.get(), ModItems.hadite_coal.get());
        return tables;
    }

} // end class
