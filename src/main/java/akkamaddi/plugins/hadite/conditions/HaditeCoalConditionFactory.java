package akkamaddi.plugins.hadite.conditions;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;

import akkamaddi.plugins.hadite.ModInfo;
import akkamaddi.plugins.hadite.Settings;
import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class HaditeCoalConditionFactory implements IConditionFactory 
{

	@Override
	public BooleanSupplier parse(JsonContext context, JsonObject json) 
	{
		boolean value = JsonUtils.getBoolean(json , "value", true);
		String key = JsonUtils.getString(json, "type");
		
		if (key.equals(ModInfo.ID + ":hadite_coal_enabled")) {
			return () -> (Settings.haditeCoalIngot.isEnabled() && Settings.haditeCoalBlock.isEnabled()) == value;
		}
		if (key.equals(ModInfo.ID + ":hadite_coal_exists")) {
			return () -> Settings.haditeCoalIngot.isEnabled() == value;
		}
		return null;
	}

} // end-class
