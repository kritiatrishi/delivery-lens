package com.deliverylens.metrics.service;


import com.deliverylens.metrics.model.Status;
import com.deliverylens.metrics.model.StoryMetric;
import com.deliverylens.metrics.repository.StoryMetricRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoryMetricService {
    private final StoryMetricRepository repository;
    public StoryMetric createStory(StoryMetric storyMetric) {

        if (storyMetric.getStatus() == null) {
            storyMetric.setStatus(Status.TO_DO);
        }
        return repository.save(storyMetric);
    }

    public List<StoryMetric> getStoryBySprint(Long sprintId) {
        return repository.findBySprintId(sprintId);
    }


}
