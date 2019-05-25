package com.ouzt.issuemanagement.repository;

import com.ouzt.issuemanagement.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository  extends JpaRepository<Issue , Long> {

}
