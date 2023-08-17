package com.fomov.kanbanboardbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project_statuses")
public class ProjectStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@ManyToOne(fetch = FetchType.LAZY,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH}
	)
	@JoinColumn(name = "project_id")
	private Project project;

	@OneToMany(mappedBy = "projectStatus",
			fetch = FetchType.LAZY,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH})
	private List<Task> tasks;
}
