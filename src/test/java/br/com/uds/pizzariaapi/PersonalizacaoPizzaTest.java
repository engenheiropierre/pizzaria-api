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
import br.com.uds.pizzariaapi.model.Tamanho;
import br.com.uds.pizzariaapi.model.builder.PizzaBuilder;
import br.com.uds.pizzariaapi.repository.Personalizacoes;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonalizacaoPizzaTest {

	@Autowired
	private Personalizacoes personalizacoes;
	
	private PizzaBuilder builder;
	private List<Personalizacao> listaPersonalizacoes;
	
	@Before
	public void setup() {
		this.builder = new PizzaBuilder(Tamanho.PEQUENA);
		this.listaPersonalizacoes = this.personalizacoes.findAll();
	}
	
	@Test
	public void deveCalcularOValorDaPizzaPequenaSemPersonalizacao() throws Exception {
		assertEquals(20.0, this.builder.getValorTotal(), 0.0001);
	}
	
	@Test
	public void deveCalcularOValorDaPizzaMediaSemPersonalizacao() throws Exception {
		this.builder.instance().setTamanho(Tamanho.MEDIA);
		assertEquals(30.0, this.builder.getValorTotal(), 0.0001);
	}
	
	@Test
	public void deveCalcularOValorDaPizzaGrandeSemPersonalizacao() throws Exception {
		this.builder.instance().setTamanho(Tamanho.GRANDE);
		assertEquals(40.0, this.builder.getValorTotal(), 0.0001);
	}
	
	@Test
	public void deveCalcularValorFinalAposPersonalizacao() throws Exception {
		this.builder.comPersonalizacao(this.listaPersonalizacoes);	
		assertEquals(28.0, this.builder.getValorTotal(), 0.0001);
	}
}
