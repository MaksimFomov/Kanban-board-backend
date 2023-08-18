package com.fomov.kanbanboardbackend.facade;

import com.fomov.kanbanboardbackend.dto.ProjectRequestDTO;
import com.fomov.kanbanboardbackend.dto.ProjectResponseDTO;
import com.fomov.kanbanboardbackend.model.Project;
import com.fomov.kanbanboardbackend.model.User;

import java.util.List;

public interface ProjectFacade {
	List<ProjectResponseDTO> getAllProject();
	ProjectResponseDTO getProjectById(Long projectId);

	ProjectResponseDTO createProject(ProjectRequestDTO projectRequestDTO);
	void deleteProject(Long projectId);
	ProjectResponseDTO updateProject(Long projectId, ProjectRequestDTO updatedProjectRequestDTO);

	void addUsersToProject(Long projectId, List<Long> userIds);
	void deleteUsersFromProject(Long projectId, List<Long> userIds);

	void addSprintToProject(Long projectId, String sprintName);
	void addPriorityToProject(Long projectId, String priorityName);
	void addStatusToProject(Long projectId, String statusName);
}
