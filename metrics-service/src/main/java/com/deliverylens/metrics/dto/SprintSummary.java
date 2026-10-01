package com.deliverylens.metrics.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SprintSummary {
    private Long sprintId;
    private int totalStories;
    private int completedStories;
    private double completionRate;
}
