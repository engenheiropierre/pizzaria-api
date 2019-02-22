package br.com.uds.pizzariaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.uds.pizzariaapi.model.Personalizacao;

@Repository
public interface Personalizacoes extends JpaRepository<Personalizacao, Long> {

}
