package com.ouzt.issuemanagement.service;

import com.ouzt.issuemanagement.dto.ProjectDto;
import com.ouzt.issuemanagement.entity.Project;
import com.ouzt.issuemanagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ProjectService {

    ProjectDto save(ProjectDto project);

    ProjectDto getById(Long id);

    Page<Project> getAllPageable(Pageable pageable);

    Boolean delete (Project project);

    ProjectDto getByProjectCode(String projectCode);

    List<Project> getByProjectCodeContains(String projectCode);



}
