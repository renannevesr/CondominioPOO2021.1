package br.upe.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservas implements EntidadeBase{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Apartamento responsavel;
	@ManyToOne
	@JoinColumn(name = "espaco_id")
	private Espaco espaco;
	private Date dataSolicitacao;
	private Date dataUtilizacao;
	private double valor;

}
