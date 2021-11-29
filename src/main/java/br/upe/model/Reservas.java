package br.upe.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@AllArgsConstructor
public class Reservas {

	private Apartamento responsavel;
	private Espaco local;
	private Date dataSolicitacao;
	private Date dataUtilizacao;
	private double valor;
	
}
