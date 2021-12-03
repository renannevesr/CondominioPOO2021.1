package br.upe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Requisicao implements EntidadeBase{
	
	private Funcionario requerente;
	private double valorTotal;
	private Date data;

}
