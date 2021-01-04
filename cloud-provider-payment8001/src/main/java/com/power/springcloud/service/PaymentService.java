package com.power.springcloud.service;

import com.power.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: PowerQun
 */
public interface PaymentService {


    public Payment selectById(@Param("id") Long id);

    public void create(Payment payment);

}
