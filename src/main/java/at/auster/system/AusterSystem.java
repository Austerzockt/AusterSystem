package at.auster.system;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.UUID;

public class AusterSystem extends JavaPlugin {

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }
    @EventHandler
    public void onJoin(AsyncPlayerPreLoginEvent event) {
        List<UUID> banned = null;
        if (banned.contains(event.getUniqueId())) {
            event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_BANNED, "YOU ARE BANNED");
        }
    }
}
