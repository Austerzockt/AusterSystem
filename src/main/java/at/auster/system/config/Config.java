package at.auster.system.config;

import at.auster.system.AusterSystem;
import org.apache.commons.io.IOUtils;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.logging.Level;

public class Config extends YamlConfiguration {
    private String name;
    private File file;
    private final Plugin plugin;
    ;
    public Config(String name, Plugin plugin) {
        this.name = name;
        this.plugin = plugin;
        file = new File(AusterSystem.getInstance().getDataFolder(), name.endsWith(".yml") ? name : name + ".yml");        if (!file.exists()) {
            InputStream is = AusterSystem.getInstance().getResource(name + ".yml");
            AusterSystem.getInstance().saveResource(name + ".yml", false);
        }
    }
    private void loadConfig() throws IOException, InvalidConfigurationException {
        if (!plugin.getDataFolder().exists())
            plugin.getDataFolder().mkdir();

        if (!file.exists()) {
            try {
                // Save the config file if found inside the jar
                plugin.saveResource(file.getName(), false);
            } catch (IllegalArgumentException e) {
                // File not found in resources, creating a blank one
                file.createNewFile();
            }
        }

        load(file);
    }
    public void save() {
        try {
            save(file);
        } catch (IOException e) {
            plugin.getLogger().log(Level.SEVERE, "There was an error while saving the " + file.getName() + " configuration!", e);
        }
    }

    public void reload() {
        try {
            loadConfig();
        } catch (IOException e) {
            plugin.getLogger().log(Level.SEVERE, "There was an error while creating the " + file.getName() + " configuration file!", e);
        } catch (InvalidConfigurationException e) {
            plugin.getLogger().log(Level.SEVERE, "The configuration \"" + file.getName() + "\" is invalid!", e);
        }
    }
    public String getName() {
        return name;
    }
}

