package linker.command.plugin.Command.MessageManager;

import linker.command.plugin.Command.Main;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class MessageManager {
    Main messageManager;

    HashMap<Player, Player> conversations = new HashMap<Player, Player>();

    public MessageManager(Main managerMessage){
        this.messageManager = managerMessage;
    }

    public void setReplyTarget(Player messager, Player reciever) {
        conversations.put(messager, reciever);
        conversations.put(reciever, messager);
    }

    public Player getReplyTarget(Player messager) {
        return conversations.get(messager);
    }


}
