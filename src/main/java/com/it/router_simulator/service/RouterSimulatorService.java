package com.it.router_simulator.service;

import com.it.router_simulator.model.Router;
import com.it.router_simulator.producer.RouterProducer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Service
public class RouterSimulatorService {

    private final RouterProducer producer;
    private final Random random = new Random();

    public RouterSimulatorService(RouterProducer producer) {
        this.producer = producer;
    }

    @Scheduled(fixedRate = 5000)
    public void generate() {

        for (int i = 1; i <= 3; i++) {

            Router metric = new Router(
                    "R" + i,
                    "192.168.1." + i,
                    random.nextInt(20000),
                    random.nextDouble() * 100,
                    random.nextDouble() * 100,
                    random.nextBoolean() ? "HEALTHY" : "DOWN",
                    LocalDateTime.now()
            );

            producer.send(metric);
        }
    }
}