package linker.command.plugin.Command.Commands;

import linker.command.plugin.Command.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Display implements CommandExecutor {
    private Main displayCmd;

    public Display(Main cmdDisplay){
        this.displayCmd = cmdDisplay;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        if (label.equalsIgnoreCase("display")) {
            if (args.length == 0) {
                player.sendMessage("Usage : /display <discord|b>");
            } else {
                if (args[0].equalsIgnoreCase("discord")) {
                    sender.sendMessage(displayCmd.getConfig().getString("command.discord").replace("&", "§"));
                }
                else if (args[0].equalsIgnoreCase("b")) {
                    String welcomeMessage = displayCmd.getConfig().getString("command.b").replace("&", "§");
                    Bukkit.broadcastMessage(welcomeMessage);
                }
            }
            return true;
        }
        return false;
    }

}
