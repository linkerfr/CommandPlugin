package linker.command.plugin.Command.Commands;

import linker.command.plugin.Command.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;

public class ChatChannel implements Listener {
    Main groupCmd;

    public ChatChannel(Main cmdGroup) {
        this.groupCmd = cmdGroup;
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        groupCmd.groupManager.joinChannels(event.getPlayer(), "General");
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player p= event.getPlayer();
        event.getRecipients().clear();
        groupCmd.groupManager.getChannel(p).stream().forEach(player -> event.getRecipients().add(player));

    }
}
