package com.fomov.kanbanboardbackend.mapper;

import com.fomov.kanbanboardbackend.dto.ProjectResponseDTO;
import com.fomov.kanbanboardbackend.model.Project;

import java.util.List;

public interface ProjectResponseMapper {
	ProjectResponseDTO toProjectResponseDTO(Project project);
	List<ProjectResponseDTO> toProjectResponseDTOs(List<Project> projects);
}
