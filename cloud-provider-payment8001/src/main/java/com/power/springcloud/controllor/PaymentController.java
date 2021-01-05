package com.power.springcloud.controllor;

import com.power.springcloud.entities.CommonResult;
import com.power.springcloud.entities.Payment;
import com.power.springcloud.service.impl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: PowerQun
 */
@RestController()
public class PaymentController {

    @Autowired
    public PaymentServiceImpl paymentServiceImpl;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/selectById/{id}")
    public CommonResult<Payment> selectById(@PathVariable Long id) {
        Payment payment = paymentServiceImpl.selectById(id);
        CommonResult<Payment> result = new CommonResult<>();
        result.setCode(200);
        result.setData(payment);
        result.setMessage("8001");
        return result;
    }

    @GetMapping("/discovery")
    public CommonResult<List> getDiscovery() {
        List<String> services = this.discoveryClient.getServices();
        services.forEach(service -> {
            List<ServiceInstance> instances = this.discoveryClient.getInstances(service);
            instances.forEach(instance -> {
                System.out.println(service + "==>" + instance.getHost() + ":" + instance.getPort());
            });
        });
        CommonResult<List> result = new CommonResult<>();
        result.setCode(200);
        result.setMessage("ok");
        result.setData(services);
        return result;
    }
}
