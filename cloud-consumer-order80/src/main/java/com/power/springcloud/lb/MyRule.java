package com.power.springcloud.lb;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: PowerQun
 */
@Slf4j
public class MyRule extends AbstractLoadBalancerRule {

    private AtomicInteger nextServerCyclicCounter;


    public MyRule() {
        this.nextServerCyclicCounter = new AtomicInteger(0);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }


    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            log.warn("no load balancer");
            return null;
        } else {
            Server server = null;
            int count = 0;
            while (true) {
                if (server == null && count++ < 10) {
                    List<Server> reachableServers = lb.getReachableServers();
                    List<Server> allServers = lb.getAllServers();
                    if (!CollectionUtils.isEmpty(reachableServers) || !CollectionUtils.isEmpty(allServers)) {
                        int serverCount = allServers.size();
                        int nextServerIndex = this.incrementAndGetModulo(serverCount);
                        server = allServers.get(nextServerIndex);
                        if (server == null) {
                            Thread.yield();
                        } else {
                            if (server.isAlive() && server.isReadyToServe()) {
                                return server;
                            }
                            server = null;
                        }
                    } else {
                        continue;
                    }
                    log.warn("No up servers available from load balancer: " + lb);
                }
                if (count >= 10) {
                    log.warn("No available alive servers after 10 tries from load balancer: " + lb);
                }
                return null;
            }

        }

    }


    public int incrementAndGetModulo(int serverCount) {
        int current;
        int next;
        do {
            current = this.nextServerCyclicCounter.get();
            if (current == Integer.MAX_VALUE) {
                log.error("request count too large");
            }
            next = (current + 1) % serverCount;
        } while (!this.nextServerCyclicCounter.compareAndSet(current, next));
        return next;
    }
}
