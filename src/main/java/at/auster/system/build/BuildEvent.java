package at.auster.system.build;

import at.auster.system.AusterSystem;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.event.extent.EditSessionEvent;
import com.sk89q.worldedit.extent.NullExtent;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.List;

public class BuildEvent implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (!BuildUtils.getBuilderMode(event.getPlayer().getUniqueId())) {
            if (checkWorld(event.getPlayer().getWorld())) {
                event.setCancelled(true);
            }
        }

    }
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (!BuildUtils.getBuilderMode(event.getPlayer().getUniqueId())) {
            if (checkWorld(event.getPlayer().getWorld())) {
                event.setCancelled(true);

            }
        }
    }
    @EventHandler
    public void onEntityInteract(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            if (!BuildUtils.getBuilderMode(event.getDamager().getUniqueId())) {
                if (checkWorld(event.getDamager().getWorld())) {
                    event.setCancelled(true);

                }
            }
        }

    }
    public boolean checkWorld(World world) {

        return AusterSystem.getInstance().handler.getConfig("config").getConfigurationSection("build").getStringList("worlds").contains(world.getName());
    }


}
