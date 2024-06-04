package com.code.BusinessSecurity.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.code.*")
@EnableJpaRepositories("com.code")
@EntityScan("com.code.*")
@EnableFeignClients("com.code.*")
public class Launcher {
    public static void main(String[] args) {
        SpringApplication.run(Launcher.class,args);
    }
}
