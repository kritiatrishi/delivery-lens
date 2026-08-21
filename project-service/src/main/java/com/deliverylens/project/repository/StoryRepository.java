package com.deliverylens.project.repository;

import com.deliverylens.project.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoryRepository extends JpaRepository<Story, Long> {
    List<Story> findBySprintId(Long sprintId);
}
