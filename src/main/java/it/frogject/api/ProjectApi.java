package it.frogject.api;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import it.frogject.dto.GenericResponseDto;
import it.frogject.dto.ProjectDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


public interface ProjectApi {
    @Operation(summary = "Get all Project")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the project",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProjectDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Project not found",
                    content = @Content)})
    @RequestMapping(value = "/api/v1/project",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<ProjectDTO>> getAllProject();

    @Operation(summary = "Insert single Project")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "project inserted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProjectDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Project not found",
                    content = @Content)})
    @RequestMapping(value = "/api/v1/project",
            produces = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<GenericResponseDto> insertProject(@RequestBody ProjectDTO projectDTO);
}
