package br.upe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@Entity
public class Veiculo {

	@Id @GeneratedValue
	private Long id;
	private String placa;
	private String modelo;
	private String cor;
	
	public Veiculo() {
		
	}
	
	public Veiculo (Long id, String placa, String modelo, String cor) {
		this.id = id;
		this.placa = placa;
		this.modelo = modelo;
		this.cor = cor;
	}
}
