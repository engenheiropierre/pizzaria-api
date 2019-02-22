package br.com.uds.pizzariaapi.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.uds.pizzariaapi.model.Tamanho;

@RestController
@RequestMapping("/tamanhos")
public class TamanhoResource {

	@GetMapping
	public Tamanho[] findAll() {
		return Tamanho.values();
	}
}
