package com.fomov.kanbanboardbackend.mapper;

import com.fomov.kanbanboardbackend.dto.ProjectRequestDTO;
import com.fomov.kanbanboardbackend.model.Project;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectRequestMapper {
	Project toProject(ProjectRequestDTO projectRequestDTO);
}
