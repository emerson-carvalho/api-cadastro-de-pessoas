package br.com.attornatus.api.pessoas.repository;

import br.com.attornatus.api.pessoas.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    List<Pessoa> findByNomeContainingIgnoreCase(String nome);
}
