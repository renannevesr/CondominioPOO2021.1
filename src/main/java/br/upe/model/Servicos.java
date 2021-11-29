package br.upe.model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class Servicos extends Requisicao{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private ArrayList<Servico> servico;
	private Fornecedor prestador;
	

	public Servicos(Funcionario requerente, double valorTotal, Date data, 
			ArrayList<Servico> servico, Fornecedor prestador) {
		super(requerente, valorTotal, data);
		this.servico = servico;
		this.prestador = prestador;
	}
}
