package com.power.springcloud.controllor;

import com.power.springcloud.entities.CommonResult;
import com.power.springcloud.entities.Payment;
import com.power.springcloud.service.impl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: PowerQun
 */
@RestController
public class PaymentController {

    @Autowired
    public PaymentServiceImpl paymentServiceImpl;

    @GetMapping("/selectById/{id}")
    public CommonResult<Payment> selectById(@PathVariable Long id) {
        Payment payment = paymentServiceImpl.selectById(id);
        CommonResult<Payment> result = new CommonResult<>();
        result.setCode(200);
        result.setData(payment);
        result.setMessage("8002");
        return result;
    }
}
