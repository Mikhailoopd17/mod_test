package com.example.mod_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class ModTestApplication {
    public final static String USER_PROFILE = "profile";

    public static void main(String[] args) {
        SpringApplication.run(ModTestApplication.class, args);
    }

}
