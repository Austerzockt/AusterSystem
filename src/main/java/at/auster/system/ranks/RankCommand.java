package at.auster.system.ranks;

import at.auster.system.ranks.utils.PrefixUtils;
import at.auster.system.ranks.utils.RankUtils;
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
import java.util.UUID;

public class RankCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender.hasPermission("system.rank")) {
            if (args.length == 0) {
                sender.sendMessage(new TextComponent(ChatColor.RED + "/rank [set/add/remove] [PlayerName] [Rank]"));
            } else if (args.length == 3) {
                Player t = Bukkit.getPlayer(args[1]);
                if (t != null && RankUtils.getAllRanks().contains(args[2])) {
                    switch (args[0]) {
                        case "set":
                            RankUtils.setRank(t.getUniqueId(), args[2]);
                            sender.sendMessage("SET RANK");
                            break;
                        case "remove":
                            RankUtils.removeRank(t.getUniqueId(), args[2]);
                            sender.sendMessage("REMOVE RANK");
                            break;
                        case "add":
                            RankUtils.addRank(t.getUniqueId(), args[2]);
                            sender.sendMessage("ADD RANK");
                            break;

                        default:
                            sender.sendMessage(ChatColor.RED + "Unknown SubCommand: set/remove/add");
                            break;
                    }
                    } else {
                    sender.sendMessage(ChatColor.RED + "Player not Online or Rank doesn't exist");
                }


                }

         }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        List<String> list = new ArrayList<>();
        if (args.length == 1) {
             list.add("set");
             list.add("add");
             list.add("remove");
        } else if (args.length == 2) {
            Bukkit.getOnlinePlayers().forEach(p -> list.add(p.getName()));
        } else if (args.length == 3) {
            list.addAll(RankUtils.getAllRanks());
        }
        return list;
    }
}
