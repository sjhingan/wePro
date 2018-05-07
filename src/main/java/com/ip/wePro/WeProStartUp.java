package com.ip.wePro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This represent the starting point of the spring application.
 * Every spring-boot application have one main method which determines the starting point.
 */
@SpringBootApplication
public class WeProStartUp {

    /**
     * Main method of the spring application.
     * @param args list of arguments to the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(WeProStartUp.class, args);
    }
}
