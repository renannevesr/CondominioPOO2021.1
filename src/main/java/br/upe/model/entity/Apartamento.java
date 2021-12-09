package br.upe.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Apartamento{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int numero;
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name="condomino_id")
	private Condomino condomino;
	private double taxaCondominio;
	private String bloco;
}