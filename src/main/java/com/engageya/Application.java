package com.engageya;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

    private static final Logger logger = LoggerFactory
            .getLogger(Application.class);

    @PostConstruct
    public void logSomething() {
        logger.info("Application has started");
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
