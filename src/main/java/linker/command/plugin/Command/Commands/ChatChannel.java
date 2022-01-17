package linker.command.plugin.Command.Commands;

import linker.command.plugin.Command.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import static org.bukkit.Bukkit.getPlayer;

public class ChatChannel implements CommandExecutor {
    Main groupCmd;

    public ChatChannel(Main cmdGroup) {
        this.groupCmd = cmdGroup;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        if (label.equalsIgnoreCase("group")) {
            if (args.length == 0) {
                sender.sendMessage("§cUsage : /group <create | remove | delete | leave>");
                return true;
            }
            else {
                if (args[0].equalsIgnoreCase("create")) {
                    if(args.length == 0) {
                        sender.sendMessage("§cUsage : /group create <nom du groupe>");
                        return true;
                    } else {
                        String groupName = args[1];
                        groupCmd.groupManager.joinChannels(player, groupName);
                    }
                }
            }
            return true;
        }
        return false;
    }
}
