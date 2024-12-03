package org.example.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "processor", url = "http://localhost:8082")
public interface FeignProcessorClient {
    @PostMapping("/api/messages")
    void sendMessage(@RequestBody String message);
}
