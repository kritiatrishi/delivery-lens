package com.deliverylens.metrics.controller;

import com.deliverylens.metrics.model.StoryMetric;
import com.deliverylens.metrics.repository.StoryMetricRepository;
import com.deliverylens.metrics.service.StoryMetricService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metrics")
@RequiredArgsConstructor
public class StoryMetricController {
    private final StoryMetricService service;
    @PostMapping("/stories")
    public StoryMetric createStoryMetric(@RequestBody StoryMetric storyMetric) {
        return service.createStory(storyMetric);
    }

    @GetMapping("/sprint/{sprintId}")
    public List<StoryMetric> getBySprint(@PathVariable Long sprintId) {
        return service.getStoryBySprint(sprintId);
    }

}
