package com.power.springcloud.dao;

import com.power.springcloud.entities.CommonResult;
import com.power.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: PowerQun
 */
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeign {


    @GetMapping("/selectById/{id}")
    public CommonResult<Payment> selectById(@PathVariable("id") Long id) ;

}
