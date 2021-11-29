package br.upe.model;

import java.util.Date;

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
public class Reservas implements EntidadeBase{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Apartamento responsavel;
	private Espaco local;
	private Date dataSolicitacao;
	private Date dataUtilizacao;
	private double valor;
	
	public Reservas() {
		
	}
	
}
