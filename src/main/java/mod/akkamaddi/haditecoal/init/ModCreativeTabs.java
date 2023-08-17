package mod.akkamaddi.haditecoal.init;

import mod.akkamaddi.haditecoal.HaditeCoal;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public final class ModCreativeTabs
{
//    public static final CreativeModeTab MOD_ITEM_GROUP =
//            new ModTabGroup(HaditeCoal.MODID, () -> new ItemStack(ModBlocks.hadite_coal_ore.get()));
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = 
			DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HaditeCoal.MODID);
	
	public static final RegistryObject<CreativeModeTab> HADITECOAL_TAB = CREATIVE_MODE_TABS.register("haditecoal_tab",
			() -> CreativeModeTab.builder()
				.title(Component.translatable("item_group." + HaditeCoal.MODID + ".tab"))
				.icon(() -> new ItemStack(ModBlocks.hadite_coal_ore.get()))
				.displayItems((parameters, output) -> {
					output.acceptAll(ModBlocks.BLOCKS.getEntries().stream()
										.map(RegistryObject::get)
										.map(b -> (new ItemStack(b.asItem())))
										.toList()
										);
					output.acceptAll(ModItems.ITEMS.getEntries().stream()
							.map(RegistryObject::get)
							.map(b -> (new ItemStack(b)))
							.toList()
							);
				}).build());

 
} // end class ModCreativeTabs
