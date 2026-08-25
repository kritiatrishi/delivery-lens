package com.deliverylens.metrics.repository;

import com.deliverylens.metrics.model.StoryMetric;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoryMetricRepository extends JpaRepository<StoryMetric, Long> {
    List<StoryMetric> findBySprintId(Long sprintId);
}
