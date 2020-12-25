package at.auster.system;

import at.auster.system.build.BuildEvent;
import at.auster.system.build.BuildModeCommand;
import at.auster.system.config.ConfigHandler;
import at.auster.system.ranks.PrefixCommand;
import at.auster.system.ranks.RankCommand;
import at.auster.system.ranks.utils.PrefixUtils;
import org.bukkit.Bukkit;

import org.bukkit.plugin.java.JavaPlugin;


public class AusterSystem extends JavaPlugin {
private static AusterSystem austerSystem;
public final String PLUGINNAME = "AusterSystem";
public ConfigHandler handler;
    @Override
    public void onEnable() {
        austerSystem = this;
        handler = new ConfigHandler();
        BuildModeCommand buildModeCommand = new BuildModeCommand();
        Bukkit.getPluginCommand("build").setExecutor(buildModeCommand);
        getServer().getPluginManager().registerEvents(new BuildEvent(), this);
        PrefixCommand prefixCommand = new PrefixCommand();
        Bukkit.getPluginCommand("prefix").setExecutor(prefixCommand);
        Bukkit.getPluginCommand("prefix").setTabCompleter(prefixCommand);
        RankCommand rankCommand = new RankCommand();
        Bukkit.getPluginCommand("rank").setExecutor(rankCommand);

        }

    @Override
    public void onDisable() {

    }
    public static AusterSystem getInstance() {
        return austerSystem;
    }
}
