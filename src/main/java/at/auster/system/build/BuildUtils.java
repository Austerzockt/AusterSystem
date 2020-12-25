package at.auster.system.build;

import java.util.HashMap;
import java.util.UUID;

public class BuildUtils {
    private static HashMap<UUID, Boolean> builders = new HashMap<>();



    public static void setBuilderMode(UUID uuid, boolean builder) {
        builders.put(uuid, builder);


    }
    public static boolean toggleBuilderMode(UUID uuid) {
        if (builders.containsKey(uuid)) {
            builders.put(uuid, !builders.get(uuid));
        } else {
            builders.put(uuid, true);
        }
        return builders.get(uuid);
    }
    public static boolean getBuilderMode(UUID uuid) {
        if (builders.containsKey(uuid)) {
            return builders.get(uuid);

        }
        return false;
    }
}
