package br.upe.model;

import java.util.ArrayList;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@AllArgsConstructor
public class ContaReceber {

	private Date dataEmissao;
	private Date dataVencimento;
	private Date competencia;
	private double valor;
	private String status;
	private Apartamento responsavel;
	
}
