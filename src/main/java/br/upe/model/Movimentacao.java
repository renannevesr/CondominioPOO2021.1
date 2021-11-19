package br.upe.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class Movimentacao extends Requisicao{

	private ArrayList<Produto> produtos;
	private Fornecedor fornecedor;
	private String tipo;
	
}
