package at.auster.system.build;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.List;

public class BuildModeCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args){
      if (command.getName().equalsIgnoreCase("build")) {
          if (sender instanceof Player) {
              Player p = ((Player) sender);
              if (p.hasPermission("system.build")) {

                  if (args.length == 0) {
                      if (BuildUtils.toggleBuilderMode(p.getUniqueId())) {
                          p.sendMessage(ChatColor.GOLD + "BuildMode " + ChatColor.DARK_GREEN + "enabled");
                      } else {
                          p.sendMessage(ChatColor.GOLD + "BuildMode " + ChatColor.DARK_RED + "disabled");

                      }
                  }
              }
          } else {
              sender.sendMessage(ChatColor.RED + "You must be a player to use this command");
          }
      }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender,  Command command, String s, String[] args) {
        return null;
    }
}
