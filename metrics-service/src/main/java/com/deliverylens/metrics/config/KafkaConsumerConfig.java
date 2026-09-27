package com.deliverylens.metrics.config;

import com.deliverylens.metrics.consumer.StoryStatusChangedEvent;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.mapping.DefaultJackson2JavaTypeMapper;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {

    @Bean
    public ConsumerFactory<String, StoryStatusChangedEvent> consumerFactory() {

        // JSON deserializer for the Metrics-side event DTO
        JsonDeserializer<StoryStatusChangedEvent> deserializer =
                new JsonDeserializer<>(StoryStatusChangedEvent.class);

        // Kafka producer puts the Project Service class name
        // into the __TypeId__ header.
        //
        // Tell Metrics Service to translate that type
        // into its own StoryStatusChangedEvent class.
        DefaultJackson2JavaTypeMapper typeMapper =
                new DefaultJackson2JavaTypeMapper();

        Map<String, Class<?>> typeMappings = new HashMap<>();

        typeMappings.put(
                "com.deliverylens.project.event.StoryStatusChangedEvent",
                StoryStatusChangedEvent.class
        );

        typeMapper.setIdClassMapping(typeMappings);

        // Trust the package containing the Metrics DTO
        typeMapper.addTrustedPackages(
                "com.deliverylens.metrics.consumer"
        );

        deserializer.setTypeMapper(typeMapper);

        // Kafka consumer properties
        Map<String, Object> config = new HashMap<>();

        config.put(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "localhost:9092"
        );

        config.put(
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class
        );

        config.put(
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                JsonDeserializer.class
        );

        return new DefaultKafkaConsumerFactory<>(
                config,
                new StringDeserializer(),
                deserializer
        );
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, StoryStatusChangedEvent>
    kafkaListenerContainerFactory() {

        ConcurrentKafkaListenerContainerFactory<String, StoryStatusChangedEvent>
                factory = new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(consumerFactory());

        return factory;
    }
}
