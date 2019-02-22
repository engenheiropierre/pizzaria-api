package br.com.uds.pizzariaapi.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.uds.pizzariaapi.event.RecursoCriadoEvent;
import br.com.uds.pizzariaapi.model.Sabor;
import br.com.uds.pizzariaapi.repository.Sabores;

@RestController
@RequestMapping("/sabores")
public class SaborResource {
	
	@Autowired
	private Sabores sabores;
	@Autowired
	private ApplicationEventPublisher publisher; 
	
	@GetMapping
	public List<Sabor> findAll() {
		return this.sabores.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Sabor> buscarPorId(@PathVariable("id") Long id) {
		return ResponseEntity.ok(this.sabores.findById(id).get());
	}
	
	@PostMapping
	public ResponseEntity<Sabor> criarSabor(@Valid @RequestBody Sabor sabor, HttpServletResponse response) {
		Sabor saborSalvo = this.sabores.save(sabor);
		this.publisher.publishEvent(new RecursoCriadoEvent(this, response, saborSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(saborSalvo);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable("id") Long id) {
		this.sabores.deleteById(id);
	}
}
