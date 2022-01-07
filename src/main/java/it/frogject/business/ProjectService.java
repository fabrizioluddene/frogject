package it.frogject.business;

import it.frogject.dto.GenericResponseDto;
import it.frogject.dto.ProjectDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProjectService {
    List<ProjectDTO> getAllProject();
    GenericResponseDto insertProject(ProjectDTO projectDTO);
}
