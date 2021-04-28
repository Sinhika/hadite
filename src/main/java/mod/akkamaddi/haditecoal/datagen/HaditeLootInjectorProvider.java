package mod.akkamaddi.haditecoal.datagen;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.mojang.datafixers.util.Pair;

import mod.akkamaddi.haditecoal.HaditeCoal;
import mod.akkamaddi.haditecoal.init.ModItems;
import mod.alexndr.simplecorelib.datagen.LootTableInjectorProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.RandomValueRange;
import net.minecraft.loot.LootTable.Builder;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.util.ResourceLocation;

public class HaditeLootInjectorProvider extends LootTableInjectorProvider
{

    public HaditeLootInjectorProvider(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootParameterSet>> getTables()
    {
        tables.clear();
        // ruined_portal
        LootPool.Builder foo = createChestPool(1, 1, 0.50F)
                .add(ItemLootEntry.lootTableItem(ModItems.hadite_coal.get()).setWeight(1)
                        .apply(SetCount.setCount(RandomValueRange.between(2, 4))));
        addInjectionTable(HaditeCoal.MODID, "ruined_portal", foo);
        
        foo = createChestPool(1, 1, 0.75F)
                .add(ItemLootEntry.lootTableItem(ModItems.hadite_coal.get()).setWeight(1)
                        .apply(SetCount.setCount(RandomValueRange.between(4, 7))));
        addInjectionTable(HaditeCoal.MODID, "bastion", foo);
                
        return tables;
    } // end getTables

} // end class
