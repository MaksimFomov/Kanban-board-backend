package com.fomov.kanbanboardbackend.service.impl;

import com.fomov.kanbanboardbackend.model.Project;
import com.fomov.kanbanboardbackend.model.User;
import com.fomov.kanbanboardbackend.repository.ProjectRepository;
import com.fomov.kanbanboardbackend.repository.UserRepository;
import com.fomov.kanbanboardbackend.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {
	private final ProjectRepository projectRepository;
	private final UserRepository userRepository;

	@Override
	public List<Project> getAllProject() {
		return projectRepository.findAll();
	}

	@Override
	public Project getProjectById(Long projectId) {
		return projectRepository.findById(projectId).orElse(null);
	}

	@Override
	public Project createProject(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public void deleteProject(Long projectId) {
		projectRepository.deleteById(projectId);
	}

	@Override
	public Project updateProject(Long projectId, Project updatedProject) {
		Project existingProject = projectRepository.findById(projectId).orElse(null);

		existingProject.setName(updatedProject.getName());
		existingProject.setDescription(updatedProject.getDescription());

		return projectRepository.save(existingProject);
	}

	@Override
	public void addUsersToProject(Long projectId, List<Long> userIds) {
		Project project = projectRepository.findById(projectId).orElse(null);

		List<User> users = userRepository.findAllById(userIds);
		project.getUsers().addAll(users);

		projectRepository.save(project);
	}

	@Override
	public void deleteUsersFromProject(Long projectId, List<Long> userIds) {
		Project project = projectRepository.findById(projectId).orElse(null);

		List<User> users = userRepository.findAllById(userIds);
		project.getUsers().removeAll(users);

		projectRepository.save(project);
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
