package com.power.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Hello world!
 */
@SpringBootApplication
public class Consumer80 {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Consumer80.class, args);
    }
}
