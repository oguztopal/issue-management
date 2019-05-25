package com.ouzt.issuemanagement.repository;

import com.ouzt.issuemanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User getByUsername(String username);

}
