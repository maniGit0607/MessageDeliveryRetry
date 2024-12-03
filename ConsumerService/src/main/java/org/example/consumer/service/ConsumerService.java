package org.example.consumer.service;

import org.example.entity.FailedMessage;
import org.example.repository.FailedMessageRepository;
import org.example.restclient.FeignProcessorClient;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService {

    private final FeignProcessorClient feignProcessorClient;
    private final FailedMessageRepository failedMessageRepository;

    public ConsumerService(FeignProcessorClient feignProcessorClient, FailedMessageRepository failedMessageRepository)
    {
        this.feignProcessorClient = feignProcessorClient;
        this.failedMessageRepository = failedMessageRepository;
    }

    public void sendToProcessor(String message)
    {
        try {
            feignProcessorClient.sendMessage(message);
        } catch (Exception e) {
            System.out.println("Failed to send message: " + message);
            FailedMessage failedMessage = new FailedMessage();
            failedMessage.setMessage(message);
            failedMessage.setRetryCount(0);
            failedMessageRepository.save(failedMessage);
        }
    }

}
