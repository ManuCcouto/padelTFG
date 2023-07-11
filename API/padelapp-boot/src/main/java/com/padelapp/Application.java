package com.padelapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories
public class Application {
    public static void main(String[] args) throws SQLException {
        SpringApplication.run(Application.class, args);

    }
}
