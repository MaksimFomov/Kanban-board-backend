package com.fomov.kanbanboardbackend.facade.impl;

import com.fomov.kanbanboardbackend.dto.ProjectRequestDTO;
import com.fomov.kanbanboardbackend.dto.ProjectResponseDTO;
import com.fomov.kanbanboardbackend.facade.ProjectFacade;
import com.fomov.kanbanboardbackend.mapper.ProjectRequestMapper;
import com.fomov.kanbanboardbackend.mapper.ProjectResponseMapper;
import com.fomov.kanbanboardbackend.model.Project;
import com.fomov.kanbanboardbackend.model.User;
import com.fomov.kanbanboardbackend.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectFacadeImpl implements ProjectFacade {
	private final ProjectService projectService;
	private final ProjectRequestMapper projectRequestMapper;
	private final ProjectResponseMapper projectResponseMapper;

	@Override
	public List<ProjectResponseDTO> getAllProject() {
		List<Project> projects = projectService.getAllProject();
		return projectResponseMapper.toProjectResponseDTOs(projects);
	}

	@Override
	public ProjectResponseDTO getProjectById(Long projectId) {
		Project project = projectService.getProjectById(projectId);
		return projectResponseMapper.toProjectResponseDTO(project);
	}

	@Override
	public ProjectResponseDTO createProject(ProjectRequestDTO projectRequestDTO) {
		Project project = projectService.createProject(projectRequestMapper.toProject(projectRequestDTO));
		return projectResponseMapper.toProjectResponseDTO(project);
	}

	@Override
	public void deleteProject(Long projectId) {
		projectService.deleteProject(projectId);
	}

	@Override
	public ProjectResponseDTO updateProject(Long projectId, ProjectRequestDTO updatedProjectRequestDTO) {
		Project project = projectService.updateProject(projectId, projectRequestMapper.toProject(updatedProjectRequestDTO));
		return projectResponseMapper.toProjectResponseDTO(project);
	}

	@Override
	public void addUsersToProject(Long projectId, List<Long> userIds) {
		projectService.addUsersToProject(projectId, userIds);
	}

	@Override
	public void deleteUsersFromProject(Long projectId, List<Long> userIds) {
		projectService.deleteUsersFromProject(projectId, userIds);
	}

	@Override
	public void addSprintToProject(Long projectId, String sprintName) {

	}

	@Override
	public void addPriorityToProject(Long projectId, String priorityName) {

	}

	@Override
	public void addStatusToProject(Long projectId, String statusName) {

	}
}
