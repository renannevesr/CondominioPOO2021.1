package br.upe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter 
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Visitante extends Pessoa{

	private int apartamento;
	
}
