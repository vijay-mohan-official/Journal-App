package com.learning.journalApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class TransactionConfig {
//    PlatformTransactionManager is an interface that provides the ability to manage transactions.
//    By defining this bean, you are specifying how SpringBoot should handle transactions in your application.
//    MongoDbFactory is used to create connections to the MongoDB database.
    @Bean
    public PlatformTransactionManager platformTransactionManager(MongoDatabaseFactory mongoDbFactory) {
        return new MongoTransactionManager(mongoDbFactory);
    }
}
