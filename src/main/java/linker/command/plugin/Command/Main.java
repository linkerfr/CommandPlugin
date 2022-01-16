package linker.command.plugin.Command;


import linker.command.plugin.Command.Commands.ChatChannel;
import linker.command.plugin.Command.Commands.Display;
import linker.command.plugin.Command.Commands.Message;
import linker.command.plugin.Command.Commands.ReplyMessage;
import linker.command.plugin.Command.MessageManager.GroupManager;
import linker.command.plugin.Command.MessageManager.MessageManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin {
    public MessageManager messageManager;
    public GroupManager groupManager;
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
        saveDefaultConfig();

        getCommand("display").setExecutor(new Display(this));
        getCommand("msg").setExecutor(new Message(this));
        getCommand("r").setExecutor(new ReplyMessage(this));
        messageManager = new MessageManager(this);
        groupManager = new GroupManager();

        getServer().getPluginManager().registerEvents(new ChatChannel(this), this);

    }

    @Override
    public void onDisable() {
        getLogger().info("CommandPlugin is off !");
    }
}
