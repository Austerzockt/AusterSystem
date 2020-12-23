package at.auster.system.config;

import at.auster.system.AusterSystem;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class ConfigHandler {
    ArrayList<Config> configs = new ArrayList<>();
    public ConfigHandler() {
        Plugin plugin = AusterSystem.getInstance();
        configs.add(new Config("config", plugin));
        configs.add(new Config("messages", plugin));
    }
    public ArrayList<Config> getConfigs() {
        return configs;
    }
    public Config getConfig(String name) {
        for (Config config:
             configs) {

            if (config.getName().equalsIgnoreCase(name)) return config;
        }
        return null;
    }
}
