package linker.command.plugin.Command;

import linker.command.plugin.Command.Commands.CommandB;
import linker.command.plugin.Command.Commands.CommandDiscord;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;


public final class Main extends JavaPlugin implements Listener {

    FileConfiguration config = getConfig();


    @Override
    public void onEnable() {
        config.addDefault("command.discord", "Change this to the invite link of your Discord server");
        config.options().copyDefaults(true);
        saveConfig();

        getServer().getPluginManager().registerEvents(this, this);
        //this.getCommand("discord").setExecutor(new CommandDiscord());
        //this.getCommand("b").setExecutor(new CommandB());
    }



    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
            if (label.equalsIgnoreCase("discord")) {
                if (sender instanceof Player) {
                    Player player = (Player) sender;
                    for (String msg : this.getConfig().getStringList("discord")) {
                        sender.sendMessage(msg);
                        this.getConfig().set("","");
                    }
                }
            }
        return false;
    }

}
