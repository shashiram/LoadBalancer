package com.ram.lb.algo;

import com.ram.lb.LoadBalancer;
import com.ram.lb.model.Server;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class RoundRobinBalancingAlgo implements LoadBalancingAlgo {
    private static final Logger log=Logger.getLogger(RoundRobinBalancingAlgo.class.getName());
    private final AtomicInteger atomicInteger=new AtomicInteger(0);
    @Override
    public Server selectServer(List<Server> servers) {
        log.info("selected LoadBalancing algo :"+RoundRobinBalancingAlgo.class.getSimpleName());
        return servers.get(atomicInteger.getAndIncrement()%servers.size());
    }
}
