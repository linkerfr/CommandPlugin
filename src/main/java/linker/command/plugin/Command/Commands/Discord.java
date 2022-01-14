package linker.command.plugin.Command.Commands;

import linker.command.plugin.Command.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
public class Discord implements CommandExecutor {
    private Main discordCmd;

    public Discord(Main cmdDiscord) {
        this.discordCmd = cmdDiscord;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (label.equalsIgnoreCase("discord")) {
                sender.sendMessage(discordCmd.getConfig().getString("command.discord").replace("&", "§"));
                return true;
                //Test if the command is ok
                //getLogger().info(player + "a executer la commande /discord");
            }
        }
        return false;
    }
}
