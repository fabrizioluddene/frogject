package it.frogject.repositories;

import it.frogject.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface ProjectRepository extends CrudRepository<Project,Long> {
}
