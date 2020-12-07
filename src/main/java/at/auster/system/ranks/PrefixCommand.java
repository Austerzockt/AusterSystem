package at.auster.system.ranks;

import at.auster.system.ranks.utils.PrefixUtils;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class PrefixCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player p = (Player) sender;

        if (sender.hasPermission("system.prefix")) {
            p.sendMessage(new TextComponent(PrefixUtils.getPrefix(p.getUniqueId())));
        } if (args.length == 1) {
            PrefixUtils.setPrefix(p.getUniqueId(), args[0]);
        }
        return true;
    }
}
