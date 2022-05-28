package mod.akkamaddi.haditecoal.content;

import java.util.List;

import mod.akkamaddi.haditecoal.HaditeCoal;
import mod.akkamaddi.haditecoal.init.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

public final class HaditeCoalItemTiers
{
    public static final TagKey<Block> HADITESTEEL_TAG = 
            BlockTags.create(new ResourceLocation(HaditeCoal.MODID, "needs_haditesteel_tool"));
    public static final TagKey<Block> GESTANKENZINN_TAG = 
            BlockTags.create(new ResourceLocation(HaditeCoal.MODID, "needs_gestankenzinn_tool"));

    public static final Tier HADITESTEEL = TierSortingRegistry.registerTier(
            new ForgeTier(Tiers.DIAMOND.getLevel(), 520, 6.5F, 2.0F, 13, HADITESTEEL_TAG, 
                        ()->Ingredient.of( ModItems.hadite_steel_ingot.get())),
            new ResourceLocation(HaditeCoal.MODID, "haditesteel"), List.of(Tiers.DIAMOND), List.of(Tiers.NETHERITE));
    public static final Tier GESTANKENZINN = TierSortingRegistry.registerTier(
            new ForgeTier(Tiers.IRON.getLevel(), 400, 4.0F, 1.0F, 13, GESTANKENZINN_TAG, 
                        ()->Ingredient.of( ModItems.gestankenzinn_ingot.get())),
            new ResourceLocation(HaditeCoal.MODID, "gestankenzinn"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));
} // end-enum
