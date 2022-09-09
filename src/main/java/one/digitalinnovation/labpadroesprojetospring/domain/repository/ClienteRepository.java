package one.digitalinnovation.labpadroesprojetospring.domain.repository;

import one.digitalinnovation.labpadroesprojetospring.domain.entity.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
