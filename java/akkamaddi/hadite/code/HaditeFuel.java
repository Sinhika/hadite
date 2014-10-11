package akkamaddi.hadite.code;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class HaditeFuel implements IFuelHandler
{
    @Override
    public int getBurnTime(ItemStack fuel)
    {
        if (fuel.getItem() == HaditeCoalCore.haditeCoalIngot)
        {
            return 13000;
        }

        if (fuel.getItem() == Item.getItemFromBlock(HaditeCoalCore.blockHaditeCoalBlock))
        {
            return 130000;
        }

        return 0;
    }
}
