package com.power.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableFeignClients
public class ConsumerFeignOrder802 {
    public static void main(String[] args) {

        SpringApplication.run(ConsumerFeignOrder802.class, args);

    }
}
