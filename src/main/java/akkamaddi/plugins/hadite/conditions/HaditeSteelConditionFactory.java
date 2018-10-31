package akkamaddi.plugins.hadite.conditions;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;

import akkamaddi.plugins.hadite.ModInfo;
import akkamaddi.plugins.hadite.Settings;
import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class HaditeSteelConditionFactory implements IConditionFactory
{
	@Override
	public BooleanSupplier parse(JsonContext context, JsonObject json) 
	{
		boolean value = JsonUtils.getBoolean(json , "value", true);
		String key = JsonUtils.getString(json, "type");
		
		boolean metal_enabled = Settings.haditeSteelBlock.isEnabled() 
				&& Settings.haditeSteelIngot.isEnabled();
		
		// at all
		if (key.equals(ModInfo.ID + ":hadite_steel_enabled")) {
			return () ->metal_enabled == value;
		}
		if (key.equals(ModInfo.ID + ":hadite_steel_tools_enabled")) {
			return () -> Settings.haditeSteelTools.isEnabled() == value;
		}
		
		return null;
	}

} // end-class
