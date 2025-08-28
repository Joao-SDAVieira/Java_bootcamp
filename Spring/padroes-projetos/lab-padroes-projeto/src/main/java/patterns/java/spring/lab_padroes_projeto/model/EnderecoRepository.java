package patterns.java.spring.lab_padroes_projeto.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Long> {

    @Query("SELECT e FROM Endereco e WHERE e.cep = :cep")
    Optional<Endereco> buscarPorCep(@Param("cep") String cep);
}
