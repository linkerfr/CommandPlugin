package linker.command.plugin.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Command Plugin v1.0 enabled ! Enjoy !");
        this.getCommand("discord").setExecutor(new CommandDiscord());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
