package com.deliverylens.project.event;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
public class StoryEventProducer {
    private static final String TOPIC= "story-events";

    private final KafkaTemplate<String,StoryStatusChangedEvent> kafkaTemplate;
    public StoryEventProducer(KafkaTemplate<String, StoryStatusChangedEvent> kafkaTemplate){
        this.kafkaTemplate=kafkaTemplate;
    }
    public void publishStatusChanged(StoryStatusChangedEvent event){
        kafkaTemplate.send(TOPIC, event.getStoryId().toString(),event);
    }

}