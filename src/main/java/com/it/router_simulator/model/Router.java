package com.it.router_simulator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Router {

    private String routerId;
    private String ipAddress;
    private int activeConnections;
    private double cpuUsage;
    private double memoryUsage;
    private String status;
    private LocalDateTime timestamp;


}