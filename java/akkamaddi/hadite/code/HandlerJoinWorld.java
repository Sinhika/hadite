package akkamaddi.hadite.code;

import java.util.Random;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import alexndr.SimpleOres.api.helpers.CoreHelper;
import net.minecraft.item.Item;

public class HandlerJoinWorld
{
    public static double rand;
    public static int range;

    public static RandomRange random = new RandomRange();

    /**
     * This class allows zombies and skeletons to spawn holding/wearing SimpleOres items.
     */
    @ForgeSubscribe
    public void EntityJoinWorldEvent(EntityJoinWorldEvent event)
    {
        rand = Math.random();
        range = random.nextInt(1, 18);

        if ((rand <= 0.02D) && ((event.entity instanceof EntityLiving)) && ((event.entity instanceof EntitySkeleton | event.entity instanceof EntityZombie)))
        {
            EntityLiving living = (EntityLiving)event.entity;

            if (range == 1)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(HaditeCoalCore.haditeSteelSword));
            }

            if (range == 2)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(HaditeCoalCore.haditeSteelPickaxe));
            }

            if (range == 3)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(HaditeCoalCore.gestankenzinnSword));
            }

            if (range == 4)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(HaditeCoalCore.gestankenzinnPickaxe));
            }

            if (range == 5)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(HaditeCoalCore.haditeSteelAxe));
            }

            if (range == 6)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(HaditeCoalCore.haditeSteelShovel));
            }

            if (range == 7)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(HaditeCoalCore.gestankenzinnAxe));
            }

            if (range == 8)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(HaditeCoalCore.gestankenzinnShovel));
            }

            if (range == 9)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(Item.helmetIron));
                living.setCurrentItemOrArmor(3, new ItemStack(Item.plateIron));
                living.setCurrentItemOrArmor(2, new ItemStack(Item.legsIron));
                living.setCurrentItemOrArmor(1, new ItemStack(Item.bootsIron));
                living.setCurrentItemOrArmor(0, new ItemStack(HaditeCoalCore.haditeSteelSword));
            }

            if (range == 10)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(Item.helmetIron));
                living.setCurrentItemOrArmor(3, new ItemStack(Item.plateIron));
                living.setCurrentItemOrArmor(2, new ItemStack(Item.legsIron));
                living.setCurrentItemOrArmor(1, new ItemStack(Item.bootsIron));
                living.setCurrentItemOrArmor(0, new ItemStack(HaditeCoalCore.haditeSteelSword));
            }

            if (range == 11)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(Item.helmetIron));
                living.setCurrentItemOrArmor(1, new ItemStack(Item.bootsIron));
                living.setCurrentItemOrArmor(0, new ItemStack(HaditeCoalCore.haditeSteelPickaxe));
            }

            if (range == 12)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(Item.helmetIron));
                living.setCurrentItemOrArmor(3, new ItemStack(Item.plateIron));
                living.setCurrentItemOrArmor(0, new ItemStack(HaditeCoalCore.haditeSteelAxe));
            }

            if (range == 13)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(Item.helmetIron));
                living.setCurrentItemOrArmor(1, new ItemStack(Item.bootsIron));
                living.setCurrentItemOrArmor(0, new ItemStack(HaditeCoalCore.haditeSteelShovel));
            }

            if (range == 14)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(Item.helmetIron));
                living.setCurrentItemOrArmor(3, new ItemStack(Item.plateIron));
                living.setCurrentItemOrArmor(2, new ItemStack(Item.legsIron));
                living.setCurrentItemOrArmor(1, new ItemStack(Item.bootsIron));
                living.setCurrentItemOrArmor(0, new ItemStack(HaditeCoalCore.gestankenzinnSword));
            }

            if (range == 15)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(CoreHelper.coreContent.tinHelm));
                living.setCurrentItemOrArmor(3, new ItemStack(CoreHelper.coreContent.tinChest));
                living.setCurrentItemOrArmor(2, new ItemStack(CoreHelper.coreContent.tinLegs));
                living.setCurrentItemOrArmor(1, new ItemStack(CoreHelper.coreContent.tinBoots));
                living.setCurrentItemOrArmor(0, new ItemStack(HaditeCoalCore.gestankenzinnSword));
            }

            if (range == 16)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(CoreHelper.coreContent.tinHelm));
                living.setCurrentItemOrArmor(1, new ItemStack(CoreHelper.coreContent.tinBoots));
                living.setCurrentItemOrArmor(0, new ItemStack(HaditeCoalCore.gestankenzinnPickaxe));
            }

            if (range == 17)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(CoreHelper.coreContent.tinHelm));
                living.setCurrentItemOrArmor(3, new ItemStack(CoreHelper.coreContent.tinChest));
                living.setCurrentItemOrArmor(0, new ItemStack(HaditeCoalCore.gestankenzinnAxe));
            }

            if (range == 18)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(CoreHelper.coreContent.tinHelm));
                living.setCurrentItemOrArmor(1, new ItemStack(CoreHelper.coreContent.tinBoots));
                living.setCurrentItemOrArmor(0, new ItemStack(HaditeCoalCore.gestankenzinnShovel));
            }
        }
    }
}

class RandomRange extends Random
{
    public int nextInt(int min, int max)
    {
        return nextInt(max - min + 1) + min;
    }
}