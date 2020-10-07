package mod.akkamaddi.haditecoal.config;

import java.util.HashMap;
import java.util.Map;

import mod.alexndr.simplecorelib.config.ISimpleConfig;
import mod.alexndr.simplecorelib.config.ModOreConfig;

public class HaditeConfig implements ISimpleConfig
{
    // recipe flags
    private static Map<String, Boolean> flags = new HashMap<>();
    public static HaditeConfig INSTANCE = new HaditeConfig();
    
    // general
    public static boolean isHaditeCoalBlockFireSource = true;
    public static int haditeCoalBurnTime = 13000;
    
    // Vein/Chunk Count, MinHeight, MaxHeightBase, MaxHeight
    public static ModOreConfig hadite_cfg;
    
    // client-side
    public static boolean makeOreFlame = true;
    public static boolean makeBlockFlame = true;
    
    @Override
    public void clear()
    {
        flags.clear();
    }

    @Override
    public boolean getFlag(String n)
    {
        Boolean obj = flags.get(n);
        return obj != null && obj;
    }

    @Override
    public void putFlag(String n, boolean val)
    {
        flags.put(n, val);
    }

} // end-class
