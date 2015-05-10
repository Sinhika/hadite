package akkamaddi.plugins.hadite;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class HaditeFuel implements IFuelHandler
{
    @Override
    public int getBurnTime(ItemStack fuel)
    {
        if (fuel.getItem() == Content.haditeCoalIngot)
        {
            return Settings.haditeCoalBurnTime;
        }

        if (fuel.getItem() == Item.getItemFromBlock(Content.blockHaditeCoalBlock))
        {
            return Settings.haditeCoalBurnTime * 10;
        }

        return 0;
    }
} // end class HaditeFuel
