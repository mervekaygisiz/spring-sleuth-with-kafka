package com.example.kafkaproducer.controller;

import com.example.kafkaproducer.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produce")
public class KafkaProducerController {

    private final Logger logger = LoggerFactory.getLogger(KafkaProducerController.class);
    private final KafkaProducer kafkaProducer;

    public KafkaProducerController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping
    public void sendMessage(@RequestParam("message") String message) {
        logger.info("Producer started.");
        kafkaProducer.produce(message);
        logger.info("Producer finished.");

    }
}
