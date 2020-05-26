package mod.akkamaddi.haditecoal.content;

import java.util.function.Supplier;

import mod.akkamaddi.haditecoal.init.ModItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

public enum HaditeCoalItemTier implements IItemTier 
{
    HADITESTEEL(3, 520, 6.5F, 2.0F, 13, ()->{ return Ingredient.fromItems(ModItems.hadite_steel_ingot.get());}),
    GESTANKENZINN(2, 400, 4.0F, 1.0F, 13, ()->{return Ingredient.fromItems(ModItems.gestankenzinn_ingot.get());});
    
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;

    private HaditeCoalItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability,
            Supplier<Ingredient> repairMaterial)
    {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyValue<>(repairMaterial);
    }

    @Override
    public int getMaxUses() {
        return maxUses;
    }

    @Override
    public float getEfficiency() {
        return efficiency;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return repairMaterial.getValue();
    }
} // end-enum
