package br.upe.model.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(
	    name="apartamento", 
	    uniqueConstraints=
	        @UniqueConstraint(columnNames={"numero", "bloco"})
	)
public class Apartamento{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int numero;
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name="condomino_id")
	private Condomino condomino;
	private double taxaCondominio;
	@Enumerated (EnumType.STRING)
	private Blocos bloco;
}
