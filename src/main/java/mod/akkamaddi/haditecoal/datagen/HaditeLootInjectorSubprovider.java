package mod.akkamaddi.haditecoal.datagen;

import java.util.function.BiConsumer;

import mod.akkamaddi.haditecoal.HaditeCoal;
import mod.akkamaddi.haditecoal.init.ModItems;
import mod.alexndr.simplecorelib.api.datagen.LootTableInjectorProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class HaditeLootInjectorSubprovider extends LootTableInjectorProvider
{

    @Override
    public void generate(BiConsumer<ResourceLocation, Builder> bar) 
    {
        // ruined_portal
        LootPool.Builder foo = createChestPool(1, 1, 0.50F)
                .add(LootItem.lootTableItem(ModItems.hadite_coal.get()).setWeight(1)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))));
        addInjectionTable(bar, getInjectionTableId(HaditeCoal.MODID, "ruined_portal"), foo);
        
        foo = createChestPool(1, 1, 0.75F)
                .add(LootItem.lootTableItem(ModItems.hadite_coal.get()).setWeight(1)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 7))));
        addInjectionTable(bar, getInjectionTableId(HaditeCoal.MODID, "bastion"), foo);
                
    } // end getTables

} // end class
