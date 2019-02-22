package br.com.uds.pizzariaapi.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.uds.pizzariaapi.event.RecursoCriadoEvent;
import br.com.uds.pizzariaapi.model.Pedido;
import br.com.uds.pizzariaapi.repository.Pedidos;
import br.com.uds.pizzariaapi.repository.projection.ResumoPedido;
import br.com.uds.pizzariaapi.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoResource {

	@Autowired
	private Pedidos pedidos;
	@Autowired
	private PedidoService perdidoService;
	@Autowired
	private ApplicationEventPublisher publisher; 
	
	@GetMapping
	public List<Pedido> findAll() {
		return this.pedidos.findAll();
	}

	@PostMapping
	public ResponseEntity<ResumoPedido> criarPedido(@Valid @RequestBody Pedido pedido, HttpServletResponse response) {
		ResumoPedido pedidoSalvo = this.perdidoService.salvar(pedido);
		
		this.publisher.publishEvent(new RecursoCriadoEvent(this, response, pedidoSalvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoSalvo);
	}
}
