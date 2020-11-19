package at.auster.system.utils.data.json;

import at.auster.system.utils.data.ISystemData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonSystemData implements ISystemData {
    private static Gson gson;

    public JsonSystemData() {
        gson = new GsonBuilder().serializeNulls().create();

    }
}
