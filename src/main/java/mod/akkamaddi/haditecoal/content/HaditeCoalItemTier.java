package mod.akkamaddi.haditecoal.content;

import java.util.function.Supplier;

import mod.akkamaddi.haditecoal.init.ModItems;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadedValue;

public enum HaditeCoalItemTier implements Tier 
{
    HADITESTEEL(3, 520, 6.5F, 2.0F, 13, ()->{ return Ingredient.of(ModItems.hadite_steel_ingot.get());}),
    GESTANKENZINN(2, 400, 4.0F, 1.0F, 13, ()->{return Ingredient.of(ModItems.gestankenzinn_ingot.get());});
    
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyLoadedValue<Ingredient> repairMaterial;

    private HaditeCoalItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability,
            Supplier<Ingredient> repairMaterial)
    {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyLoadedValue<>(repairMaterial);
    }

    @Override
    public int getUses() {
        return maxUses;
    }

    @Override
    public float getSpeed() {
        return efficiency;
    }

    @Override
    public float getAttackDamageBonus() {
        return attackDamage;
    }

    @Override
    public int getLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairMaterial.get();
    }
} // end-enum
