package mod.akkamaddi.haditecoal.datagen;

import java.util.List;

import mod.akkamaddi.haditecoal.HaditeCoal;
import mod.akkamaddi.haditecoal.init.ModBlocks;
import mod.alexndr.simplecorelib.datagen.MiningBlockTags;
import mod.alexndr.simplecorelib.helpers.TagUtils;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockTags extends MiningBlockTags
{

    public ModBlockTags(DataGenerator gen, ExistingFileHelper existingFileHelper)
    {
        super(gen, HaditeCoal.MODID, existingFileHelper);
    }

    @Override
    protected void addTags()
    {
        super.addTags();
        registerStorageBlockTags();
        registerBeaconBlockTags();
        registerMiscBlockTags();
    }

    
    private void registerMiscBlockTags()
    {
        this.tag(BlockTags.INFINIBURN_OVERWORLD)
            .add(ModBlocks.hadite_coal_block.get());
    }
    
    
    /**
     * Identify metal blocks as beacon block bases.
     */
    private void registerBeaconBlockTags()
    {
        this.tag(BlockTags.BEACON_BASE_BLOCKS)
            .add(ModBlocks.gestankenzinn_block.get())
            .add(ModBlocks.hadite_steel_block.get());
    }
    
    /**
     * Create standard forge tags for storage blocks.
     */
    private void registerStorageBlockTags()
    {
        this.tag(TagUtils.forgeBlockTag("storage_blocks"))
            .addTag(TagUtils.forgeBlockTag("storage_blocks/gestankenzinn"))
            .addTag(TagUtils.forgeBlockTag("storage_blocks/hadite_steel"))
            .addTag(TagUtils.forgeBlockTag("storage_blocks/hadite_coal"));
        
        this.tag(TagUtils.forgeBlockTag("storage_blocks/gestankenzinn"))
            .add(ModBlocks.gestankenzinn_block.get());
        
        this.tag(TagUtils.forgeBlockTag("storage_blocks/hadite_steel"))
            .add(ModBlocks.hadite_steel_block.get());
        
        this.tag(TagUtils.forgeBlockTag("storage_blocks/hadite_coal"))
            .add(ModBlocks.hadite_coal_block.get());
    } // end registerStorageBlockTags()
    
    @Override
    protected void registerMiningTags()
    {
        // all the registered blocks are mineable.
        List<Block> mineables = ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).toList();

        // do nothing; super() generates all the vanilla blocktags, and we don't want that.
        // note: all the mineable blocks are iron-level.
        registerMineableTags(mineables, 
                mineables, // 1 stone
                List.of(), // 2 - iron
                List.of(), // 3 - diamond
                List.of()); // 4 - netherite
    } // registerMiningTags()

    @Override
    protected void registerOreTags()
    {
        // register "forge:ores" tags
        this.tag(TagUtils.forgeBlockTag( "ores"))
            .addTag(TagUtils.forgeBlockTag( "ores/hadite_coal"));
        this.tag(TagUtils.forgeBlockTag( "ores/hadite_coal"))
            .add(ModBlocks.hadite_coal_ore.get());

        // register forge ore_rates tags.
        this.registerOreRateTags( List.of(), // sparse 
                List.of(ModBlocks.hadite_coal_ore.get()),
                List.of());
        
        // register forge:ores_in_ground tags
        this.registerOresInGroundTags( List.of(),   // stone ores
                List.of(),                          // deepslate ores
                List.of(ModBlocks.hadite_coal_ore.get()));  // netherrack ore

    } // end registerOreTags
    

    
} // end class
