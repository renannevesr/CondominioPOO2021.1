package br.upe.model;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter

public class Produto {

	private String marca;
	private TipoProduto tipo;
	private String descricao;
	private int quantidade;
	private double volume;
	private double valor;
	
}
