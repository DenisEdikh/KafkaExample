package aston.config.property;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ToString
@ConfigurationProperties("spring.kafka")
public class KafkaPropertiesConfig {
    private String bootstrapServers;
    private Consumer consumer;
    private Producer producer;

    @PostConstruct
    public void init() {
        System.out.println("KafkaPropertiesConfig initialized: " + this);
    }

    @Setter
    @Getter
    @ToString
    public static class Consumer {
        private String groupId;
        private TypeReset autoOffsetReset;
        private Class<?> keyDeserializer;
        private Class<?> valueDeserializer;
    }

    @Setter
    @Getter
    @ToString
    public static class Producer {
        private Class<?> keySerializer;
        private Class<?> valueSerializer;
        private int retries;
        private int acks;
        private int retryBackoff;
        private String topic;
    }

    public enum TypeReset {
        EARLIEST,
        LATEST,
        NONE
    }
}
