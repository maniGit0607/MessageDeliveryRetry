package org.example.job;

import org.example.restclient.FeignProcessorClient;
import org.example.entity.FailedMessage;
import org.example.repository.FailedMessageRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RetryJob {

    private final FailedMessageRepository failedMessageRepository;
    private final FeignProcessorClient feignProcessorClient;

    public RetryJob(FailedMessageRepository failedMessageRepository, FeignProcessorClient feignProcessorClient) {
        this.failedMessageRepository = failedMessageRepository;
        this.feignProcessorClient = feignProcessorClient;
    }

    @Scheduled(fixedRate = 10000)
    public void retryFailedMessages() {
        List<FailedMessage> failedMessages = failedMessageRepository.findAll();

        for (FailedMessage failedMessage : failedMessages) {
            try {
                feignProcessorClient.sendMessage(failedMessage.getMessage());
                failedMessageRepository.delete(failedMessage);
            } catch (Exception e) {
                failedMessage.setRetryCount(failedMessage.getRetryCount() + 1);
                if (failedMessage.getRetryCount() >= 10) {
                    failedMessageRepository.delete(failedMessage);
                } else {
                    failedMessageRepository.save(failedMessage);
                }
            }
        }
    }
}
