package com.example.assess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class AssessApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssessApplication.class, args);
    }
}
