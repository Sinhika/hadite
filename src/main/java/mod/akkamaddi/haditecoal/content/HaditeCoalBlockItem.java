package mod.akkamaddi.haditecoal.content;

import mod.akkamaddi.haditecoal.config.HaditeConfig;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;

import net.minecraft.world.item.Item.Properties;

public class HaditeCoalBlockItem extends BlockItem
{

    public HaditeCoalBlockItem(Block blockIn, Properties builder)
    {
        super(blockIn, builder);
    }

    @Override
    public int getBurnTime(ItemStack itemStack)
    {
        if (itemStack.getItem() instanceof HaditeCoalBlockItem) {
            return HaditeConfig.haditeCoalBurnTime * 10;
        }
        return super.getBurnTime(itemStack);
    }

    
} // end-class
