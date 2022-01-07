package it.frogject.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import it.frogject.dto.ProjectDTO;
import it.frogject.dto.ResourceDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface ResourceApi {

    @Operation(summary = "Get all resources")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the resource",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProjectDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "resource not found",
                    content = @Content)})
    @RequestMapping(value = "/api/v1/resource",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<ResourceDTO>> getAllResources();
}
