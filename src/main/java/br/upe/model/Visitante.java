package br.upe.model;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@Entity
public class Visitante extends Pessoa{

	private int apartamento;	
	
	public Visitante() {
		
	}
	
}
