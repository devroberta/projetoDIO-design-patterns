package one.digitalinnovation.labpadroesprojetospring.domain.repository;

import one.digitalinnovation.labpadroesprojetospring.domain.entity.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {

}
