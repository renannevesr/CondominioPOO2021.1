package br.upe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@Entity
@ToString
public class Veiculo implements EntidadeBase{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String placa;
	private String modelo;
	private String cor;
	//@Column (nullable = false)
	@ManyToOne
	private Apartamento apartamento;
	
	
	public Veiculo() {
		
	}


	public Veiculo(String placa, String modelo, String cor) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.cor = cor;
	}
}
