package com.deliverylens.project.service;

import com.deliverylens.project.entity.Project;
import com.deliverylens.project.entity.Sprint;
import com.deliverylens.project.repository.ProjectRepository;
import com.deliverylens.project.repository.SprintRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SprintService {
    private final SprintRepository repository;

    public Sprint createSprint(Sprint sprint){
        return repository.save(sprint);
    }
    public List<Sprint> getSprintByProject(Long projectId){
        return repository.findByProjectId(projectId);
    }
}
