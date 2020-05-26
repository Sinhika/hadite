package mod.akkamaddi.haditecoal.init;

import mod.akkamaddi.haditecoal.HaditeCoal;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModItems
{
    public static final DeferredRegister<Item> ITEMS = 
            new DeferredRegister<>(ForgeRegistries.ITEMS, HaditeCoal.MODID);
    
    // BASIC ITEMS
    // ingots, chunks, and nuggets
    public static final RegistryObject<Item> hadite_coal = ITEMS.register("hadite_coal", 
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));    
    
    public static final RegistryObject<Item> hadite_steel_ingot = ITEMS.register("hadite_steel_ingot", 
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> hadite_steel_nugget = ITEMS.register("hadite_steel_nugget", 
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> large_hadite_steel_chunk = ITEMS.register("large_hadite_steel_chunk", 
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> gestankenzinn_ingot = ITEMS.register("gestankenzinn_ingot", 
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> gestankenzinn_nugget = ITEMS.register("gestankenzinn_nugget", 
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> large_gestankenzinn_chunk = ITEMS.register("large_gestankenzinn_chunk", 
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    
} // end-class
