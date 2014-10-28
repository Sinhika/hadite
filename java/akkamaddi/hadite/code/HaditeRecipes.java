package akkamaddi.hadite.code;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import alexndr.SimpleOres.core.Content;
import alexndr.SimpleOres.plugins.fusion.FusionRecipes;
import cpw.mods.fml.common.registry.GameRegistry;

public class HaditeRecipes {
	@SuppressWarnings("unchecked")
	public static void doHaditeRecipes() {
		// Ore Dictionary registry
		OreDictionary.registerOre("haditeCoal", new ItemStack(
				HaditeCoalCore.haditeCoalIngot));
		OreDictionary.registerOre("oreHaditeCoal", new ItemStack(
				HaditeCoalCore.blockHaditeCoalOre));
		OreDictionary.registerOre("ingotHaditeSteel", new ItemStack(
				HaditeCoalCore.haditeSteelIngot));
		OreDictionary.registerOre("ingotGestankenzinn", new ItemStack(
				HaditeCoalCore.gestankenzinnIngot));
		// for AOBD2
		OreDictionary.registerOre("oreHaditeSteel", new ItemStack(
				HaditeCoalCore.largeHaditeSteelChunkItem));
		OreDictionary.registerOre("oreGestankenzinn", new ItemStack(
				HaditeCoalCore.largeGestankenzinnChunkItem));
		
		// wildcard
		final int WILDCARD_VALUE = OreDictionary.WILDCARD_VALUE;
		// Crafting recipes
		// Storage Block
		GameRegistry.addRecipe(new ItemStack(
				HaditeCoalCore.blockHaditeCoalBlock, 1), new Object[] { "AAA",
				"AAA", "AAA", 'A', HaditeCoalCore.haditeCoalIngot });
		GameRegistry.addRecipe(
				new ItemStack(HaditeCoalCore.blockHaditeSteel, 1),
				new Object[] { "AAA", "AAA", "AAA", 'A',
						HaditeCoalCore.haditeSteelIngot });
		GameRegistry.addRecipe(new ItemStack(HaditeCoalCore.blockGestankenzinn,
				1), new Object[] { "AAA", "AAA", "AAA", 'A',
				HaditeCoalCore.gestankenzinnIngot });
		// Item Recipe
		// Ingot Recipe
		GameRegistry.addShapelessRecipe(new ItemStack(
				HaditeCoalCore.haditeCoalIngot, 9),
				new Object[] { HaditeCoalCore.blockHaditeCoalBlock });
		GameRegistry.addShapelessRecipe(new ItemStack(
				HaditeCoalCore.haditeSteelIngot, 9),
				new Object[] { HaditeCoalCore.blockHaditeSteel });
		GameRegistry.addShapelessRecipe(new ItemStack(
				HaditeCoalCore.gestankenzinnIngot, 9),
				new Object[] { HaditeCoalCore.blockGestankenzinn });
		// Tools
		// Hadite Steel Tools
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(HaditeCoalCore.haditeSteelPickaxe,
						true, new Object[] { "XXX", " Y ", " Y ", 'X',
								"ingotHaditeSteel", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(HaditeCoalCore.haditeSteelAxe, true,
						new Object[] { "XX ", "XY ", " Y ", 'X',
								"ingotHaditeSteel", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(HaditeCoalCore.haditeSteelShovel,
						true, new Object[] { "X", "Y", "Y", 'X',
								"ingotHaditeSteel", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(HaditeCoalCore.haditeSteelSword, true,
						new Object[] { "X", "X", "Y", 'X', "ingotHaditeSteel",
								'Y', "stickWood" }));
		// Gestankenzinn Tools
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(HaditeCoalCore.gestankenzinnPickaxe,
						true, new Object[] { "XXX", " Y ", " Y ", 'X',
								"ingotGestankenzinn", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(HaditeCoalCore.gestankenzinnAxe, true,
						new Object[] { "XX ", "XY ", " Y ", 'X',
								"ingotGestankenzinn", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(HaditeCoalCore.gestankenzinnShovel,
						true, new Object[] { "X", "Y", "Y", 'X',
								"ingotGestankenzinn", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(HaditeCoalCore.gestankenzinnSword,
						true, new Object[] { "X", "X", "Y", 'X',
								"ingotGestankenzinn", 'Y', "stickWood" }));
		// torches
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(Blocks.torch, 64),
						true, new Object[] { "YYY", "YXY", "YYY", 'X',
								"haditeCoal", 'Y', "stickWood" }));
		// recipes: Smelting
		GameRegistry.addSmelting(
				HaditeCoalCore.largeHaditeSteelChunkItem, new ItemStack(
						HaditeCoalCore.haditeSteelIngot), 4.0F);
		GameRegistry.addSmelting(
				HaditeCoalCore.largeGestankenzinnChunkItem,
				new ItemStack(HaditeCoalCore.gestankenzinnIngot), 3.0F);
		// Fusion Furnace recipes
		FusionRecipes.addSmelting(
				new ItemStack(Items.flint),
				new ItemStack(HaditeCoalCore.haditeCoalIngot),
				new ItemStack(Items.coal, 1, WILDCARD_VALUE),
				new ItemStack(Items.gunpowder), 6.0F);
		// alloys
		FusionRecipes.addSmelting(
				new ItemStack(Items.iron_ingot),
				new ItemStack(HaditeCoalCore.haditeCoalIngot),
				new ItemStack(Items.gunpowder),
				new ItemStack(HaditeCoalCore.largeHaditeSteelChunkItem), 6.0F);
		FusionRecipes
				.addSmelting(
						new ItemStack(Content.tin_ingot),
						new ItemStack(HaditeCoalCore.haditeCoalIngot),
						new ItemStack(Items.coal, 1, WILDCARD_VALUE),
						new ItemStack(
								HaditeCoalCore.largeGestankenzinnChunkItem),
						5.0F);

		if (HaditeCoalCore.enableRecycling) {
			// Hadite Steel
			FusionRecipes.addSmelting(
					new ItemStack(HaditeCoalCore.haditeSteelSword, 1,
							WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, WILDCARD_VALUE),
					new ItemStack(HaditeCoalCore.largeHaditeSteelChunkItem),
					15.0F);
			FusionRecipes.addSmelting(
					new ItemStack(HaditeCoalCore.haditeSteelShovel, 1,
							WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, WILDCARD_VALUE),
					new ItemStack(HaditeCoalCore.largeHaditeSteelChunkItem),
					15.0F);
			FusionRecipes.addSmelting(
					new ItemStack(HaditeCoalCore.haditeSteelAxe, 1,
							WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, WILDCARD_VALUE),
					new ItemStack(HaditeCoalCore.largeHaditeSteelChunkItem),
					15.0F);
			FusionRecipes.addSmelting(
					new ItemStack(HaditeCoalCore.haditeSteelPickaxe, 1,
							WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, WILDCARD_VALUE),
					new ItemStack(HaditeCoalCore.largeHaditeSteelChunkItem),
					15.0F);
			// Gestankenzinn
			FusionRecipes.addSmelting(
					new ItemStack(HaditeCoalCore.gestankenzinnSword, 1,
							WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, WILDCARD_VALUE),
					new ItemStack(HaditeCoalCore.largeGestankenzinnChunkItem),
					20.0F);
			FusionRecipes.addSmelting(
					new ItemStack(HaditeCoalCore.gestankenzinnShovel, 1,
							WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, WILDCARD_VALUE),
					new ItemStack(HaditeCoalCore.largeGestankenzinnChunkItem),
					20.0F);
			FusionRecipes.addSmelting(
					new ItemStack(HaditeCoalCore.gestankenzinnAxe, 1,
							WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, WILDCARD_VALUE),
					new ItemStack(HaditeCoalCore.largeGestankenzinnChunkItem),
					20.0F);
			FusionRecipes.addSmelting(
					new ItemStack(HaditeCoalCore.gestankenzinnPickaxe, 1,
							WILDCARD_VALUE), new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, WILDCARD_VALUE),
					new ItemStack(HaditeCoalCore.largeGestankenzinnChunkItem),
					20.0F);
			// recycle your Onyx
			FusionRecipes.addSmelting(
					new ItemStack(Content.onyx_helmet, 1,
							WILDCARD_VALUE), new ItemStack(Blocks.netherrack),
					new ItemStack(HaditeCoalCore.haditeCoalIngot),
					new ItemStack(Content.onyx_ore), 20.0F);
			FusionRecipes.addSmelting(
					new ItemStack(Content.onyx_chestplate, 1,
							WILDCARD_VALUE),
					new ItemStack(Blocks.netherrack, 2, 0),
					new ItemStack(HaditeCoalCore.haditeCoalIngot, 2, 0),
					new ItemStack(Content.onyx_ore, 2, 0), 40.0F);
			FusionRecipes.addSmelting(
					new ItemStack(Content.onyx_leggings, 1,
							WILDCARD_VALUE),
					new ItemStack(Blocks.netherrack, 2, 0),
					new ItemStack(HaditeCoalCore.haditeCoalIngot, 2, 0),
					new ItemStack(Content.onyx_ore, 2, 0), 40.0F);
			FusionRecipes.addSmelting(
					new ItemStack(Content.onyx_boots, 1,
							WILDCARD_VALUE), new ItemStack(Blocks.netherrack),
					new ItemStack(HaditeCoalCore.haditeCoalIngot),
					new ItemStack(Content.onyx_ore), 20.0F);
			FusionRecipes.addSmelting(
					new ItemStack(Content.onyx_sword, 1,
							WILDCARD_VALUE), new ItemStack(Blocks.netherrack),
					new ItemStack(HaditeCoalCore.haditeCoalIngot),
					new ItemStack(Content.onyx_ore), 20.0F);
			FusionRecipes.addSmelting(
					new ItemStack(Content.onyx_shovel, 1,
							WILDCARD_VALUE), new ItemStack(Blocks.netherrack),
					new ItemStack(HaditeCoalCore.haditeCoalIngot),
					new ItemStack(Content.onyx_ore), 20.0F);
			FusionRecipes.addSmelting(
					new ItemStack(Content.onyx_pickaxe, 1,
							WILDCARD_VALUE), new ItemStack(Blocks.netherrack),
					new ItemStack(HaditeCoalCore.haditeCoalIngot),
					new ItemStack(Content.onyx_ore), 20.0F);
			FusionRecipes.addSmelting(
					new ItemStack(Content.onyx_axe, 1,
							WILDCARD_VALUE), new ItemStack(Blocks.netherrack),
					new ItemStack(HaditeCoalCore.haditeCoalIngot),
					new ItemStack(Content.onyx_ore), 20.0F);
			FusionRecipes.addSmelting(
					new ItemStack(Content.onyx_hoe, 1,
							WILDCARD_VALUE), new ItemStack(Blocks.netherrack),
					new ItemStack(HaditeCoalCore.haditeCoalIngot),
					new ItemStack(Content.onyx_ore), 20.0F);
			FusionRecipes.addSmelting(
					new ItemStack(Content.onyx_bow, 1,
							WILDCARD_VALUE), new ItemStack(Blocks.netherrack),
					new ItemStack(HaditeCoalCore.haditeCoalIngot),
					new ItemStack(Content.onyx_ore), 20.0F);
			// extra Onyx recycling
			FusionRecipes.addSmelting(
					new ItemStack(Content.onyx_door, 1,
							WILDCARD_VALUE), new ItemStack(Blocks.netherrack),
					new ItemStack(HaditeCoalCore.haditeCoalIngot),
					new ItemStack(Content.onyx_ore), 20.0F);
			FusionRecipes.addSmelting(
					new ItemStack(Content.onyx_rod, 1,
							WILDCARD_VALUE), new ItemStack(Blocks.netherrack),
					new ItemStack(HaditeCoalCore.haditeCoalIngot),
					new ItemStack(Content.onyx_ore), 20.0F);
			FusionRecipes.addSmelting(
					new ItemStack(Content.onyx_shears, 1,
							WILDCARD_VALUE), new ItemStack(Blocks.netherrack),
					new ItemStack(HaditeCoalCore.haditeCoalIngot),
					new ItemStack(Content.onyx_ore), 20.0F);
			FusionRecipes.addSmelting(
					new ItemStack(Content.onyx_furnace, 1,
							WILDCARD_VALUE), new ItemStack(Blocks.netherrack),
					new ItemStack(HaditeCoalCore.haditeCoalIngot),
					new ItemStack(Content.onyx_ore, 2, 0), 40.0F);
		}
	}
}
