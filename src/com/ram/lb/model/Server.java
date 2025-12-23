package com.ram.lb.model;

public class Server {
    private final String id;
    private final String name;
    private final String ipAddress;
    private final int port;

    public Server(String id, String name, String ipAddress, int port) {
        this.id = id;
        this.name = name;
        this.ipAddress = ipAddress;
        this.port = port;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public int getPort() {
        return port;
    }

    @Override
    public String toString() {
        return "Server{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", port=" + port +
                '}';
    }
}
