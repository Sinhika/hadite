/**
 * 
 */
package akkamaddi.plugins.hadite;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author cyhiggin
 *
 */
public class ModInfo
{
    public static final String ID = "haditecoal";
    public static final String NAME = "Hadite Coal";
    public static final String VERSION = "@MODVERSION@";
	public static final String DESCRIPTION = "A nether coal with two alloys";
	public static final String ACCEPTED_VERSIONS = "[1.12.2,)";
	public static final String DEPENDENCIES = 
		"required-after:simplecore@[1.7.3.0,);after:simpleores;after:fusion;after:aesthetics;after:machines";
	public static final String URL = "http://minecraft.curseforge.com/projects/hadite";
	public static final List<String> AUTHORS = Lists.newArrayList("akkamaddi", "Sinhika");
	public static final String CREDITS = "Created by akkamaddi. Maintained by Sinhika";
	public static final String PARENT = "";
	public static final boolean USEDEPENDENCYINFO = true;
	public static final String VERSIONURL = "https://raw.githubusercontent.com/Sinhika/hadite/1.12/update.json";
}
