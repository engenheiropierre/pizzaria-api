package br.com.uds.pizzariaapi.model;

import java.math.BigDecimal;

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
}
