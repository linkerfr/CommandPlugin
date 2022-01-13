package linker.command.plugin.Command;


import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;


public final class Main extends JavaPlugin {

    FileConfiguration config = getConfig();


    @Override
    public void onEnable() {
        getLogger().info("CommandPlugin is on !");
        config.addDefault("command.discord", "Change this by your link of your Discord");
        config.options().copyDefaults(true);
        saveConfig();

    }



    @Override
    public void onDisable() {
        getLogger().info("CommandPlugin is off !");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
            if (label.equalsIgnoreCase("discord")) {
                if (sender instanceof Player) {
                    Player player = (Player) sender;
                    sender.sendMessage(getConfig().getString("command.discord"));

                    //Test if the command is ok
                    //getLogger().info(player + "a executer la commande /discord");
                }
            }
        return false;
    }

}
