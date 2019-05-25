package com.ouzt.issuemanagement.service.impl;

import com.ouzt.issuemanagement.entity.Issue;
import com.ouzt.issuemanagement.entity.IssueHistory;
import com.ouzt.issuemanagement.repository.IssueHistoryRepository;
import com.ouzt.issuemanagement.service.IssueHistoryService;
import com.ouzt.issuemanagement.service.IssueService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public  class IssueHistoryImpl implements IssueHistoryService {

    private final IssueHistoryRepository issueHistoryRepository;

    public IssueHistoryImpl(IssueHistoryRepository issueHistoryRepository) {
        this.issueHistoryRepository = issueHistoryRepository;
    }


    @Override
    public IssueHistory save(IssueHistory issueHistory) {
        if (issueHistory == null) {
            throw new IllegalArgumentException("issueHistory cannot be null!!");
        }
        return issueHistoryRepository.save(issueHistory);
    }

    @Override
    public IssueHistory getById(Long id) {
        return issueHistoryRepository.getOne(id);
    }

    @Override
    public Page<IssueHistory> getAllPageable(Pageable pageable) {
        return issueHistoryRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(IssueHistory ıssueHistory) {
        Boolean check = true;
        try{
            issueHistoryRepository.delete(ıssueHistory);
        }catch (Exception ex){
            ex.getMessage();
            check = false;
        }
        return check;
    }
}
