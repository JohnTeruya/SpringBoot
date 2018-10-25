package br.com.doacoesapp.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.doacoesapp.models.Doacao;
import br.com.doacoesapp.models.Doador;

public interface RepositoryDoador extends CrudRepository<Doador, String>{
	Iterable<Doador> findByDoacao(Doacao doacao);
}
