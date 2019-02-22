package br.com.uds.pizzariaapi.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pizza")
public class Pizza implements Serializable {

	private static final long serialVersionUID = 5629885856916599772L;
	
	public static final String PFX = "pzza_";
	
	private Long id;
	private Sabor sabor;
	private Tamanho tamanho;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = PFX + "id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotNull(message = "Favor selecionar um sabor!")
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = PFX + "sabor_id")
	public Sabor getSabor() {
		return sabor;
	}
	public void setSabor(Sabor sabor) {
		this.sabor = sabor;
	}
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Favor selecionar um Tamanho!")
	@Column(name = PFX + "tamanho")
	public Tamanho getTamanho() {
		return tamanho;
	}
	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
