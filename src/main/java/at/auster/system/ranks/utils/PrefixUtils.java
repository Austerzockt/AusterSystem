package at.auster.system.ranks.utils;

import me.neznamy.tab.api.EnumProperty;
import me.neznamy.tab.api.TABAPI;

import java.util.UUID;

public class PrefixUtils {

    public static String getPrefix(UUID uuid)  {
            return TABAPI.getPlayer(uuid).getOriginalValue(EnumProperty.TABPREFIX);

    }
    public static void setPrefix(UUID uuid, String prefix, boolean temp) {
        if (temp) {
            TABAPI.getPlayer(uuid).setValueTemporarily(EnumProperty.TABPREFIX, prefix);
            TABAPI.getPlayer(uuid).setValueTemporarily(EnumProperty.TAGPREFIX, prefix);

        } else {
            TABAPI.getPlayer(uuid).setValuePermanently(EnumProperty.TABPREFIX, prefix);
            TABAPI.getPlayer(uuid).setValuePermanently(EnumProperty.TAGPREFIX, prefix);
        }
    }
    public static void setPrefix(UUID uuid, String prefix) {
        setPrefix(uuid, prefix, false);
    }
    public static void removePrefix(UUID uuid) {
        TABAPI.getPlayer(uuid).setValuePermanently(EnumProperty.TABPREFIX, "");
        TABAPI.getPlayer(uuid).setValuePermanently(EnumProperty.TAGPREFIX, "");

    }
}
