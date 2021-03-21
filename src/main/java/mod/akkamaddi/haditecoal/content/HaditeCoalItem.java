package mod.akkamaddi.haditecoal.content;

import mod.akkamaddi.haditecoal.config.HaditeConfig;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.extensions.IForgeItem;

public class HaditeCoalItem extends Item implements IForgeItem
{

    public HaditeCoalItem(Properties properties)
    {
        super(properties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack)
    {
        if (itemStack.getItem() instanceof HaditeCoalItem) {
            return HaditeConfig.haditeCoalBurnTime;
        }
        return -1;
    }

} // end-class

