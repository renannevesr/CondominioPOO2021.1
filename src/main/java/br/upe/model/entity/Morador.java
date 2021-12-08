package br.upe.model.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.*;

@Getter 
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Morador extends Pessoa{

	@ManyToOne
	@JoinColumn (name = "apartamento_id")
	private Apartamento apartamento;

}
