package br.com.doacoesapp.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.doacoesapp.models.Doacao;

public interface DoacaoRepository extends CrudRepository<Doacao, String>{

}
