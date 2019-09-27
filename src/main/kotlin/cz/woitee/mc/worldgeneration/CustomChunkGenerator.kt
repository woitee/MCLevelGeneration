package cz.woitee.mc.worldgeneration

import org.bukkit.Material
import org.bukkit.World
import org.bukkit.generator.ChunkGenerator
import org.bukkit.util.noise.SimplexOctaveGenerator
import java.util.*

class CustomChunkGenerator: ChunkGenerator() {
    override fun generateChunkData(world: World, random: Random, chunkX: Int, chunkZ: Int, biome: BiomeGrid): ChunkData {
        val chunk = createChunkData(world)

        val generator = SimplexOctaveGenerator(Random(world.seed), 8)
        generator.setScale(0.005)

        for (X in 0..15) {
            for (Z in 0..15) {
                // X and Z are the geographic coordinates in Minecraft

                val currentHeight =
                    ((generator.noise(chunkX * 16.0 + X, chunkZ * 16.0 + Z, 0.5, 0.5, true) + 1) * 15.0 + 50.0).toInt()

                chunk.setBlock(X, currentHeight, Z, Material.GRASS)
                chunk.setBlock(X, currentHeight - 1, Z, Material.DIRT)

                for (i in currentHeight - 2 downTo 1)
                    chunk.setBlock(X, i, Z, Material.STONE)

                chunk.setBlock(X, 0, Z, Material.BEDROCK)
            }
        }

        return chunk
    }


}