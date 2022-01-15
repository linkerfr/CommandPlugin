package linker.command.plugin.Command.Commands;

import linker.command.plugin.Command.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Message implements CommandExecutor {

    Main messageCmd;


    public Message(Main cmdMessage) {
        this.messageCmd = cmdMessage;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (label.equalsIgnoreCase("msg")) {
            if (sender instanceof Player && args.length > 0) {
                if (Bukkit.getOfflinePlayer(args[0]).getPlayer() != null) {
                    Player messager = (Player) sender;
                    Player reciever = Bukkit.getOfflinePlayer(args[0]).getPlayer();
                    messageCmd.mM.setReplyTarget(messager, reciever);
                    args[0] = "";
                    String message = "";
                    for (int i = 0; i < args.length; i++) {
                        message += "" + args[i];
                    }
                    messager.sendMessage(messager.getName() + " §6>>> " + reciever.getName() + ": §f" + message);
                    reciever.sendMessage(messager.getName() + " §6>>> " + reciever.getName() + ": §f" + message);
                    return true;
                } else {
                    sender.sendMessage("§cCe joueur n'est pas en ligne !");
                    return true;
                }
            }
        }
        return false;
    }
}
