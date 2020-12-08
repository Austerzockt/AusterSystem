package at.auster.system.ranks;

import at.auster.system.ranks.utils.PrefixUtils;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PrefixCommand implements CommandExecutor, TabCompleter {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender.hasPermission("system.prefix")) {
            if (args.length == 0) {
                sender.sendMessage(new TextComponent(ChatColor.RED + "/prefix [set/remove] [Playername] [Prefix]"));
            } else if (args.length >= 3) {
                //SET Prefix
                if (args[0].equalsIgnoreCase("set")) {
                    //Check if Player is onlines
                    Player t = Bukkit.getPlayer(args[1]);
                    if (t != null) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 2; i < args.length; i++) {
                            sb.append(args[i]).append(" ");
                        }
                        String prefix = sb.toString();
                        PrefixUtils.setPrefix(t.getUniqueId(), prefix);
                        sender.sendMessage(new TextComponent(ChatColor.GOLD + "Set Prefix for Player " + t.getName() + " to " + ChatColor.translateAlternateColorCodes('&', prefix)));
                    }
                    //REMOVE Prefix
                }
                } else if (args.length == 2) {
                if (args[0].equalsIgnoreCase("remove")) {
                    //Check if Player is online
                    Player t = Bukkit.getPlayer(args[1]);
                    if (t != null) {
                        PrefixUtils.removePrefix(t.getUniqueId());
                    }
                }
            }

        } else {
            sender.sendMessage(new TextComponent(ChatColor.RED + "You don't have the permission to use this command"));
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        List<String> list = new ArrayList<>();


         if (args.length > 1) {
            Bukkit.getOnlinePlayers().forEach(player -> list.add(player.getName()));
        } else {
             list.add("set");
             list.add("remove");
        }
        return list;
    }
}
