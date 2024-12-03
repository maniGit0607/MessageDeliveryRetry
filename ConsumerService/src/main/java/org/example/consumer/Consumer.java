package org.example.consumer;

import org.example.consumer.service.ConsumerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    ConsumerService consumerService;

    public Consumer(ConsumerService consumerService)
    {
        this.consumerService = consumerService;
    }

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void consumeMessage(String message) {
        System.out.println("Consumed: " + message);
        consumerService.sendToProcessor(message);
    }
}
