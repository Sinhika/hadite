package mod.akkamaddi.haditecoal.init;

import java.util.function.ToIntFunction;

import mod.akkamaddi.haditecoal.HaditeCoal;
import mod.akkamaddi.haditecoal.content.HaditeCoalBlock;
import mod.akkamaddi.haditecoal.content.HaditeOreBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

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
            () -> new HaditeOreBlock(Block.Properties.create(Material.ROCK)
                    .hardnessAndResistance( 4.0F, 6.0F).setLightLevel(it_glows(9))
                    .harvestTool(ToolType.PICKAXE).harvestLevel(1)));
    
    // Storage blocks
    public static final RegistryObject<HaditeCoalBlock> hadite_coal_block = BLOCKS.register("hadite_coal_block",
            () -> new HaditeCoalBlock(Block.Properties.create(Material.ROCK, MaterialColor.BLACK_TERRACOTTA)
                    .hardnessAndResistance(4.0F, 6.0F).setLightLevel(it_glows(10))
                    .harvestTool(ToolType.PICKAXE).harvestLevel(0)));
    public static final RegistryObject<Block> hadite_steel_block = BLOCKS.register("hadite_steel_block",
            () -> new Block(Block.Properties.create(Material.IRON)
                    .hardnessAndResistance(14.0F, 22.0F)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(0)));
    public static final RegistryObject<Block> gestankenzinn_block = BLOCKS.register("gestankenzinn_block",
            () -> new Block(Block.Properties.create(Material.IRON)
                    .hardnessAndResistance(12.0F, 20.0F)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(0)));
    
    private static ToIntFunction<BlockState> it_glows(int foo)
    {
        return (bar) -> { return foo; };
    }    
} // end-class
