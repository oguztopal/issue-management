package com.ouzt.issuemanagement.dto;

import com.ouzt.issuemanagement.entity.IssueStatus;
import com.ouzt.issuemanagement.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class IssueDto {
    private Long id;

    private String description;

    private String details;

    private Date date;

    private IssueStatus issueStatus;

    private UserDto assignee;

    private ProjectDto project;


}
