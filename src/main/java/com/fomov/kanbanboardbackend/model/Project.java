package com.fomov.kanbanboardbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "projects")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String description;

	@Column(name = "date_of_created")
	private LocalDateTime dateOfCreated;

	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name = "project_user",
			joinColumns = @JoinColumn(name = "project_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users;

	@OneToMany(mappedBy = "project",
			fetch = FetchType.LAZY,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH}
	)
	private List<Task> tasks;

	@OneToMany(mappedBy = "project",
			fetch = FetchType.LAZY,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH})
	private List<ProjectStatus> projectStatuses;

	@PrePersist
	protected void onCreate() {
		dateOfCreated = LocalDateTime.now();
	}
}
