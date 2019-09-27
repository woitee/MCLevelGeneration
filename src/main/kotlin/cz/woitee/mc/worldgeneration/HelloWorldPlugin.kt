package cz.woitee.mc.worldgeneration

import org.bukkit.plugin.java.JavaPlugin

class HelloWorldPlugin: JavaPlugin() {
    override fun onEnable() {
        HelloWorldCommand(this)
    }
}
