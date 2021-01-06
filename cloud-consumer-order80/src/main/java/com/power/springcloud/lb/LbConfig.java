package com.power.springcloud.lb;

import com.netflix.loadbalancer.IRule;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;

/**
 * @Author: PowerQun
 */
//name：建议写服务名称     configuration：配置类
//http://springCloud-ribbon-police/getPolice 调用"springCloud-ribbon-police"这个服务ID的时候，将会启用下面的配置
@RibbonClient(name = "cloud-payment-service", configuration=LbConfig.class)
public class LbConfig {

     @Bean
    public IRule getRule(){
         return new MyRule();
     }
}
