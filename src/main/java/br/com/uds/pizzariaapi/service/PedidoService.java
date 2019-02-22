package br.com.uds.pizzariaapi.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uds.pizzariaapi.model.Pedido;
import br.com.uds.pizzariaapi.model.Personalizacao;
import br.com.uds.pizzariaapi.model.Sabor;
import br.com.uds.pizzariaapi.model.Tamanho;
import br.com.uds.pizzariaapi.repository.Pedidos;
import br.com.uds.pizzariaapi.repository.Personalizacoes;
import br.com.uds.pizzariaapi.repository.Sabores;
import br.com.uds.pizzariaapi.repository.projection.ResumoPedido;

@Service
public class PedidoService {

	@Autowired
	private Pedidos pedidos;
	@Autowired
	private Sabores sabores;
	@Autowired
	private Personalizacoes personalizacoes;
	
	@Transactional
	public ResumoPedido salvar(Pedido pedido) {
		Sabor sabor = null;
		Tamanho tamanho = null;
		List<Personalizacao> personalizacoes = null;
		if (pedido.getPizza().getSabor() != null) {
			sabor = this.sabores.findById(pedido.getPizza().getSabor().getId()).get();
		}
	
		if (pedido.getPizza().getPersonalizacoes() != null && !pedido.getPizza().getPersonalizacoes().isEmpty()) {
			List<Long> ids = new ArrayList<Long>();
			pedido.getPizza().getPersonalizacoes().forEach(p -> ids.add(p.getId()));
			personalizacoes = this.personalizacoes.findAllByIdIn(ids);
		}
		
		if (pedido.getPizza().getTamanho() != null) {
			tamanho = pedido.getPizza().getTamanho();
			pedido.setValorTotal(tamanho.calcularValorTotal(personalizacoes));
			pedido.setTempoPreparo(tamanho.calcularTempoDePreparo(personalizacoes, sabor));
		}
			
		
		return getResumoPedido(this.pedidos.save(pedido).getId());
	}
	
	private ResumoPedido getResumoPedido(Long id) {
		
		Pedido pedido = this.pedidos.buscarPorId(id);
		Sabor sabor = this.sabores.findById(pedido.getPizza().getSabor().getId()).get();

		List<String> personalizacoes = new ArrayList<String>();
		if (pedido.getPizza().getPersonalizacoes() != null && !pedido.getPizza().getPersonalizacoes().isEmpty()) {
			List<Long> ids = new ArrayList<Long>();
			pedido.getPizza().getPersonalizacoes().forEach(p -> ids.add(p.getId()));
			this.personalizacoes.findAllByIdIn(ids).forEach(p -> personalizacoes.add(p.getNome()));
		}
		
		return new ResumoPedido()
					.setId(pedido.getId())
					.setSabor(sabor.getNome())
					.setPersonalizacoes(personalizacoes)
					.setValorTotal(pedido.getValorTotal())
					.setTempoDePreparo(pedido.getTempoPreparo())
					.setTamanho(pedido.getPizza().getTamanho().getDescricao());
	}
}
