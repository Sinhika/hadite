package akkamaddi.hadite.code;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import akkamaddi.akkamaddiCore.api.APIcore;
import akkamaddi.akkamaddiCore.api.CommonProxy;
import alexndr.SimpleOres.api.content.SimpleAxe;
import alexndr.SimpleOres.api.content.SimpleBlock;
import alexndr.SimpleOres.api.content.SimpleIngot;
import alexndr.SimpleOres.api.content.SimplePickaxe;
import alexndr.SimpleOres.api.content.SimpleShovel;
import alexndr.SimpleOres.api.content.SimpleSword;
import alexndr.SimpleOres.api.content.SimpleTab;
import alexndr.SimpleOres.api.helpers.LootHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "haditecoal", name = "Hadite Coal, nether utility ore", 
	version = "1.2.0", 
	dependencies = "required-after:simpleores ; required-after:fusionplugin ; required-after:akkamaddicore")

public class HaditeCoalCore
{
    // The instance of your mod that Forge uses.
    @Instance(value = "haditecoal")
    public static HaditeCoalCore instance;

    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide = "akkamaddi.hadite.code.ClientProxy", 
    		serverSide = "akkamaddi.akkamaddiCore.api.CommonProxy")
    public static CommonProxy proxy;

     // set names

    // Hadite
    public static Item haditeCoalIngot;

    //Hadite Steel
    public static Item haditeSteelIngot;
    public static Item largeHaditeSteelChunkItem;

    public static Item haditeSteelSword;
    public static Item haditeSteelShovel;
    public static Item haditeSteelAxe;
    public static Item haditeSteelPickaxe;

    //Gestankenzinn
    public static Item gestankenzinnIngot;
    public static Item largeGestankenzinnChunkItem;

    public static Item gestankenzinnSword;
    public static Item gestankenzinnShovel;
    public static Item gestankenzinnAxe;
    public static Item gestankenzinnPickaxe;

    //blocks
    public static Block blockHaditeCoalOre;
    public static Block blockHaditeCoalBlock;
    public static Block blockHaditeSteel;
    public static Block blockGestankenzinn;

    // spawning
    public static int haditeSpawnRate;
    public static int haditeVeinSize;
    public static int haditeSpawnHeight;

    // Booleans
    public static boolean MakeOreFlame;
    public static boolean MakeBlockFlame;

    public static boolean enableRecycling;

    // tab
    public static SimpleTab tabAkkamaddiHadite = new SimpleTab("tabAkkamaddiHadite");

    // set tool properties
    // EnumToolMaterial. In form ("NAME", mining level, max uses, speed, damage to entity, enchantability)
    public static ToolMaterial toolHaditeSteel = EnumHelper.addToolMaterial("HADITESTEEL", 3, 520, 6.5F, 2, 13);
    public static ToolMaterial toolGestankenzinn = EnumHelper.addToolMaterial("GESTANKENZINN", 2, 400, 4.0F, 1, 13);

    // Tab
    public void setTabIcons()
    {
        /**
         * Creating the custom tabs using the API class "SimpleTab" and setting their icon.
         */
        tabAkkamaddiHadite.setIcon(new ItemStack(HaditeCoalCore.blockHaditeCoalOre));
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        // Stub Method
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        MakeOreFlame = config.get(Configuration.CATEGORY_GENERAL, "Hadite Ore spits fire", true).getBoolean(true);
        MakeBlockFlame = config.get(Configuration.CATEGORY_GENERAL, "Hadite Block emits flames", true).getBoolean(true);
        //Adjustable Ore Spawn Rates
        haditeSpawnRate = config.get("4 Spawning parameters", "Hadite Coal Spawn Rate", 5).getInt();
        //Adjustable Ore Vein Sizes
        haditeVeinSize = config.get("4 Spawning parameters", "Hadite Coal Vein Size", 17).getInt();
        //Adjustable Ore Spawn Heights
        haditeSpawnHeight = config.get("4 Spawning parameters", "Hadite Coal Spawn Height", 256).getInt();
        //Recycling
        enableRecycling = config.get(Configuration.CATEGORY_GENERAL, "Enable Hadite Steel & Gestankenzinn item recycling recipes: false or true?", false).getBoolean(false);
        //
        // end config
        config.save();
        //
        // Define Items
		haditeCoalIngot = new SimpleIngot().modId("haditecoal")
				.setCreativeTab(HaditeCoalCore.tabAkkamaddiHadite)
				.setUnlocalizedName("haditeCoalIngot");
		
		// Hadite Steel
		haditeSteelIngot = new SimpleIngot().modId("haditecoal")
				.setCreativeTab(HaditeCoalCore.tabAkkamaddiHadite)
				.setUnlocalizedName("haditeSteelIngot");
		largeHaditeSteelChunkItem = new SimpleIngot().modId("haditecoal")
				.setCreativeTab(HaditeCoalCore.tabAkkamaddiHadite)
				.setUnlocalizedName("largeHaditeSteelChunkItem");
		haditeSteelSword = new SimpleSword(toolHaditeSteel).modId("haditecoal")
				.setCreativeTab(HaditeCoalCore.tabAkkamaddiHadite)
				.setUnlocalizedName("haditeSteelSword");
		haditeSteelShovel = new SimpleShovel(toolHaditeSteel)
				.modId("haditecoal")
				.setCreativeTab(HaditeCoalCore.tabAkkamaddiHadite)
				.setUnlocalizedName("haditeSteelShovel");
		haditeSteelAxe = new SimpleAxe(toolHaditeSteel).modId("haditecoal")
				.setCreativeTab(HaditeCoalCore.tabAkkamaddiHadite)
				.setUnlocalizedName("haditeSteelAxe");
		haditeSteelPickaxe = new SimplePickaxe(toolHaditeSteel)
				.modId("haditecoal")
				.setCreativeTab(HaditeCoalCore.tabAkkamaddiHadite)
				.setUnlocalizedName("haditeSteelPickaxe");
		
		// Gestankenzinn
		gestankenzinnIngot = new SimpleIngot().modId("haditecoal")
				.setCreativeTab(HaditeCoalCore.tabAkkamaddiHadite)
				.setUnlocalizedName("gestankenzinnIngot");
		largeGestankenzinnChunkItem = new SimpleIngot().modId("haditecoal")
				.setCreativeTab(HaditeCoalCore.tabAkkamaddiHadite)
				.setUnlocalizedName("largeGestankenzinnChunkItem");
		gestankenzinnSword = new SimpleSword(toolGestankenzinn)
				.modId("haditecoal")
				.setCreativeTab(HaditeCoalCore.tabAkkamaddiHadite)
				.setUnlocalizedName("gestankenzinnSword");
		gestankenzinnShovel = new SimpleShovel(toolGestankenzinn)
				.modId("haditecoal")
				.setCreativeTab(HaditeCoalCore.tabAkkamaddiHadite)
				.setUnlocalizedName("gestankenzinnShovel");
		gestankenzinnAxe = new SimpleAxe(toolGestankenzinn).modId("haditecoal")
				.setCreativeTab(HaditeCoalCore.tabAkkamaddiHadite)
				.setUnlocalizedName("gestankenzinnAxe");
		gestankenzinnPickaxe = new SimplePickaxe(toolGestankenzinn)
				.modId("haditecoal")
				.setCreativeTab(HaditeCoalCore.tabAkkamaddiHadite)
				.setUnlocalizedName("gestankenzinnPickaxe");
       
        // define blocks
		blockHaditeCoalOre = new HaditeOreBlock(Material.rock, "haditecoal")
				.setHardness(4.0F).setResistance(6.0F)
				.setStepSound(Block.soundTypeStone)
				.setBlockName("blockHaditeCoalOre")
				.setCreativeTab(HaditeCoalCore.tabAkkamaddiHadite)
				.setLightLevel(0.6F);
		((SimpleBlock) blockHaditeCoalOre).setStackToDrop(new ItemStack(haditeCoalIngot));

		blockHaditeCoalBlock = new HaditeStorageBlock(Material.rock,
				"haditecoal").setHardness(4.0F).setResistance(6.0F)
				.setStepSound(Block.soundTypeStone)
				.setBlockName("blockHaditeCoalBlock")
				.setCreativeTab(HaditeCoalCore.tabAkkamaddiHadite)
				.setLightLevel(0.7F);
		blockHaditeSteel = new SimpleBlock(Material.iron).modId("haditecoal")
				.setCreativeTab(HaditeCoalCore.tabAkkamaddiHadite)
				.setHardness(14.0F).setResistance(22.0F)
				.setStepSound(Block.soundTypeMetal)
				.setBlockName("blockHaditeSteel")
				.setCreativeTab(HaditeCoalCore.tabAkkamaddiHadite);
		blockGestankenzinn = new SimpleBlock(Material.iron).modId("haditecoal")
				.setCreativeTab(HaditeCoalCore.tabAkkamaddiHadite)
				.setHardness(12.0F).setResistance(20.0F)
				.setStepSound(Block.soundTypeMetal)
				.setBlockName("blockGestankenzinn")
				.setCreativeTab(HaditeCoalCore.tabAkkamaddiHadite);
        
        blockHaditeCoalOre.setHarvestLevel( "pickaxe", 1);
        blockHaditeCoalBlock.setHarvestLevel( "pickaxe", 0);
        blockHaditeSteel.setHarvestLevel( "pickaxe", 0);
        blockGestankenzinn.setHarvestLevel("pickaxe", 0);
        toolHaditeSteel.customCraftingMaterial = HaditeCoalCore.haditeSteelIngot;
        toolGestankenzinn.customCraftingMaterial = HaditeCoalCore.gestankenzinnIngot;

        // loot
        LootHelper.addLoot("villageBlacksmith", new ItemStack(haditeCoalIngot), 3, 5, 7);
        LootHelper.addLoot("villageBlacksmith", new ItemStack(gestankenzinnIngot), 2, 3, 2);
        LootHelper.addLoot("villageBlacksmith", new ItemStack(haditeSteelIngot), 2, 3, 2);
        LootHelper.addLoot("villageBlacksmith", new ItemStack(gestankenzinnSword), 1, 1, 2);
        LootHelper.addLoot("villageBlacksmith", new ItemStack(haditeSteelSword), 1, 1, 2);
        LootHelper.addLoot("villageBlacksmith", new ItemStack(gestankenzinnPickaxe), 1, 1, 2);
        LootHelper.addLoot("villageBlacksmith", new ItemStack(haditeSteelPickaxe), 1, 1, 2);
        LootHelper.addLoot("villageBlacksmith", new ItemStack(gestankenzinnAxe), 1, 1, 1);
        LootHelper.addLoot("villageBlacksmith", new ItemStack(haditeSteelAxe), 1, 1, 1);
        LootHelper.addLoot("villageBlacksmith", new ItemStack(gestankenzinnShovel), 1, 1, 1);
        LootHelper.addLoot("villageBlacksmith", new ItemStack(haditeSteelShovel), 1, 1, 1);
        LootHelper.addLoot("strongholdCrossing", new ItemStack(haditeCoalIngot), 1, 2, 4);
        LootHelper.addLoot("strongholdCorridor", new ItemStack(haditeCoalIngot), 1, 2, 2);
        LootHelper.addLoot("pyramidDesertyChest", new ItemStack(haditeCoalIngot), 1, 4, 2);
        LootHelper.addLoot("pyramidDesertyChest", new ItemStack(gestankenzinnSword), 1, 2, 1);
        LootHelper.addLoot("pyramidDesertyChest", new ItemStack(haditeSteelSword), 1, 6, 1);
        LootHelper.addLoot("dungeonChest", new ItemStack(gestankenzinnIngot), 1, 3, 5);
        LootHelper.addLoot("dungeonChest", new ItemStack(haditeSteelIngot), 1, 3, 5);
        LootHelper.addLoot("dungeonChest", new ItemStack(gestankenzinnSword), 1, 2, 2);
        LootHelper.addLoot("dungeonChest", new ItemStack(haditeSteelSword), 1, 2, 2);
        LootHelper.addLoot("dungeonChest", new ItemStack(gestankenzinnPickaxe), 1, 2, 2);
        LootHelper.addLoot("dungeonChest", new ItemStack(haditeSteelPickaxe), 1, 2, 2);
        LootHelper.addLoot("mineshaftCorridor", new ItemStack(gestankenzinnPickaxe), 1, 2, 1);
        LootHelper.addLoot("mineshaftCorridor", new ItemStack(haditeSteelPickaxe), 1, 2, 1);
        LootHelper.addLoot("mineshaftCorridor", new ItemStack(gestankenzinnShovel), 1, 2, 1);
        LootHelper.addLoot("mineshaftCorridor", new ItemStack(haditeSteelShovel), 1, 2, 1);

        // run tab icon call
        setTabIcons();
        
        //mobs hold stuff
		APIcore.instance.joinWorldModRegistry.add(new JoinWorldHandler());
        // world generation
        GameRegistry.registerWorldGenerator(new HaditeGenerator(), 1);
        // Set fuel burntime
        GameRegistry.registerFuelHandler(new HaditeFuel());
        // Recipes
        HaditeRecipes.doHaditeRecipes();
    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        proxy.registerRenderers();
         // name stuff
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        // Stub Method
    }
}
