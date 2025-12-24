package com.ram.lb.algo;

import com.ram.lb.model.Server;

import java.util.List;

public interface LoadBalancingAlgo {
    Server selectServer(List<Server> servers);
}
