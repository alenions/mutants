package com.mutants;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.mutants.application"})
@SpringBootApplication
public class MutantsApplication {
    public static void main(String[] args) {
        SpringApplication.run(MutantsApplication.class, args);
    }
}
