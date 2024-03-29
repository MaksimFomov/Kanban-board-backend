package com.fomov.kanbanboardbackend.dto;

import com.fomov.kanbanboardbackend.model.User;

import java.util.List;

public class ProjectRequestDTO {
	private String name;
	private String description;
	private List<User> users;

	public ProjectRequestDTO() {
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
