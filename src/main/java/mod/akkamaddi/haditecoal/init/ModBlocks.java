package mod.akkamaddi.haditecoal.init;

import mod.akkamaddi.haditecoal.HaditeCoal;
import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.material.Material;
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
    
    public static final RegistryObject<OreBlock> hadite_coal_ore = BLOCKS.register("hadite_coal_ore",
            () -> new OreBlock(Block.Properties.create(Material.ROCK)
                    .hardnessAndResistance( 4.0F, 6.0F)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(1)));
} // end-class
