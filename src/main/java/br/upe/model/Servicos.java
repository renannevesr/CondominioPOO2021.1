package br.upe.model;

import java.util.ArrayList;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class Servicos extends Requisicao{

	private ArrayList<Servico> servico;
	private Fornecedor prestador;
	
	public Servicos(Funcionario requerente, double valorTotal, Date data, 
			ArrayList<Servico> servico, Fornecedor prestador) {
		super(requerente, valorTotal, data);
		this.servico = servico;
		this.prestador = prestador;
	}
}
