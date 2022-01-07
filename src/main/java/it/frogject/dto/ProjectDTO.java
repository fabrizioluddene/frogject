package it.frogject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {

    private Long id;
    private String projectCode;
    private String projectDescription;
    private LocalDate productionDate;
    private LocalDate testingDate;
    private LocalDate developDueDate;
    private List<ResourceDTO> resources;
}
