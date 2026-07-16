package com.enterProject.enterBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.enterProject")
public class EnterBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnterBootApplication.class, args);
    }
}
