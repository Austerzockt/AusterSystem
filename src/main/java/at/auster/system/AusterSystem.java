package at.auster.system;

import at.auster.system.ranks.PrefixCommand;
import at.auster.system.ranks.RankCommand;
import at.auster.system.ranks.utils.PrefixUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.UUID;

public class AusterSystem extends JavaPlugin {


    @Override
    public void onEnable() {
        PrefixCommand command = new PrefixCommand();
        Bukkit.getPluginCommand("prefix").setExecutor(command);
        RankCommand rankCommand = new RankCommand();
        Bukkit.getPluginCommand("rank").setExecutor(rankCommand);

    }

    @Override
    public void onDisable() {

    }
}
