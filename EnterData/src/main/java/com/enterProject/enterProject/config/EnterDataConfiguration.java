package com.enterProject.enterProject.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.enterProject.enterProject")
@EnableJpaRepositories(basePackages = "com.enterProject.enterProject")
@EnableJpaAuditing
public class EnterDataConfiguration {
}
