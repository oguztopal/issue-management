package com.ouzt.issuemanagement.service.impl;

import com.ouzt.issuemanagement.dto.IssueDto;
import com.ouzt.issuemanagement.entity.Issue;
import com.ouzt.issuemanagement.entity.User;
import com.ouzt.issuemanagement.repository.IssueRepository;
import com.ouzt.issuemanagement.repository.UserRepository;
import com.ouzt.issuemanagement.service.IssueService;
import com.ouzt.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository ;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public IssueServiceImpl(IssueRepository issueRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.issueRepository = issueRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public IssueDto save(IssueDto issue) {
        if (issue.getDate()==null){
            throw new IllegalArgumentException("Date cannot be null!!");
        }
        Issue issueDb = modelMapper.map(issue,Issue.class);
        issueDb= issueRepository.save(issueDb);
        return modelMapper.map(issueDb,IssueDto.class);
    }

    @Override
    public IssueDto getById(Long id) {
        return null;
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
        Page<Issue> data =  issueRepository.findAll(pageable);
        TPage page = new TPage<IssueDto>();
        IssueDto[] dtos =  modelMapper.map(data.getContent(),IssueDto[].class);
        page.setStat(data, Arrays.asList(dtos));
        return page;
    }

    @Override
    public Boolean delete(Long issueId) {
        issueRepository.deleteById(issueId);
        return true;
    }

    public IssueDto update(Long id, IssueDto issueDto) {
        Issue issue = issueRepository.getOne(id);
        if (issue == null ){
            throw new IllegalArgumentException("Böyle Bir Issue bulunmamakta.!!");
        }
        issue.setIssueStatus(issueDto.getIssueStatus());
        issue.setDate(issueDto.getDate());
        issue.setDescription(issueDto.getDescription());
        User user = userRepository.getByUsername(issue.getAssignee().getUsername());
        if (user==null){
            throw new IllegalArgumentException("Assign etmek istediğiniz username sistemde kayıtlı değil");
        }
        issue.setAssignee(user);
        issue.setIssueStatus(issueDto.getIssueStatus());
        issue.setDetails(issueDto.getDetails());
        return modelMapper.map(issue,IssueDto.class);
    }
}
