package com.ouzt.issuemanagement.service;

import com.ouzt.issuemanagement.dto.IssueDto;
import com.ouzt.issuemanagement.entity.Issue;
import com.ouzt.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IssueService {

    IssueDto save (IssueDto issue);

    IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete(IssueDto issue);

}
