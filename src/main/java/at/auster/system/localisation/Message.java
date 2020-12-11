package at.auster.system.localisation;

import org.bukkit.ChatColor;

public class Message {
    private String message;
    public Message(String message) {
        this.message = message;

    }
    public void replacePlaceholder(String placeholder, String value) {
        if (message.contains("%" + placeholder + "%")) {
            message = message.replace("%" + placeholder + "%", value);
        }
    }

    @Override
    public String toString() {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
