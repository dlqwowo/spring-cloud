package com.power.springcloud.controller;

import com.power.springcloud.entities.CommonResult;
import com.power.springcloud.entities.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: PowerQun
 */
@RestController
public class OrderController {

    @Resource
    public RestTemplate restTemplate;

    @GetMapping("/selectById/{id}")
    public CommonResult<Payment> selectById(@PathVariable Long id) {
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity("http://cloud-payment-service/selectById/1", CommonResult.class);
        CommonResult<Payment> body = forEntity.getBody();
        return body;
    }

}
