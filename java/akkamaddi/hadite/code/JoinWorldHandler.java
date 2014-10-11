package akkamaddi.hadite.code;

import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import akkamaddi.akkamaddiCore.api.AkkaJoinWorldHelper;
import alexndr.SimpleOres.core.Content;

public class JoinWorldHandler extends AkkaJoinWorldHelper {

	@Override
	public void EquipMobs(EntityJoinWorldEvent event) 
	{
		int range = random.nextInt(1, 18);
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
            living.setCurrentItemOrArmor(4, new ItemStack(Items.iron_helmet));
            living.setCurrentItemOrArmor(3, new ItemStack(Items.iron_chestplate));
            living.setCurrentItemOrArmor(2, new ItemStack(Items.iron_leggings));
            living.setCurrentItemOrArmor(1, new ItemStack(Items.iron_boots));
            living.setCurrentItemOrArmor(0, new ItemStack(HaditeCoalCore.haditeSteelSword));
        }

        if (range == 10)
        {
            living.setCurrentItemOrArmor(4, new ItemStack(Items.iron_helmet));
            living.setCurrentItemOrArmor(3, new ItemStack(Items.iron_chestplate));
            living.setCurrentItemOrArmor(2, new ItemStack(Items.iron_leggings));
            living.setCurrentItemOrArmor(1, new ItemStack(Items.iron_boots));
            living.setCurrentItemOrArmor(0, new ItemStack(HaditeCoalCore.haditeSteelSword));
        }

        if (range == 11)
        {
            living.setCurrentItemOrArmor(4, new ItemStack(Items.iron_helmet));
            living.setCurrentItemOrArmor(1, new ItemStack(Items.iron_boots));
            living.setCurrentItemOrArmor(0, new ItemStack(HaditeCoalCore.haditeSteelPickaxe));
        }

        if (range == 12)
        {
            living.setCurrentItemOrArmor(4, new ItemStack(Items.iron_helmet));
            living.setCurrentItemOrArmor(3, new ItemStack(Items.iron_chestplate));
            living.setCurrentItemOrArmor(0, new ItemStack(HaditeCoalCore.haditeSteelAxe));
        }

        if (range == 13)
        {
            living.setCurrentItemOrArmor(4, new ItemStack(Items.iron_helmet));
            living.setCurrentItemOrArmor(1, new ItemStack(Items.iron_boots));
            living.setCurrentItemOrArmor(0, new ItemStack(HaditeCoalCore.haditeSteelShovel));
        }

        if (range == 14)
        {
            living.setCurrentItemOrArmor(4, new ItemStack(Items.iron_helmet));
            living.setCurrentItemOrArmor(3, new ItemStack(Items.iron_chestplate));
            living.setCurrentItemOrArmor(2, new ItemStack(Items.iron_leggings));
            living.setCurrentItemOrArmor(1, new ItemStack(Items.iron_boots));
            living.setCurrentItemOrArmor(0, new ItemStack(HaditeCoalCore.gestankenzinnSword));
        }

        if (range == 15)
        {
            living.setCurrentItemOrArmor(4, new ItemStack(Content.tin_helmet));
            living.setCurrentItemOrArmor(3, new ItemStack(Content.tin_chestplate));
            living.setCurrentItemOrArmor(2, new ItemStack(Content.tin_leggings));
            living.setCurrentItemOrArmor(1, new ItemStack(Content.tin_boots));
            living.setCurrentItemOrArmor(0, new ItemStack(HaditeCoalCore.gestankenzinnSword));
        }

        if (range == 16)
        {
            living.setCurrentItemOrArmor(4, new ItemStack(Content.tin_helmet));
            living.setCurrentItemOrArmor(1, new ItemStack(Content.tin_boots));
            living.setCurrentItemOrArmor(0, new ItemStack(HaditeCoalCore.gestankenzinnPickaxe));
        }

        if (range == 17)
        {
            living.setCurrentItemOrArmor(4, new ItemStack(Content.tin_helmet));
            living.setCurrentItemOrArmor(3, new ItemStack(Content.tin_chestplate));
            living.setCurrentItemOrArmor(0, new ItemStack(HaditeCoalCore.gestankenzinnAxe));
        }

        if (range == 18)
        {
            living.setCurrentItemOrArmor(4, new ItemStack(Content.tin_helmet));
            living.setCurrentItemOrArmor(1, new ItemStack(Content.tin_boots));
            living.setCurrentItemOrArmor(0, new ItemStack(HaditeCoalCore.gestankenzinnShovel));
        }

	}

}
