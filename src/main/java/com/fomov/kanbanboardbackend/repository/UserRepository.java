package com.fomov.kanbanboardbackend.repository;

import com.fomov.kanbanboardbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

