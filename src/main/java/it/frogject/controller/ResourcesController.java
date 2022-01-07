package it.frogject.controller;

import it.frogject.api.ResourceApi;
import it.frogject.business.ResourceService;
import it.frogject.dto.ProjectDTO;
import it.frogject.dto.ResourceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResourcesController implements ResourceApi {
    @Autowired
    private ResourceService resourceService;

    @Override
    public ResponseEntity<List<ResourceDTO>> getAllResources() {

        return new ResponseEntity<List<ResourceDTO>>(resourceService.getAllResources(), HttpStatus.OK);

    }
}
