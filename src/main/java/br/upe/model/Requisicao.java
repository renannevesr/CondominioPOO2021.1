package br.upe.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Requisicao {
	
	private Funcionario requerente;
	private double valorTotal;
	private Date data;

}
