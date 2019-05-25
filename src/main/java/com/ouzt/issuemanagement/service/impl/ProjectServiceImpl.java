package com.ouzt.issuemanagement.service.impl;

import com.ouzt.issuemanagement.entity.Project;
import com.ouzt.issuemanagement.repository.ProjectRepository;
import com.ouzt.issuemanagement.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project save(Project project) {

        if (project.getProjectCode()== null){
            throw new IllegalArgumentException("Project code cannot be null!!");
        }
        return projectRepository.save(project);
    }

    @Override
    public Project getById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("İd is null !!");
        }
        return projectRepository.getOne(id);
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(Project project) {
        Boolean check = true;
        try{
            projectRepository.delete(project);
        }catch (Exception ex){
            ex.printStackTrace();
            check=false;
        }
        return check;
    }

    @Override
    public List<Project> getByProjectCode(String projectCode) {
        if (projectCode==null){
            throw new IllegalArgumentException("ProjecCode is null !!");
        }
        return projectRepository.getAllByProjectCode(projectCode);
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        if (projectCode==null){
            throw new IllegalArgumentException("ProjecCode is null !!");
        }
        return projectRepository.getByProjectCodeContains(projectCode);
    }
}
