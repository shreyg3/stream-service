package com.streaming.stream.config;

import com.datastax.astra.client.DataAPIClient;
import com.datastax.astra.client.Database;
import org.springframework.beans.factory.annotation.Value;

public class AstraClient {

    @Value("${astraToken}")
    private String token;

    public AstraClient() {
        DataAPIClient client = new DataAPIClient("AstraCS:nlZxtofigoNbTJtIOpSUjRyL:241dbdbcb8401ae5c2b922e429b8d00558599732df4e0c1905027163adea2703");
        Database db = client.getDatabase("https://72fa98f4-2401-49fe-a928-550e545ea7f2-us-east-2.apps.astra.datastax.com");
        System.out.println("Connected to AstraDB " + db.listCollectionNames());
    }
}
