package br.upe.movimentacao;

import java.util.ArrayList;

import br.upe.fornecedor.Fornecedor;
import br.upe.produto.Produto;
import br.upe.requisicao.Requisicao;

public class Movimentacao extends Requisicao{

	private ArrayList<Produto> produtos;
	private Fornecedor fornecedor;
	private String tipo;
	
}
