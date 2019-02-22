package br.com.uds.pizzariaapi.model;

import java.math.BigDecimal;
import java.util.List;

public enum Tamanho {

	PEQUENA("Pequena", new BigDecimal(20), 15),
	MEDIA("Média", new BigDecimal(30), 20),
	GRANDE("Grande", new BigDecimal(40), 25) ;
	
	private String descricao;
	private BigDecimal preco;
	private int tempoDePreparo;

	private Tamanho(String descricao, BigDecimal preco, int tempoDePreparo) {
		this.descricao = descricao;
		this.preco = preco;
		this.tempoDePreparo = tempoDePreparo;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public int getTempoDePreparo() {
		return tempoDePreparo;
	}
	
	public BigDecimal calcularValorTotal(List<Personalizacao> personalizacoes) {
		BigDecimal valorTotal = BigDecimal.ZERO;
		if (personalizacoes != null && !personalizacoes.isEmpty()) 
			valorTotal = personalizacoes.stream()
							.map(Personalizacao::getValorAdicional)
							.reduce(BigDecimal::add)
							.orElse(BigDecimal.ZERO);
		return valorTotal.add(this.getPreco());
		}

	public int calcularTempoDePreparo(List<Personalizacao> personalizacoes, Sabor sabor) {
		int tempoTotal = 0;
		if (personalizacoes != null && !personalizacoes.isEmpty())
			tempoTotal = personalizacoes.stream()
						.map(Personalizacao::getTempoDePreparoAdicional)
						.reduce(Integer::sum)
						.orElse(0);
		if (sabor != null)
			tempoTotal += sabor.getTempoPreparo();
		
		return this.getTempoDePreparo() + tempoTotal;
	}
}
