package br.upe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.*;

@Getter 
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Morador extends Pessoa{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Apartamento apartamento;

}
