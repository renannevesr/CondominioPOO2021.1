package br.upe.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class ContaReceber {

	private Date dataEmissao;
	private Date dataVencimento;
	private Date competencia;
	private double valor;
	private String status;
	private Apartamento responsavel;
	
}
