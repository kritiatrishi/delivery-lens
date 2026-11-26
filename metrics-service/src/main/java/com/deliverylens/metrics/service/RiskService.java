package com.deliverylens.metrics.service;

import com.deliverylens.metrics.dto.SprintHealthResponse;
import com.deliverylens.metrics.model.Status;
import com.deliverylens.metrics.model.StoryMetric;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RiskService {
    private final StoryMetricService storyMetricService;

    public SprintHealthResponse getSprintHealth(Long sprintId) {

        List<StoryMetric> stories = storyMetricService.getStoryBySprint(sprintId);
        int totalStories = stories.size();
        int completedStories = (int) stories.stream().filter(s -> s.getStatus() == Status.DONE).count();
        int blockedStories = (int) stories.stream().filter(s -> s.getStatus() == Status.BLOCKED).count();
        int remainingStories = totalStories - completedStories;
        double completionRate = totalStories == 0 ? 0.0 : completedStories * 100.0 / totalStories;
        String health;
        List<String> riskReasons = new ArrayList<>();
        if (blockedStories >= 2) {
            health = "RED";
            riskReasons.add(blockedStories + "stories are blocked");
        } else if (blockedStories == 1) {
            health = "YELLOW";
            riskReasons.add("1 story is blocked");
        } else {
            health = "GREEN";
        }
        return new SprintHealthResponse(sprintId,
                health, totalStories, completedStories, blockedStories, remainingStories, completionRate, riskReasons);
    }

}
