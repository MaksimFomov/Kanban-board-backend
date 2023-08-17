package com.fomov.kanbanboardbackend.model;

import com.fomov.kanbanboardbackend.enums.Position;
import com.fomov.kanbanboardbackend.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String email;

	private String password;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Enumerated(EnumType.STRING)
	private Position position;

	@ElementCollection(targetClass = Role.class)
	@Enumerated(EnumType.STRING)
	private Set<Role> roles;

	@Column(name = "date_of_created")
	private LocalDateTime dateOfCreated;

	private boolean active;

	@ManyToMany(mappedBy = "users",
			fetch = FetchType.LAZY,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH})
	private List<Project> projects;

	@OneToMany(mappedBy = "user",
			fetch = FetchType.LAZY,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH})
	private List<Task> tasks;

	@PrePersist
	protected void onCreate() {
		dateOfCreated = LocalDateTime.now();
		active = false;
	}
}
