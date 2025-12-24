package com.ram.lb;

import com.ram.lb.algo.LoadBalancingAlgo;
import com.ram.lb.algo.RoundRobinBalancingAlgo;
import com.ram.lb.model.Server;

public class LoadBalancerDemo {
    public static void main(String[] args) {

        // chose load balancing algo
        LoadBalancingAlgo loadBalancingAlgo=new RoundRobinBalancingAlgo();
        LoadBalancer loadBalancer=new LoadBalancer(loadBalancingAlgo);

        for (int i = 1; i <=10 ; i++) {
            loadBalancer.addServer(new Server(
                    "server"+1,
                    "server"+1,
                    "192.168.1."+(100+i),
                    8080
            ));
        }

        for (int i = 0; i <20 ; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Server server=loadBalancer.getServer();
            System.out.println(server);
        }

        // concurrent access
        System.out.println("Concurrent server selection..");
        for (int i = 0; i <20 ; i++) {
            new Thread(()->{
                Server server=loadBalancer.getServer();
                System.out.println(server);
            }).start();
        }

    }

}
