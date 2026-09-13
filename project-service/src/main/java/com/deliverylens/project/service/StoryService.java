package com.deliverylens.project.service;

import com.deliverylens.project.entity.Status;
import com.deliverylens.project.entity.Story;
import com.deliverylens.project.event.StoryEventProducer;
import com.deliverylens.project.event.StoryStatusChangedEvent;
import com.deliverylens.project.repository.StoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoryService {
    private final StoryRepository repository;

    //    @Autowired
    //in case it is not constructor injection
    private final StoryEventProducer storyEventProducer;

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

        Story story = repository.findById(id).orElseThrow(() -> new RuntimeException("Story Not Found"));
        Status oldStatus=story.getStatus();
        story.setStatus(status);
        Story updatedStory=repository.save(story);
        StoryStatusChangedEvent event=new StoryStatusChangedEvent(updatedStory.getId(), updatedStory.getSprintId(),oldStatus!=null? oldStatus.name():null,updatedStory.getStatus().name());
        storyEventProducer.publishStatusChanged(event);
        return updatedStory;
//        return repository.save(story);
    }
}
