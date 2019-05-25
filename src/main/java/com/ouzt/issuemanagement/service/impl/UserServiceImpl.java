package com.ouzt.issuemanagement.service.impl;

import com.ouzt.issuemanagement.entity.User;
import com.ouzt.issuemanagement.repository.UserRepository;
import com.ouzt.issuemanagement.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        if (user == null){
            throw new IllegalArgumentException("user cannot be null!!");
        }
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(User user) {
        Boolean check = true ;
        try{
            userRepository.delete(user);
        }catch (Exception ex){
            ex.getMessage();
            check = false;
        }
        return check;
    }

    @Override
    public User getByUsername(String userName) {
        if (userName == null){
            throw  new IllegalArgumentException("username is null !!");
        }
        return userRepository.getByUsername(userName);
    }
}
