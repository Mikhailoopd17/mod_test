package com.example.mod_test.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Collection;
import java.util.Collections;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {
    @Value("${spring.data.mongodb.database}")
    private String dbName;

    @Value("${template.mongo.db.url}")
    private String dbUrl;

    protected String getDatabaseName() {
        return dbName;
    }

    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString(dbUrl);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    public Collection getMappingBasePackages() {
        return Collections.singleton("com.mod_test");
    }
}
