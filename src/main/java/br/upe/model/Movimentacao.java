package br.upe.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Getter 
@Setter
public class Movimentacao extends Requisicao implements EntidadeBase{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private List<Produto> produtos;
	private Fornecedor fornecedor;
	private String tipo;


	public Movimentacao(Funcionario requerente, double valorTotal, Date data) {
		super(requerente, valorTotal, data);
	}
}
