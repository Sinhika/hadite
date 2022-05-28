package mod.akkamaddi.haditecoal.config; 

import mod.alexndr.simplecorelib.api.config.ModOreConfig;
import mod.alexndr.simplecorelib.api.config.SimpleConfig;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraftforge.common.util.Lazy;

public class HaditeConfig extends SimpleConfig
{
    // recipe flags
    public static HaditeConfig INSTANCE = new HaditeConfig();
    
    // general
    public static boolean isHaditeCoalBlockFireSource = true;
    public static int haditeCoalBurnTime = 13000;
    public static boolean addChestLoot = true;
    
    // Vein/Chunk Count, MinHeight, MaxHeightBase, MaxHeight
    public static Lazy<ModOreConfig> hadite_cfg = Lazy.of(()->new ModOreConfig(ModOreConfig.FULL_RANGE, 
                ConfigHolder.SERVER.serverHaditeCoalVeinSize.get(), ConfigHolder.SERVER.serverHaditeCoalVeinCount.get(), true,
                VerticalAnchor.absolute(ConfigHolder.SERVER.serverHaditeCoalBottomHeight.get()),
                VerticalAnchor.absolute(ConfigHolder.SERVER.serverHaditeCoalMaxHeight.get())));
    
    // client-side
    public static boolean makeOreFlame = true;
    public static boolean makeBlockFlame = true;

} // end-class
