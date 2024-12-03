package org.example.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Producer {

    private final AmqpTemplate amqpTemplate;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    public Producer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @Scheduled(fixedRate = 10000)
    public void sendMessage() {
        String message = "Message sent at " + LocalDateTime.now();
        amqpTemplate.convertAndSend(exchange, routingKey, message);
        System.out.println("Produced: " + message);
    }
}
