package at.auster.system.utils.data.mongodb;

import at.auster.system.utils.data.ISystemData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoSystemData implements ISystemData {
    MongoClient client;

    public MongoSystemData(String connectionstring) {
        client = MongoClients.create(connectionstring);

    }
}
