package com.ouzt.issuemanagement.service;

import com.ouzt.issuemanagement.dto.ProjectDto;
import com.ouzt.issuemanagement.entity.Project;
import com.ouzt.issuemanagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ProjectService {

    Project save(Project project);

    ProjectDto getById(Long id);

    Page<Project> getAllPageable(Pageable pageable);

    Boolean delete (Project project);

    List<Project> getByProjectCode(String projectCode);

    List<Project> getByProjectCodeContains(String projectCode);



}
