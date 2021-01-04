package com.power.springcloud.dao;

import com.power.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: PowerQun
 */
@Mapper
public interface PaymentDao {

    public Payment selectById(@Param("id") Long id);

    public void create(Payment payment);
}
