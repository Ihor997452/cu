package com.my.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.my.repository.jpa")
@EnableMongoRepositories(basePackages = "com.my.repository.mongo")
public class RepositoryConfig {
}
