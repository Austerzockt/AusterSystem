package at.auster.system;

import at.auster.system.localisation.MessageHandler;
import at.auster.system.ranks.PrefixCommand;
import at.auster.system.ranks.RankCommand;
import at.auster.system.ranks.utils.PrefixUtils;
import org.bukkit.Bukkit;

import org.bukkit.plugin.java.JavaPlugin;


public class AusterSystem extends JavaPlugin {


    @Override
    public void onEnable() {
        PrefixCommand prefixCommand = new PrefixCommand();
        Bukkit.getPluginCommand("prefix").setExecutor(prefixCommand);
        Bukkit.getPluginCommand("prefix").setTabCompleter(prefixCommand);
        RankCommand rankCommand = new RankCommand();
        Bukkit.getPluginCommand("rank").setExecutor(rankCommand);
        MessageHandler handler = new MessageHandler(MessageHandler.Languages.ENGLISH);
        Bukkit.getConsoleSender().sendMessage(handler.getMessage(MessageHandler.Messages.NOPERMS).toString());
        }

    @Override
    public void onDisable() {

    }
}
