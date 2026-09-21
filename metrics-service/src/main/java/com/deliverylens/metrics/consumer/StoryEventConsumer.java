package com.deliverylens.metrics.consumer;

import com.deliverylens.metrics.model.StoryMetric;
import com.deliverylens.metrics.model.Status;
import com.deliverylens.metrics.service.StoryMetricService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoryEventConsumer {
    private final StoryMetricService storyMetricService;

    @KafkaListener(
            topics = "story-events",
            groupId = "metrics-service"
    )
    public void consume(StoryStatusChangedEvent event) {

        StoryMetric metric = new StoryMetric();
        metric.setId(event.getStoryId());
        metric.setSprintId(event.getSprintId());
        metric.setStatus(Status.valueOf(event.getNewStatus()));

        storyMetricService.save(metric);

        System.out.println(
                "Received story event: "
                        + event.getStoryId()
                        + " -> "
                        + event.getNewStatus()
        );
    }
}
