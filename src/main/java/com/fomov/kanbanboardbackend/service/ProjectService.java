package com.fomov.kanbanboardbackend.service;

import com.fomov.kanbanboardbackend.model.Project;
import com.fomov.kanbanboardbackend.model.User;

import java.util.List;

public interface ProjectService {
	List<Project> getAllProject();
	Project getProjectById(Long projectId);

	Project createProject(Project project);
	void deleteProject(Long projectId);
	Project updateProject(Long projectId, Project updatedProject);

	void addUsersToProject(Long projectId, List<Long> userIds);
	void deleteUsersFromProject(Long projectId, List<Long> userIds);

	void addSprintToProject(Long projectId, String sprintName);
	void addPriorityToProject(Long projectId, String priorityName);
	void addStatusToProject(Long projectId, String statusName);
}
