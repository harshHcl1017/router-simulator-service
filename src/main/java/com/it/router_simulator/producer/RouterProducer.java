package com.it.router_simulator.producer;

import com.it.router_simulator.model.Router;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class RouterProducer {

    private final KafkaTemplate<String, Router> kafkaTemplate;
    private static final String TOPIC = "router-metrics";

    public RouterProducer(KafkaTemplate<String, Router> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Router router) {
        kafkaTemplate.send(TOPIC, router);
        System.out.println("Sent Router Data: " + router.getRouterId());
    }
}