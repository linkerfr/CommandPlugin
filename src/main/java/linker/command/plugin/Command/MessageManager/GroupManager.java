package linker.command.plugin.Command.MessageManager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;
import java.util.HashMap;

public class GroupManager implements Listener {

    public HashMap<String, ArrayList<Player>> channels = new HashMap<String, ArrayList<Player>>();
    public HashMap<Player, String> playerChannel = new HashMap<Player, String>();

    //Join channel
    public void joinChannels(Player player, String channelName) {
        if(playerChannel.get(player) != null) {
            String prevChannel = playerChannel.get(player);
            leaveChannel(player, prevChannel);
        }
        ArrayList<Player> players = channels.get(channelName);
        if (players == null) {
            players = new ArrayList<Player>();
        }
        players.add(player);
        channels.put(channelName, players);
        playerChannel.put(player, channelName);
        player.sendMessage(ChatColor.GREEN + "Vous avez rejoint le salon : " + channelName);
    }
    //Remove channel
    public void leaveChannel(Player player, String channelName) {
        ArrayList<Player> players = channels.get(channelName);
        players.remove(player);
        channels.put(channelName, players);
        playerChannel.remove(player);
    }

    public ArrayList<Player> getChannel(Player player) {
        String channelName = playerChannel.get(player);
        return channels.get(channelName);
    }
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        e.getRecipients().clear();
        getChannel(p).stream().forEach(player -> e.getRecipients().add(player));
        System.out.println("Player is in group");
    }



}
