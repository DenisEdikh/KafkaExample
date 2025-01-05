package aston.service;

import aston.config.property.KafkaPropertiesConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaPropertiesConfig kafkaPropertiesConfig;

    public void sendMessage(String message) {
        kafkaTemplate.send(kafkaPropertiesConfig.getProducer().getTopic(), message);
    }
}
