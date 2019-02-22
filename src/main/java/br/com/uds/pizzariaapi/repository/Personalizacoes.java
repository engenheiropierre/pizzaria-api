package br.com.uds.pizzariaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.uds.pizzariaapi.model.Personalizacao;

@Repository
public interface Personalizacoes extends JpaRepository<Personalizacao, Long> {

	@Query("SELECT p FROM Personalizacao p WHERE p.id IN :ids")
	public List<Personalizacao> findAllByIdIn(List<Long> ids);
}
