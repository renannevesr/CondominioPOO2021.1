package br.upe.model.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Visitante extends Pessoa{

	@ManyToOne
	@JoinColumn (name = "apartamento_id")
	private Apartamento apartamento;
	
}
