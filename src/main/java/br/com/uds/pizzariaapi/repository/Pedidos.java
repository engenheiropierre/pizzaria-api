package br.com.uds.pizzariaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.uds.pizzariaapi.model.Pedido;
import br.com.uds.pizzariaapi.repository.helper.pedido.PedidosQueries;

@Repository
public interface Pedidos extends JpaRepository<Pedido, Long>, PedidosQueries {

}
