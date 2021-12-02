package br.upe.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;


@Entity
@Data
public class Apartamento implements EntidadeBase{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int numero;
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name="propietario_id")
	private Condomino propietario;
	private double taxaCondominio;
	@OneToMany(mappedBy = "apartamento", cascade = CascadeType.ALL)
	private List<Morador> moradores;
	@OneToMany(mappedBy = "apartamento", cascade = CascadeType.ALL)
	private List<Veiculo> veiculos;
	
	public Apartamento() {
		
	}

}
