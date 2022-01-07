package it.frogject.business;

import it.frogject.api.ProjectApi;
import it.frogject.dto.GenericResponseDto;
import it.frogject.repositories.ProjectRepository;
import it.frogject.domain.Project;
import it.frogject.dto.ProjectDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class DefaultProjectService implements ProjectService {
    @Autowired
    ProjectRepository  projectRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<ProjectDTO> getAllProject() {
        List<Project> projects = (List<Project>) projectRepository.findAll();
        return projects.stream().map(project -> modelMapper.map(project, ProjectDTO.class)).collect(Collectors.toList());


    }

    @Override
    public GenericResponseDto insertProject(ProjectDTO projectDTO) {
        Project project =  modelMapper.map(projectDTO,Project.class);
        projectRepository.save(project);
        return new GenericResponseDto("ok","inserted");
    }
}
