package com.ouzt.issuemanagement.api;

import com.ouzt.issuemanagement.dto.ProjectDto;
import com.ouzt.issuemanagement.service.impl.ProjectServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/project")
public class ProjectController {

    private final ProjectServiceImpl projectService;

    public ProjectController(ProjectServiceImpl projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getById(@PathVariable("id") Long id){
        ProjectDto projectDto = projectService.getById(id);
        return ResponseEntity.ok(projectDto);
    }
    @PostMapping()
    public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectDto projectDto){
        return ResponseEntity.ok(projectService.save(projectDto));
    }

}
