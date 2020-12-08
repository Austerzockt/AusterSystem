package at.auster.system;

import at.auster.system.ranks.PrefixCommand;
import at.auster.system.ranks.RankCommand;
import at.auster.system.ranks.utils.PrefixUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;



public class AusterSystem extends JavaPlugin {


    @Override
    public void onEnable() {
        PrefixCommand prefixCommand = new PrefixCommand();
        Bukkit.getPluginCommand("prefix").setExecutor(prefixCommand);
        Bukkit.getPluginCommand("prefix").setTabCompleter(prefixCommand);
        RankCommand rankCommand = new RankCommand();
        Bukkit.getPluginCommand("rank").setExecutor(rankCommand);
        }

    @Override
    public void onDisable() {

    }
}
