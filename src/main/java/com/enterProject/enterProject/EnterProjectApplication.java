package com.enterProject.enterProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EnterProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnterProjectApplication.class, args);
    }

}
