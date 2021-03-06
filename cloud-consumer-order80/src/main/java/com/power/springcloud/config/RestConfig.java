package com.power.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: PowerQun
 */
@Configuration
public class RestConfig {

    @Bean
    @LoadBalanced
    // RestTemplate自带的负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
