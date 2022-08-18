package mod.akkamaddi.haditecoal.content;

import javax.annotation.Nullable;

import mod.akkamaddi.haditecoal.config.HaditeConfig;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.common.extensions.IForgeItem;

import net.minecraft.world.item.Item.Properties;

public class HaditeCoalItem extends Item implements IForgeItem
{

    public HaditeCoalItem(Properties properties)
    {
        super(properties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType)
    {
        if (itemStack.getItem() instanceof HaditeCoalItem) {
            return HaditeConfig.haditeCoalBurnTime;
        }
        return -1;
    }

} // end-class

