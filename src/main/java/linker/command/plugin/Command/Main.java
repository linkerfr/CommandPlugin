package linker.command.plugin.Command;


import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;


public final class Main extends JavaPlugin {
    /*
    MIT License

    Copyright (c) 2022 Linker

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
    */

    FileConfiguration config = getConfig();


    @Override
    public void onEnable() {
        getLogger().info("CommandPlugin is on !");
        config.addDefault("command.discord", "");
        config.addDefault("command.b", "");
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
            if (label.equalsIgnoreCase("b")) {
                String welcomeMessage = getConfig().getString("command.b");
                getServer().broadcastMessage(welcomeMessage);
            }
        return false;
    }

}
