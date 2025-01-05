package aston.controller;

import aston.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class TestKafkaController {
    private final KafkaProducerService service;

    @PostMapping
    public void sendMessage(@RequestParam(value = "message", defaultValue = "Hello, World") String message) {
        service.sendMessage(message);
    }
}
