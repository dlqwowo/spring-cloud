package com.power.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.*;

/**
 * @Author: PowerQun
 */
@SpringBootApplication
public class PaymentMain8001 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ConfigurableApplicationContext run = SpringApplication.run(PaymentMain8001.class, args);
    }
}
