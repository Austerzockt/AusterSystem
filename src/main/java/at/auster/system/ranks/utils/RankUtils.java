package at.auster.system.ranks.utils;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;
import net.luckperms.api.node.types.InheritanceNode;
import net.luckperms.api.query.QueryOptions;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class RankUtils {
    private static LuckPerms luckPerms = LuckPermsProvider.get();
    public static List<String> getAllRanks() {
        List<String> list = new ArrayList<>();
        luckPerms.getGroupManager().getLoadedGroups().forEach(rank -> list.add(rank.getName()));
        return list;
    }
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
    public static boolean isRank(String group) {
        return getAllRanks().contains(group);
    }
    public static void setRank(UUID uuid, String group) {
        if (!isRank(group)) return;
        getRanks(uuid).forEach(s -> removeRank(uuid, s) );
    addRank(uuid, group);

    }
    public static void addRank(UUID uuid, String groupname) {
        User u = luckPerms.getUserManager().getUser(uuid);
        Group group = luckPerms.getGroupManager().getGroup(groupname);

        u.data().add(InheritanceNode.builder(group).build());
        luckPerms.getUserManager().saveUser(u);
    }
    public static void removeRank(UUID uuid, String groupname) {
        User u = luckPerms.getUserManager().getUser(uuid);
        Group group = luckPerms.getGroupManager().getGroup(groupname);
        u.data().remove(InheritanceNode.builder(group).build());
        luckPerms.getUserManager().saveUser(u);
    }

}
