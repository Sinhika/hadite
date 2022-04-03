package mod.akkamaddi.haditecoal.init;

import java.util.function.ToIntFunction;

import mod.akkamaddi.haditecoal.HaditeCoal;
import mod.akkamaddi.haditecoal.content.HaditeCoalBlock;
import mod.akkamaddi.haditecoal.content.HaditeOreBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Holds a list of all our {@link Block}s.
 * Suppliers that create Blocks are added to the DeferredRegister.
 * The DeferredRegister is then added to our mod event bus in our constructor.
 * When the Block Registry Event is fired by Forge and it is time for the mod to
 * register its Blocks, our Blocks are created and registered by the DeferredRegister.
 * The Block Registry Event will always be called before the Item registry is filled.
 * Note: This supports registry overrides.
 *
 * @author Sinhika, notes by Cadiboo
 */
public final class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS = 
            DeferredRegister.create(ForgeRegistries.BLOCKS, HaditeCoal.MODID);
    
    // Ore block
    public static final RegistryObject<HaditeOreBlock> hadite_coal_ore = BLOCKS.register("hadite_coal_ore",
            () -> new HaditeOreBlock(Block.Properties.of(Material.STONE)
                    .strength( 4.0F, 6.0F).lightLevel(it_glows(9)).requiresCorrectToolForDrops()));
                    // .harvestTool(ToolType.PICKAXE).harvestLevel(1)));
    
    // Storage blocks
    public static final RegistryObject<HaditeCoalBlock> hadite_coal_block = BLOCKS.register("hadite_coal_block",
            () -> new HaditeCoalBlock(Block.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLACK)
                    .strength(4.0F, 6.0F).lightLevel(it_glows(10)).requiresCorrectToolForDrops()));
                    // .harvestTool(ToolType.PICKAXE)harvestLevel(0)));
    public static final RegistryObject<Block> hadite_steel_block = BLOCKS.register("hadite_steel_block",
            () -> new Block(Block.Properties.of(Material.METAL)
                    .strength(14.0F, 22.0F).requiresCorrectToolForDrops()));
                    // .harvestTool(ToolType.PICKAXE).harvestLevel(0)));
    public static final RegistryObject<Block> gestankenzinn_block = BLOCKS.register("gestankenzinn_block",
            () -> new Block(Block.Properties.of(Material.METAL)
                    .strength(12.0F, 20.0F).requiresCorrectToolForDrops()));
                    // .harvestTool(ToolType.PICKAXE).harvestLevel(0)));
    
    private static ToIntFunction<BlockState> it_glows(int foo)
    {
        return (bar) -> { return foo; };
    }    
} // end-class
