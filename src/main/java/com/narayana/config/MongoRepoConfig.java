package com.narayana.config;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = {"com.narayana.repo"})
public class MongoRepoConfig {
}
