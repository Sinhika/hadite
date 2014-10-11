package akkamaddi.hadite.code;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import akkamaddi.akkamaddiCore.api.AkkaWorldGenHelper;
import cpw.mods.fml.common.IWorldGenerator;

public class HaditeGenerator implements IWorldGenerator {
	/**
	 * Generates the ores in the world. Depending on which 'world' the player is
	 * in (ie. Nether or Surface), different methods are called. These two
	 * methods are generateSurface and generateNether, which are below.
	 */
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	private void generateNether(World world, Random rand, int baseX, int baseZ) {
		for (int i = 0; i < HaditeCoalCore.haditeSpawnRate; i++) {
			int randPosX = baseX + rand.nextInt(16);
			int randPosY = rand.nextInt(HaditeCoalCore.haditeSpawnHeight);
			int randPosZ = baseZ + rand.nextInt(16);
			new AkkaWorldGenHelper(HaditeCoalCore.blockHaditeCoalOre,
					HaditeCoalCore.haditeVeinSize, Blocks.netherrack).generate(
					world, rand, randPosX, randPosY, randPosZ);
		}
	}
}
