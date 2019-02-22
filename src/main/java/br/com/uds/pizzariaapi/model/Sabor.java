package br.com.uds.pizzariaapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sabor")
public class Sabor implements Serializable {

	private static final long serialVersionUID = 4933332047278695973L;
	
	public static final String PFX = "sbor_";
	
	private Long id;
	private String nome;
	private Integer tempoPreparo;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = PFX + "id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Size(max = 30, message = "O número máximo de carácteres do campo Nome é de 30!")
	@NotBlank(message = "Favor preencer o campo Nome!")
	@Column(name = PFX + "nome")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Min(value = 0,  message = "O Tempo Adicional de Preparo não poder ser negativo!")
	@NotNull(message = "Favor preencher o campo Tempo Adicional de Preparo!")
	@Column(name = PFX + "tempo_preparo")
	public Integer getTempoPreparo() {
		return tempoPreparo;
	}
	public void setTempoPreparo(Integer tempoPreparo) {
		this.tempoPreparo = tempoPreparo;
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
		Sabor other = (Sabor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
