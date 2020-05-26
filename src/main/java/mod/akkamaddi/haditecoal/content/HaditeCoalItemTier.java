package mod.akkamaddi.haditecoal.content;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

public enum HaditeCoalItemTier implements IItemTier 
{
    HADITESTEEL(3, 520, 6.5F, 2.0F, 13, ()->{ return Ingredient.fromItems();}),
    GESTANKENZINN(2, 400, 4.0F, 1.0F, 13, ()->{return Ingredient.fromItems();});
    
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;

    private HaditeCoalItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability,
            LazyValue<Ingredient> repairMaterial)
    {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getMaxUses()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public float getEfficiency()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public float getAttackDamage()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getHarvestLevel()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getEnchantability()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Ingredient getRepairMaterial()
    {
        // TODO Auto-generated method stub
        return null;
    }

} // end-enum
