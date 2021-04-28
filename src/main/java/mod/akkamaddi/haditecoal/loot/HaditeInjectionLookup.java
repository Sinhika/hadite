package mod.akkamaddi.haditecoal.loot;

import mod.alexndr.simplecorelib.helpers.InjectionTableLookup;

@SuppressWarnings("serial")
public class HaditeInjectionLookup extends InjectionTableLookup
{

    public HaditeInjectionLookup()
    {
        super();
        this.put("ruined_portal", "ruined_portal");
        this.AddNetherAliases();
    }

} // end class
