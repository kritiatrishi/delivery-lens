package com.deliverylens.project.controller;

import com.deliverylens.project.entity.Project;
import com.deliverylens.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService service;

    @PostMapping
    public Project createProject(@RequestBody Project project){
        return service.createProject(project);
    }
    @GetMapping
    public List<Project> getAllProjects(){
        return service.getAllProjects();
    }
}
