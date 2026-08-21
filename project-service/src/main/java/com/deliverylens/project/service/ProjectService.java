package com.deliverylens.project.service;

import com.deliverylens.project.entity.Project;
import com.deliverylens.project.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository repository;

    public Project createProject(Project project){
        return repository.save(project);
    }
    public List<Project> getAllProjects(){
        return repository.findAll();
    }
}
