package com.power.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.*;

/**
 * @Author: PowerQun
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8001 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ConfigurableApplicationContext run = SpringApplication.run(PaymentMain8001.class, args);
    }
}
