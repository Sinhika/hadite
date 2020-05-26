package mod.akkamaddi.haditecoal.init;

import mod.akkamaddi.haditecoal.HaditeCoal;
import mod.akkamaddi.haditecoal.content.HaditeCoalBlock;
import mod.akkamaddi.haditecoal.content.HaditeOreBlock;
import net.minecraft.block.Block;
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
            new DeferredRegister<>(ForgeRegistries.BLOCKS, HaditeCoal.MODID);
    
    // Ore block
    public static final RegistryObject<HaditeOreBlock> hadite_coal_ore = BLOCKS.register("hadite_coal_ore",
            () -> new HaditeOreBlock(Block.Properties.create(Material.ROCK)
                    .hardnessAndResistance( 4.0F, 6.0F).lightValue(9)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(1)));
    
    // Storage blocks
    public static final RegistryObject<HaditeCoalBlock> hadite_coal_block = BLOCKS.register("hadite_coal_block",
            () -> new HaditeCoalBlock(Block.Properties.create(Material.ROCK, MaterialColor.BLACK_TERRACOTTA)
                    .hardnessAndResistance(4.0F, 6.0F).lightValue(10)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(0)));
    
} // end-class
