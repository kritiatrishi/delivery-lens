package com.deliverylens.metrics.dto;


import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SprintHealthResponse {
    private Long sprintId;
    private String health;
    private int totalStories;
    private int completedStories;
    private int blockedStories;
    private int remainingStories;
    private double completionRate;
    private List<String> riskReasons;



}
