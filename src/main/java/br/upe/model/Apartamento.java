package br.upe.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@AllArgsConstructor
public class Apartamento implements EntidadeBase{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int numero;
	private Condomino propietario;
	private ArrayList<Morador> moradores;
	private ArrayList<Veiculo> veiculos;
	private double taxaCondominio;
	
	public Apartamento() {
		
	}
	
}
