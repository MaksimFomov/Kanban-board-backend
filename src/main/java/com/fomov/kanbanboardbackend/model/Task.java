package com.fomov.kanbanboardbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String description;

	private String estimate;

	@Column(name = "date_of_created")
	private LocalDateTime dateOfCreated;

	@ManyToOne(fetch = FetchType.LAZY,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH}
	)
	@JoinColumn(name = "project_id")
	private Project project;

	@ManyToOne(fetch = FetchType.LAZY,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH}
	)
	@JoinColumn(name = "project_status_id")
	private ProjectStatus projectStatus;

	@ManyToOne(fetch = FetchType.LAZY,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH}
	)
	@JoinColumn(name = "project_priority_id")
	private ProjectPriority projectPriority;

	@ManyToOne(fetch = FetchType.LAZY,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH}
	)
	@JoinColumn(name = "project_sprint_id")
	private ProjectSprint projectSprint;

	@PrePersist
	protected void onCreate() {
		dateOfCreated = LocalDateTime.now();
	}
}
