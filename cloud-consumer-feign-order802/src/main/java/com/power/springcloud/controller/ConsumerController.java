package com.power.springcloud.controller;

import com.power.springcloud.dao.PaymentFeign;
import com.power.springcloud.entities.CommonResult;
import com.power.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: PowerQun
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    PaymentFeign paymentFeign;

    @GetMapping("/selectById/{id}")
    public  CommonResult<Payment> selectById(@PathVariable("id") Long id) {
        CommonResult<Payment> result = this.paymentFeign.selectById(id);
        return result;
    }
}
