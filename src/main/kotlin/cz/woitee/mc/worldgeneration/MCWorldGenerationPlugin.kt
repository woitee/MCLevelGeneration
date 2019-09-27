package cz.woitee.mc.worldgeneration

import org.bukkit.generator.ChunkGenerator
import org.bukkit.plugin.java.JavaPlugin

class MCWorldGenerationPlugin: JavaPlugin() {
    override fun getDefaultWorldGenerator(worldName: String, id: String?): ChunkGenerator? {
        return CustomChunkGenerator()
    }
}
