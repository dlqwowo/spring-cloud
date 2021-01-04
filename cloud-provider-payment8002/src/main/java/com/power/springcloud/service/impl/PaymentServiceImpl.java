package com.power.springcloud.service.impl;

import com.power.springcloud.dao.PaymentDao;
import com.power.springcloud.entities.Payment;
import com.power.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: PowerQun
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentDao paymentDao;


    @Override
    public Payment selectById(Long id) {
        return paymentDao.selectById(id);
    }

    @Override
    public void create(Payment payment) {
        paymentDao.create(payment);
    }
}

