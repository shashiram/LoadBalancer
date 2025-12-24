package com.ram.lb;


import com.ram.lb.algo.LoadBalancingAlgo;
import com.ram.lb.exception.MaxCapacityExceededException;
import com.ram.lb.model.Server;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Logger;

import static com.ram.lb.constant.AppConstant.MAX_CAPACITY;

public class LoadBalancer {
    private static final Logger log=Logger.getLogger(LoadBalancer.class.getName());
    private final List<Server> servers=new CopyOnWriteArrayList<>();
    private final ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
    private LoadBalancingAlgo loadBalancingAlgo;

    public LoadBalancer(LoadBalancingAlgo loadBalancingAlgo){
        this.loadBalancingAlgo=loadBalancingAlgo;
    }

    public void addServer(Server server){

        if(server==null){
            log.severe("Attempted to add null server");
            throw new IllegalArgumentException("invalid server");
        }
        lock.writeLock().lock();
        try {
            if(servers.size()>=MAX_CAPACITY){
                log.warning(() ->
                        String.format("Max capacity reached (%d). Server rejected: %s",
                                MAX_CAPACITY, server));
                throw new MaxCapacityExceededException("capacity exceeded");
            }

            servers.add(server);
            log.info(() ->
                    String.format("Server added successfully. Server=%s, TotalServers=%d",
                            server, servers.size()));
        }
        finally {
            lock.writeLock().unlock();
        }
    }

    public Server getServer(){
        return this.loadBalancingAlgo.selectServer(servers);
    }
}
