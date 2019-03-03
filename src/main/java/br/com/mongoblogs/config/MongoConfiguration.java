package br.com.mongoblogs.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfiguration {

    @Bean
    public MongoClient createConnection() {
        return new MongoClient("localhost:27017");
    }
}
