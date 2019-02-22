package br.com.uds.pizzariaapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.uds.pizzariaapi.model.Pizza;
import br.com.uds.pizzariaapi.repository.Pizzas;

@RestController
@RequestMapping("/pizzas")
public class PizzaResource {

	@Autowired
	private Pizzas pizzas;
	
	@GetMapping
	public List<Pizza> findAll() {
		return this.pizzas.findAll();
	}
}
