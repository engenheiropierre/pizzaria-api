package br.com.uds.pizzariaapi;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.uds.pizzariaapi.model.Personalizacao;
import br.com.uds.pizzariaapi.model.Sabor;
import br.com.uds.pizzariaapi.model.Tamanho;
import br.com.uds.pizzariaapi.model.builder.PizzaBuilder;
import br.com.uds.pizzariaapi.repository.Personalizacoes;
import br.com.uds.pizzariaapi.repository.Sabores;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TempoPreparoTest {
	
	@Autowired
	private Sabores sabores;
	@Autowired
	private Personalizacoes personalizacoes;
	
	private PizzaBuilder builder;
	private List<Personalizacao> listaPersonalizacoes;
	private List<Sabor> listaSabores;
	
	@Before
	public void setup() {
		this.listaPersonalizacoes = this.personalizacoes.findAll();
		this.listaSabores = this.sabores.findAll();
		this.builder = new PizzaBuilder(Tamanho.PEQUENA, this.listaSabores.get(0));
	}
	
	@Test
	public void deveCalcularOTempoDePreparoPizzaPequenaSemPersonalizacaoEComSabor() throws Exception {
		assertEquals(15, this.builder.getTempoTotal());
	}
	
	@Test
	public void deveCalcularOTempoDePreparoPizzaMediaSemPersonalizacaoEComSabor() throws Exception {
		this.builder.instance().setTamanho(Tamanho.MEDIA);
		assertEquals(20, this.builder.getTempoTotal());
	}
	
	@Test
	public void deveCalcularOTempoDePreparoPizzaGrandeSemPersonalizacaoEComSabor() throws Exception {
		this.builder.instance().setTamanho(Tamanho.GRANDE);
		assertEquals(25, this.builder.getTempoTotal());
	}
	
	@Test
	public void deveCalcularOTempoDePreparoPizzaGrandeComPersonalizacaoEComSaborPortuguesa() throws Exception {
		this.builder.instance().setTamanho(Tamanho.GRANDE);
		this.builder.instance().setPersonalizacoes(this.listaPersonalizacoes);
		this.builder.instance().setSabor(this.listaSabores.get(2));
		assertEquals(35, this.builder.getTempoTotal());
	}
}
