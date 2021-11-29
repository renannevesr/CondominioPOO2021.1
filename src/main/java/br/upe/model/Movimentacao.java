package br.upe.model;

import java.util.ArrayList;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class Movimentacao extends Requisicao{

	private ArrayList<Produto> produtos;
	private Fornecedor fornecedor;
	private String tipo;
	
	public Movimentacao(Funcionario requerente, double valorTotal, Date data, 
			ArrayList<Produto> produtos, Fornecedor fornecedor, String tipo) {
		super(requerente, valorTotal, data);
		this.produtos = produtos;
		this.fornecedor = fornecedor;
		this.tipo = tipo;
	}
	
}
