package com.narayana.config;

import com.mongodb.ReadPreference;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import de.bwaldvogel.mongo.MongoServer;
import de.bwaldvogel.mongo.ServerVersion;
import de.bwaldvogel.mongo.backend.memory.MemoryBackend;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;

@Configuration
public class MongoAppConfig {
    private static final String MONGO_DB_LOCALHOST = "localhost";
    private static final Integer MONGO_DB_PORT = 27017;
    private static final String MONGO_DB_NAME = "narayana_db";

    @Bean(destroyMethod = "shutdown")
    public MongoServer mongoServer() {
        MongoServer mongoServer = new MongoServer(new MemoryBackend().version(ServerVersion.MONGO_3_6));
        mongoServer.bind(MONGO_DB_LOCALHOST, MONGO_DB_PORT);
        return mongoServer;
    }
    @Bean(destroyMethod = "close")
    public MongoClient mongoClient() {
        return MongoClients.create();
    }
    @Bean
    public MongoTemplate mongoTemplate() throws IOException {
        MongoClient mongoClient = mongoClient();
        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, MONGO_DB_NAME);
        mongoTemplate.setWriteConcern(new WriteConcern(WriteConcern.MAJORITY.getWString()));
        mongoTemplate.setReadPreference(ReadPreference.primary());
        return mongoTemplate;
    }
}
