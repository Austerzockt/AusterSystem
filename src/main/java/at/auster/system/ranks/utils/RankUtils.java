package at.auster.system.ranks.utils;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.group.Group;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

public class RankUtils {
    private static LuckPerms luckPerms = LuckPermsProvider.get();
    public static List<String> getRanks(UUID uuid) {
        Player p = Bukkit.getPlayer(uuid);
        List<String> returns = new ArrayList<>();
        for (Group group:
                luckPerms.getGroupManager().getLoadedGroups()) {
            if (p.hasPermission("group." + group.getName())) {
                returns.add(group.getName());
            }
        }
    return returns;

    }
    public static void setRank(UUID uuid) {

    }
    public static void addRank(UUID uuid) {

    }
    public static void removeRank(UUID uuid) {

    }

}
