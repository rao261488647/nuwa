package com.ron.rao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class NuwaApplication {

    public static void main(String[] args) {
        SpringApplication.run(NuwaApplication.class, args);
    }

}
