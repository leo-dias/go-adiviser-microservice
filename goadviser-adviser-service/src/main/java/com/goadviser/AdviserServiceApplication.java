package com.goadviser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AdviserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdviserServiceApplication.class, args);
    }
}
