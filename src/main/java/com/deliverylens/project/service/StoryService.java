package com.deliverylens.project.service;

import com.deliverylens.project.entity.Status;
import com.deliverylens.project.entity.Story;
import com.deliverylens.project.repository.StoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.deliverylens.project.entity.Sprint;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoryService {
    private final StoryRepository repository;

    public Story createStory(Story story) {

        if (story.getStatus() == null) {
            story.setStatus(Status.TO_DO);
        }
        return repository.save(story);
    }

    public List<Story> getStoryBySprint(Long sprintId) {
        return repository.findBySprintId(sprintId);
    }

    public Story updateStatus(Long id, Status status) {
        Story story = repository.findById(id).orElseThrow(()-> new RuntimeException("Story Not Found"));
        story.setStatus(status);
        return repository.save(story);
    }
}
