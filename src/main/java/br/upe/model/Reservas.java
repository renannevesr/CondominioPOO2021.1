package br.upe.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter

public class Reservas {

	private Apartamento responsavel;
	private Espaco local;
	private Date dataSolicitacao;
	private Date dataUtilizacao;
	private double valor;
	
}
