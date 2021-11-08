package br.com.avaliacoes.states.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.avaliacoes.states.modelo.States;


public interface StatesRepository extends JpaRepository<States, Long>{
	List<States> findByNome(String nome);

	List<States> findByRegiao(String regiao);

	Page<States> findByRegiao(String regiao, Pageable paginacao);
}
