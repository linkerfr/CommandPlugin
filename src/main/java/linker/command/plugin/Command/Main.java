package linker.command.plugin.Command;

import linker.command.plugin.Command.Commands.CommandB;
import linker.command.plugin.Command.Commands.CommandDiscord;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("discord").setExecutor(new CommandDiscord());
        this.getCommand("b").setExecutor(new CommandB());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
