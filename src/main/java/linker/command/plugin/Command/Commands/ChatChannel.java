package linker.command.plugin.Command.Commands;

import linker.command.plugin.Command.Main;
import org.bukkit.ChatColor;
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
                        ArrayList<Player> players = groupCmd.groupManager.channels.get(groupName);
                        groupCmd.groupManager.channels.put(groupName, players);
                        groupCmd.groupManager.playerChannel.put(player, groupName);
                        groupCmd.groupManager.joinChannels(player, groupName);
                        System.out.println(sender + " try to create the group : " + groupName);
                        //sender.sendMessage(ChatColor.GREEN + "Vous avez rejoint le salon : " + ChatColor.YELLOW + args[1]);
                    }
                }
            }
            return true;
        }
        return false;
    }

/*    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        groupCmd.groupManager.joinChannels(event.getPlayer(), "General");
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player p= event.getPlayer();
        event.getRecipients().clear();
        if(groupCmd.groupManager.playerChannel.get(p).equals("General")){
            p.getNearbyEntities(25, 25, 25).stream().forEach(ent -> {if(ent instanceof Player){
                event.getRecipients().add(p);
                return;
            }});
        }
        groupCmd.groupManager.getChannel(p).stream().forEach(player -> event.getRecipients().add(player));

    }*/
}
