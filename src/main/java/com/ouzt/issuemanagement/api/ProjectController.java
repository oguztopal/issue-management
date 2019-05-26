package com.ouzt.issuemanagement.api;

import com.ouzt.issuemanagement.dto.ProjectDto;
import com.ouzt.issuemanagement.entity.Project;
import com.ouzt.issuemanagement.service.impl.ProjectServiceImpl;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


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
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto projectDto){
        return ResponseEntity.ok(projectService.save(projectDto));
    }
    //@RequestMapping(path = "/update" , method = RequestMethod.PUT)
    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable("id") Long id,@Valid @RequestBody ProjectDto projectDto){
        return ResponseEntity.ok(projectService.update(id,projectDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProject(@PathVariable(value = "id" , required = true) Long id){
                ProjectDto p = projectService.getById(id);
                return ResponseEntity.ok(projectService.delete(p));
    }
}
