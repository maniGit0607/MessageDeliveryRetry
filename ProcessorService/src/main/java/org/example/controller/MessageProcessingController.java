package org.example.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageProcessingController {

    @PostMapping
    public void receiveMessage(@RequestBody String message) {
        System.out.println("Received by Processor: " + message);
    }
}
