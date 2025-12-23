package com.ram.lb.algo;

import com.ram.lb.LoadBalancer;
import com.ram.lb.model.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

public class RandomLoadBalancingAlgo implements LoadBalancingAlgo {
    private static final Logger log=Logger.getLogger(RandomLoadBalancingAlgo.class.getName());
    @Override
    public Server selectServer(List<Server> servers) {
        log.info("selected LoadBalancing algo :"+RandomLoadBalancingAlgo.class.getSimpleName());
        return servers.get(ThreadLocalRandom.current().nextInt(servers.size()));
    }
}
