package com.deliverylens.metrics.consumer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoryStatusChangedEvent {
    private Long storyId;
    private Long sprintId;
    private String oldStatus;
    private String newStatus;

    public StoryStatusChangedEvent() {
    }
}
