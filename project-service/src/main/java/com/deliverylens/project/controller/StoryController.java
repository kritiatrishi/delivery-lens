package com.deliverylens.project.controller;

import com.deliverylens.project.entity.Status;
import com.deliverylens.project.entity.Story;
import com.deliverylens.project.service.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stories")
@RequiredArgsConstructor
public class StoryController {
    private final StoryService service;

    @PostMapping
    public Story createStory(@RequestBody Story story) {
        return service.createStory(story);
    }

    @GetMapping("/sprint/{sprintId}")
    public List<Story> getBySprint(@PathVariable Long sprintId) {
        return service.getStoryBySprint(sprintId);
    }

    @PatchMapping("/{id}/status")
    public Story updateStatus(@PathVariable Long id, @RequestParam Status status) {
        return service.updateStatus(id, status);
    }

}
