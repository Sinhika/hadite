package mod.akkamaddi.haditecoal.init;

import mod.akkamaddi.haditecoal.HaditeCoal;
import mod.akkamaddi.haditecoal.content.HaditeCoalBlockItem;
import mod.akkamaddi.haditecoal.content.HaditeCoalItem;
import mod.akkamaddi.haditecoal.content.HaditeCoalItemTier;
import mod.alexndr.fusion.init.ModTabGroups;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShearsItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModItems
{
    public static final DeferredRegister<Item> ITEMS = 
            new DeferredRegister<>(ForgeRegistries.ITEMS, HaditeCoal.MODID);
    
    // BASIC ITEMS
    // hadite coal block item is a special snowflake that needs an item to define burn-time.
    public static final RegistryObject<HaditeCoalBlockItem> hadite_coal_block = 
            ITEMS.register("hadite_coal_block",
                    () -> new HaditeCoalBlockItem(ModBlocks.hadite_coal_block.get(), 
                                              new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    
    // ingots, chunks, and nuggets
    public static final RegistryObject<HaditeCoalItem> hadite_coal = ITEMS.register("hadite_coal", 
            () -> new HaditeCoalItem(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));    
    
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
    
    // TOOLS
    // gestankenzinn
    public static final RegistryObject<SwordItem> gestankenzinn_sword = ITEMS.register("gestankenzinn_sword",
            () -> new SwordItem(HaditeCoalItemTier.GESTANKENZINN, 3, -2.4F,
                                new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<PickaxeItem> gestankenzinn_pickaxe = ITEMS.register("gestankenzinn_pickaxe",
            () -> new PickaxeItem(HaditeCoalItemTier.GESTANKENZINN, 1, -2.8F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<AxeItem> gestankenzinn_axe = ITEMS.register("gestankenzinn_axe",
            () -> new AxeItem(HaditeCoalItemTier.GESTANKENZINN, 7.0F, -3.1F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ShovelItem> gestankenzinn_shovel = ITEMS.register("gestankenzinn_shovel",
            () -> new ShovelItem(HaditeCoalItemTier.GESTANKENZINN, 1.5F, -3.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<HoeItem> gestankenzinn_hoe = ITEMS.register("gestankenzinn_hoe",
            () -> new HoeItem(HaditeCoalItemTier.GESTANKENZINN,-2.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ShearsItem> gestankenzinn_shears = ITEMS.register("gestankenzinn_shears",
            () -> new ShearsItem(new Item.Properties().maxDamage(HaditeCoalItemTier.GESTANKENZINN.getMaxUses())
                    .group(ModTabGroups.MOD_ITEM_GROUP)));
 
    // hadite steel
    public static final RegistryObject<SwordItem> hadite_steel_sword = ITEMS.register("hadite_steel_sword",
            () -> new SwordItem(HaditeCoalItemTier.HADITESTEEL, 3, -2.4F,
                                new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<PickaxeItem> hadite_steel_pickaxe = ITEMS.register("hadite_steel_pickaxe",
            () -> new PickaxeItem(HaditeCoalItemTier.HADITESTEEL, 1, -2.8F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<AxeItem> hadite_steel_axe = ITEMS.register("hadite_steel_axe",
            () -> new AxeItem(HaditeCoalItemTier.HADITESTEEL, 7.0F, -3.1F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ShovelItem> hadite_steel_shovel = ITEMS.register("hadite_steel_shovel",
            () -> new ShovelItem(HaditeCoalItemTier.HADITESTEEL, 1.5F, -3.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<HoeItem> hadite_steel_hoe = ITEMS.register("hadite_steel_hoe",
            () -> new HoeItem(HaditeCoalItemTier.HADITESTEEL,-2.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ShearsItem> hadite_steel_shears = ITEMS.register("hadite_steel_shears",
            () -> new ShearsItem(new Item.Properties().maxDamage(HaditeCoalItemTier.HADITESTEEL.getMaxUses())
                    .group(ModTabGroups.MOD_ITEM_GROUP)));
    
} // end-class
