package mod.akkamaddi.haditecoal.config; 

import mod.alexndr.simplecorelib.config.ModOreConfig;
import mod.alexndr.simplecorelib.config.SimpleConfig;

public class HaditeConfig extends SimpleConfig
{
    // recipe flags
    public static HaditeConfig INSTANCE = new HaditeConfig();
    
    // general
    public static boolean isHaditeCoalBlockFireSource = true;
    public static int haditeCoalBurnTime = 13000;
    public static boolean addChestLoot = true;
    
    // Vein/Chunk Count, MinHeight, MaxHeightBase, MaxHeight
    public static ModOreConfig hadite_cfg;
    
    // client-side
    public static boolean makeOreFlame = true;
    public static boolean makeBlockFlame = true;

} // end-class
