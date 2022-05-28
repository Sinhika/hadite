package mod.akkamaddi.haditecoal.init;

import mod.akkamaddi.haditecoal.HaditeCoal;
import mod.akkamaddi.haditecoal.config.HaditeConfig;
import mod.alexndr.simplecorelib.api.helpers.OreGenUtils;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures
{
    /** ConfiguredFeature<?, ?> registry */
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, HaditeCoal.MODID);
 
    public static RegistryObject<ConfiguredFeature<OreConfiguration, ?>> ORE_HADITE_COAL =
            CONFIGURED_FEATURES.register("ore_hadite_coal", 
                    () -> OreGenUtils.createConfiguredOreFeature(
                            OreGenUtils.BuildNetherOreTargetList(ModBlocks.hadite_coal_ore.get(), true),
                            HaditeConfig.hadite_cfg));

    /** PlacedFeature registry */
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, HaditeCoal.MODID);

    public static RegistryObject<PlacedFeature> HADITE_DEPOSIT = PLACED_FEATURES.register("hadite_deposit", 
            ()-> OreGenUtils.createPlacedOreFeature(ORE_HADITE_COAL.getHolder().get(), HaditeConfig.hadite_cfg));

} // end class
