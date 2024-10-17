package com.learning.journalApp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;

@SpringBootApplication
//@Slf4j
@EnableScheduling
public class JournalApplication {

    public static void main(String[] args) {
        SpringApplication.run(JournalApplication.class, args);
//      Load active profiles list from application context
//        ConfigurableApplicationContext context = SpringApplication.run(JournalApplication.class, args);
//        ConfigurableEnvironment environment = context.getEnvironment();
//        log.info(Arrays.toString(environment.getActiveProfiles()));

    }

}