package linker.command.plugin.Command.Commands;

import linker.command.plugin.Command.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class Bienvenue implements CommandExecutor {

    public Main bienvenueCmd;

    public Bienvenue(Main cmdBienvenue) {
        this.bienvenueCmd = cmdBienvenue;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (label.equalsIgnoreCase("b")) {
            String welcomeMessage = bienvenueCmd.getConfig().getString("command.b").replace("&", "§");
            Bukkit.broadcastMessage(welcomeMessage);
            return true;
        }

        return false;
    }
}
