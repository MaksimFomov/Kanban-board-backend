package com.fomov.kanbanboardbackend.dto;

import com.fomov.kanbanboardbackend.model.Task;
import com.fomov.kanbanboardbackend.model.User;

import java.time.LocalDateTime;
import java.util.List;

public class ProjectResponseDTO {
	private String name;
	private String description;
	private LocalDateTime dateOfCreated;
	private List<User> users;
	private List<Task> tasks;

	public ProjectResponseDTO() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDateOfCreated() {
		return dateOfCreated;
	}

	public void setDateOfCreated(LocalDateTime dateOfCreated) {
		this.dateOfCreated = dateOfCreated;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
}
