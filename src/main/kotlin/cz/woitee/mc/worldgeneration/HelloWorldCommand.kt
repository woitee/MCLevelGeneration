package cz.woitee.mc.worldgeneration

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class HelloWorldCommand(plugin: HelloWorldPlugin) : CommandExecutor {

    init {
        plugin.getCommand("hello")!!.setExecutor(this)
    }

    override fun onCommand(commandSender: CommandSender, command: Command, s: String, strings: Array<String>): Boolean {
        if (commandSender !is Player) {
            commandSender.sendMessage("Only players may execute this command!")
            return true
        }

        return if (commandSender.hasPermission("hello.use")) {
            commandSender.sendMessage("Hello, world!")
            true
        } else {
            commandSender.sendMessage("You do not have the permission to execute this command!")
            false
        }
    }
}
