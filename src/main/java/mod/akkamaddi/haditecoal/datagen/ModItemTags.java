package mod.akkamaddi.haditecoal.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import mod.akkamaddi.haditecoal.HaditeCoal;
import mod.akkamaddi.haditecoal.init.ModBlocks;
import mod.akkamaddi.haditecoal.init.ModItems;
import mod.alexndr.simplecorelib.api.datagen.MiningItemTags;
import mod.alexndr.simplecorelib.api.helpers.TagUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTags extends MiningItemTags
{

    public ModItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
			CompletableFuture<TagLookup<Block>> blockTagProvider, ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, blockTagProvider, HaditeCoal.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider lookupProvider)
    {
        super.addTags(lookupProvider);
        registerNuggetTags();
        registerIngotTags();
        registerStorageBlockTags();
        registerToolTags(ModItems.ITEMS);
    }
    

   
    /**
     * Create standard forge tags for storage blocks.
     */
    private void registerNuggetTags()
    {
        this.tag(TagUtils.forgeTag("nuggets"))
            .addTag(TagUtils.forgeTag("nuggets/gestankenzinn"))
            .addTag(TagUtils.forgeTag("nuggets/hadite_steel"));
        
        this.tag(TagUtils.forgeTag("nuggets/gestankenzinn"))
            .add(ModItems.gestankenzinn_nugget.get());
        
        this.tag(TagUtils.forgeTag("nuggets/hadite_steel"))
            .add(ModItems.hadite_steel_nugget.get());
    } // end registerNuggetTags()

    
    /**
     * Create standard forge tags for storage blocks.
     */
    private void registerIngotTags()
    {
        this.tag(TagUtils.forgeTag("ingots"))
            .addTag(TagUtils.forgeTag("ingots/gestankenzinn"))
            .addTag(TagUtils.forgeTag("ingots/hadite_steel"));
        
        this.tag(TagUtils.forgeTag("ingots/gestankenzinn"))
            .add(ModItems.gestankenzinn_ingot.get());
        
        this.tag(TagUtils.forgeTag("ingots/hadite_steel"))
            .add(ModItems.hadite_steel_ingot.get());
    } // end registerIngotTags()

    /**
     * Create standard forge tags for storage blocks.
     */
    private void registerStorageBlockTags()
    {
        this.tag(TagUtils.forgeTag("storage_blocks"))
            .addTag(TagUtils.forgeTag("storage_blocks/gestankenzinn"))
            .addTag(TagUtils.forgeTag("storage_blocks/hadite_steel"))
            .addTag(TagUtils.forgeTag("storage_blocks/hadite_coal"));
        
        this.tag(TagUtils.forgeTag("storage_blocks/gestankenzinn"))
            .add(ModBlocks.gestankenzinn_block.get().asItem());
        
        this.tag(TagUtils.forgeTag("storage_blocks/hadite_steel"))
            .add(ModBlocks.hadite_steel_block.get().asItem());
        
        this.tag(TagUtils.forgeTag("storage_blocks/hadite_coal"))
            .add(ModBlocks.hadite_coal_block.get().asItem());
    } // end registerStorageTags()

    
    @Override
    protected void registerOreTags()
    {
        // register "forge:ores" tags
        this.tag(TagUtils.forgeTag( "ores"))
            .addTag(TagUtils.forgeTag( "ores/hadite_coal"));
        this.tag(TagUtils.forgeTag( "ores/hadite_coal"))
            .add(ModBlocks.hadite_coal_ore.get().asItem());

        // register forge ore_rates tags.
        this.registerOreRateTags( List.of(), // sparse 
                List.of(ModBlocks.hadite_coal_ore.get()),
                List.of());
        
        // register forge:ores_in_ground tags
        this.registerOresInGroundTags( List.of(),   // stone ores
                List.of(),                          // deepslate ores
                List.of(ModBlocks.hadite_coal_ore.get()));  // netherrack ore

    } // end registerOreTags()

    
} // end class
