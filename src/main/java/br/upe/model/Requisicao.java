package br.upe.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Requisicao {
	
	private Funcionario requerente;
	private double valorTotal;
	private Date data;

}
