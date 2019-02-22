package br.com.uds.pizzariaapi.model.builder;

import java.util.List;

import br.com.uds.pizzariaapi.model.Personalizacao;
import br.com.uds.pizzariaapi.model.Pizza;
import br.com.uds.pizzariaapi.model.Sabor;
import br.com.uds.pizzariaapi.model.Tamanho;

public class PizzaBuilder {

	private Pizza instancia;
		
	public PizzaBuilder() {
		this.instancia = new Pizza();
	}
	
	public PizzaBuilder(Tamanho tamanho) {
		this.instancia = new Pizza();
		this.instancia.setTamanho(tamanho);
	}
	
	public PizzaBuilder(Tamanho tamanho, Sabor sabor) {
		this.instancia = new Pizza();
		this.instancia.setTamanho(tamanho);
		this.instancia.setSabor(sabor);
	}
	
	public Pizza instance() {
		return this.instancia;
	}
	
	public PizzaBuilder comPersonalizacao(List<Personalizacao> personalizacoes) {
		this.instancia.setPersonalizacoes(personalizacoes);
		return this;
	}

	public double getValorTotal() {
		return this.instancia.getTamanho().calcularValorTotal(this.instancia.getPersonalizacoes()).doubleValue();
	}

	public int getTempoTotal() {
		return this.instancia.getTamanho().calcularTempoDePreparo(this.instancia.getPersonalizacoes(), this.instancia.getSabor());
	}
}
