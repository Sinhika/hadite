package akkamaddi.plugins.hadite;

import akkamaddi.plugins.hadite.blocks.HaditeOreBlock;
import akkamaddi.plugins.hadite.blocks.HaditeStorageBlock;
import alexndr.api.content.blocks.SimpleBlock;
import alexndr.api.registry.ContentCategories;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks 
{
    //blocks
    public static HaditeOreBlock blockHaditeCoalOre 
    	= (HaditeOreBlock) new HaditeOreBlock("block_hadite_coal_ore", Material.ROCK).setStepSound(SoundType.STONE);
    public static HaditeStorageBlock blockHaditeCoalBlock
    	= (HaditeStorageBlock) new HaditeStorageBlock("block_hadite_coal_block", Material.ROCK).setStepSound(SoundType.STONE);
    public static SimpleBlock blockHaditeSteel 
    	= new SimpleBlock("block_hadite_steel", HaditeCoal.plugin, Material.IRON, 
    			ContentCategories.Block.GENERAL).setStepSound(SoundType.METAL);
    public static SimpleBlock blockGestankenzinn 
    	= new SimpleBlock("block_gestankenzinn", HaditeCoal.plugin, Material.IRON, 
    			ContentCategories.Block.GENERAL).setStepSound(SoundType.METAL);
    
    
    public static void configureBlocks()
    {
        // define blocks
    	if (Settings.haditeCoalOre.isEnabled())
			blockHaditeCoalOre.setConfigEntry(Settings.haditeCoalOre).setCreativeTab(HaditeCoal.tabAkkamaddiHadite)
					.setLightLevel(0.6F);

    	if (Settings.haditeCoalBlock.isEnabled())
			blockHaditeCoalBlock.setConfigEntry(Settings.haditeCoalBlock)
					.setFireSource(Settings.haditeCoalBlockFireSource).setCreativeTab(HaditeCoal.tabAkkamaddiHadite)
					.setLightLevel(0.7F);

    	if (Settings.haditeSteelBlock.isEnabled())
			blockHaditeSteel.setConfigEntry(Settings.haditeSteelBlock).setCreativeTab(HaditeCoal.tabAkkamaddiHadite);

    	if (Settings.gestankenzinnBlock.isEnabled())
			blockGestankenzinn.setConfigEntry(Settings.gestankenzinnBlock)
					.setCreativeTab(HaditeCoal.tabAkkamaddiHadite);
    } // end configureBlocks()

	/**
	 * Register blocks with Forge.
	 * 
	 * @param registry Forge block registry interface.
	 */
	public static void register(IForgeRegistry<Block> registry) 
	{
    	if (Settings.haditeCoalOre.isEnabled()) registry.register(blockHaditeCoalOre);
        if (Settings.haditeCoalBlock.isEnabled()) registry.register(blockHaditeCoalBlock);
    	if (Settings.haditeSteelBlock.isEnabled()) registry.register(blockHaditeSteel);
    	if (Settings.gestankenzinnBlock.isEnabled()) registry.register(blockGestankenzinn);
	} // end register()
	
	/**
	 * register ItemBlocks with Forge.
	 * 
	 * @param registry Forge item registry interface.
	 */
	public static void registerItemBlocks(IForgeRegistry<Item> registry) 
	{
		if (Settings.haditeCoalOre.isEnabled()) registry.register(blockHaditeCoalOre.createItemBlock());
		if (Settings.haditeCoalBlock.isEnabled()) registry.register(blockHaditeCoalBlock.createItemBlock());
		if (Settings.haditeSteelBlock.isEnabled()) registry.register(blockHaditeSteel.createItemBlock());
		if (Settings.gestankenzinnBlock.isEnabled()) registry.register(blockGestankenzinn.createItemBlock());
	} // end registerItemBlocks()

	/**
	 * register models of ItemBlocks with Forge.
	 */
	public static void registerModels() 
	{
    	if (Settings.haditeCoalOre.isEnabled())
    		blockHaditeCoalOre.registerItemModel(Item.getItemFromBlock(blockHaditeCoalOre));
        if (Settings.haditeCoalBlock.isEnabled())
    		blockHaditeCoalBlock.registerItemModel(Item.getItemFromBlock(blockHaditeCoalBlock));
    	if (Settings.haditeSteelBlock.isEnabled())
    		blockHaditeSteel.registerItemModel(Item.getItemFromBlock(blockHaditeSteel));
    	if (Settings.gestankenzinnBlock.isEnabled())
    		blockGestankenzinn.registerItemModel(Item.getItemFromBlock(blockGestankenzinn));
	} // end registerModels()
	
	/**
	 * ore dictionary registrations for blocks.
	 */
	public static void registerOreDictionary()
	{
		if (Settings.haditeCoalOre.isEnabled())
			OreDictionary.registerOre("oreHaditeCoal", new ItemStack(ModBlocks.blockHaditeCoalOre));
        if (Settings.haditeCoalBlock.isEnabled())
			OreDictionary.registerOre("blockHaditeCoal", new ItemStack(ModBlocks.blockHaditeCoalBlock));
    	if (Settings.haditeSteelBlock.isEnabled())
			OreDictionary.registerOre("blockHaditeSteel", new ItemStack(ModBlocks.blockHaditeSteel));
    	if (Settings.gestankenzinnBlock.isEnabled())
			OreDictionary.registerOre("blockGestankenzinn", new ItemStack(ModBlocks.blockGestankenzinn));
	} // end registerOreDictionary()
	
} // end class
