package it.frogject.controller;

import it.frogject.api.ProjectApi;
import it.frogject.business.ProjectService;
import it.frogject.dto.GenericResponseDto;
import it.frogject.dto.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController implements ProjectApi {
    @Autowired
    ProjectService projectService;

    @Override
    public ResponseEntity<List<ProjectDTO>> getAllProject() {
        return new ResponseEntity<>(projectService.getAllProject(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenericResponseDto> insertProject(ProjectDTO projectDTO) {
        return new ResponseEntity<>(projectService.insertProject(projectDTO), HttpStatus.OK);
    }
}
