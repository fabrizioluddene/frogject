package it.frogject.repositories;

import it.frogject.domain.Resource;
import org.springframework.data.repository.CrudRepository;

public interface ResourceRepository extends CrudRepository<Resource,Long> {
}
