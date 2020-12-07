package at.auster.system.ranks;

import at.auster.system.ranks.utils.RankUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RankCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender.hasPermission("system.rank")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                RankUtils.getRanks(p.getUniqueId()).forEach((s1 -> {
                    p.sendMessage(s1);
                }));
            }
        }

        return true;
    }
}
