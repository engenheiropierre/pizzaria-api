package br.com.uds.pizzariaapi.repository.projection;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ResumoPedido {
	
	private Long id;
	private String tamanho;
	private String sabor;
	private List<String> personalizacoes;
	private BigDecimal valorTotal;
	private Integer tempoDePreparo;
	
	@JsonIgnore
	public Long getId() {
		return id;
	}
	public ResumoPedido setId(Long id) {
		this.id = id;
		return this;
	}
	
	public String getTamanho() {
		return tamanho;
	}
	public ResumoPedido setTamanho(String tamanho) {
		this.tamanho = tamanho;
		return this;
	}
	
	public String getSabor() {
		return sabor;
	}
	public ResumoPedido setSabor(String sabor) {
		this.sabor = sabor;
		return this;
	}
	
	public List<String> getPersonalizacoes() {
		return personalizacoes;
	}
	public ResumoPedido setPersonalizacoes(List<String> personalizacoes) {
		this.personalizacoes = personalizacoes;
		return this;
	}
	
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public ResumoPedido setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
		return this;
	}

	public Integer getTempoDePreparo() {
		return tempoDePreparo;
	}
	public ResumoPedido setTempoDePreparo(Integer tempoDePreparo) {
		this.tempoDePreparo = tempoDePreparo;
		return this;
	}
}
