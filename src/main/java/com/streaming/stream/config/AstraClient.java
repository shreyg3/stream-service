package com.streaming.stream.config;

import com.datastax.astra.client.DataAPIClient;
import com.datastax.astra.client.Database;

public class AstraClient {

    public void getAstraClient(String token) {
        DataAPIClient client = new DataAPIClient(token);
        Database db = client.getDatabase("https://72fa98f4-2401-49fe-a928-550e545ea7f2-us-east-2.apps.astra.datastax.com");
        System.out.println("Connected to AstraDB " + db.listCollectionNames());
    }
}
