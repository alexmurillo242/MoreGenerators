package me.adamsogm.MoreGenerators;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import me.adamsogm.MoreGenerators.blocks.BlockList;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

public class OreGenerator implements IWorldGenerator {
	WorldGenMinable copperGen;
	WorldGenMinable tungstenGen;
	WorldGenMinable titaniumGen;

	public OreGenerator() {
		copperGen = new WorldGenMinable(BlockList.copperOre, 20);
		tungstenGen = new WorldGenMinable(BlockList.tungstenOre, 20);
		titaniumGen = new WorldGenMinable(BlockList.titaniumOre, 20);
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case 0:
			runGenerator(copperGen, world, random, chunkX, chunkZ, 100, 0, 120);
			runGenerator(tungstenGen, world, random, chunkX, chunkZ, 100, 0, 120);
			runGenerator(titaniumGen, world, random, chunkX, chunkZ, 100, 0, 120);
			break;
		default:
			break;
		}
	}

	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z,
			int chancesToSpawn, int minHeight, int maxHeight) {
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < chancesToSpawn; i++) {
			int x = chunk_X * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunk_Z * 16 + rand.nextInt(16);
			generator.generate(world, rand, x, y, z);
		}
	}
}
