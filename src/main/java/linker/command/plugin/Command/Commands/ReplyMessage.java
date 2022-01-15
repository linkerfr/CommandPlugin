package linker.command.plugin.Command.Commands;

import linker.command.plugin.Command.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ReplyMessage implements CommandExecutor {

    Main replyCmd;

    public ReplyMessage(Main cmdReply) {
        this.replyCmd = cmdReply;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(label.equalsIgnoreCase("r")) {
            if (sender instanceof Player){
                Player messager = (Player) sender;
                if(replyCmd.mM.getReplyTarget(messager) == null) {
                    messager.sendMessage("§cPas de conversation en cours !");
                    return true;
                }
                Player reciever = replyCmd.mM.getReplyTarget(messager);
                String message = "";
                for (int i = 0; i < args.length; i++) {
                    message += "" + args[i];
                }
                messager.sendMessage(messager.getName() + " §6>>> " + reciever.getName() + ": §f" + message);
                reciever.sendMessage(messager.getName() + " §6>>> " + reciever.getName() + ": §f" + message);
                return true;
            }
        }
        return false;
    }
}
