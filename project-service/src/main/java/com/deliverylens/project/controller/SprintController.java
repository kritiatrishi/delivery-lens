package com.deliverylens.project.controller;

import com.deliverylens.project.entity.Sprint;
import com.deliverylens.project.service.SprintService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sprints")
@RequiredArgsConstructor
public class SprintController {
    private final SprintService service;

    @PostMapping
    public Sprint createSprint(@RequestBody Sprint sprint){
        return service.createSprint(sprint);
    }
    @GetMapping("/project/{projectId}")
    public List<Sprint> getByProject(@PathVariable Long projectId){
        return service.getSprintByProject(projectId);
    }
}
