package com.fomov.kanbanboardbackend.repository;

import com.fomov.kanbanboardbackend.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
